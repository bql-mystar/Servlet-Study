package com.xie.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;


@WebServlet("/demo06")
public class MyServlet06 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // String getHeader(String name)：通过请求头的名称获取请求头的值
        // Enumeration<String> getHeaderNames()：获取所有的请求头名称
        Enumeration<String> headerNames = req.getHeaderNames();
        // 遍历枚举
        while (headerNames.hasMoreElements()){
            String name = headerNames.nextElement();
            System.out.println(name + "\t" + req.getHeader(name));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
