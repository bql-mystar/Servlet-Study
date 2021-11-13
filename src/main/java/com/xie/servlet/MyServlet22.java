package com.xie.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.net.*;


@WebServlet("/demo22")
public class MyServlet22 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 记住上一次访问时间
        // 1、如果是第一次访问，则提示：你好，欢迎您首次访问
        // 2、如果不是第一次访问，则提示：欢迎回来，上一次访问时间为：显示时间字符串

        // 设置响应体的编码方式
        resp.setContentType("text/html;charset=utf-8");
        Cookie[] cookies = req.getCookies();
        String prevTime = getCookieByName(cookies, "prevTime");

        // 获取当前时间戳
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳

        // 注意：cookie中不可以有特殊字符，比如：空格   对于有特殊符号的可以使用url编码进行解决
        if (prevTime == null){
            // 说明是第一次访问
            resp.getWriter().write("<h1>你好，欢迎您首次访问</h1>");
        }else {
            // 说明不是第一次访问，则获取上一次访问时间，并更新cookie的值
            resp.getWriter().write("<h1>上一次访问时间为：" + URLDecoder.decode(prevTime, "utf-8") + "</h1>");
        }

        Cookie cookie = new Cookie("prevTime", URLEncoder.encode(date, "utf-8"));
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    /**
     * 该方法可以根据指定的cookie名返回对应的cookie的值
     * @param cookies 传入cookie列表
     * @param name 需要查找的cookie名
     * @return 如果存在对应的cookie，则返回cookie对应的值，否则返回null
     */
    public static String getCookieByName(Cookie[] cookies, String name){
        if (cookies != null && cookies.length > 0){
            for (Cookie cookie : cookies) {
                if (name.equals(cookie.getName())){
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
}
