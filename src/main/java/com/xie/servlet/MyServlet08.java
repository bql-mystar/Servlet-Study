package com.xie.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;


@WebServlet("/demo08")
public class MyServlet08 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String username = req.getParameter("username");
//        System.out.println("get" + "\t" + username);
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String username = req.getParameter("username");
//        System.out.println("post" + "\t" + username);

//        String[] hobbies = req.getParameterValues("hobby");
//        for (String hobby : hobbies) {
//            System.out.println(hobby);
//        }

        // 获取所有请求的参数名称
//        Enumeration<String> parameterNames = req.getParameterNames();
//        while (parameterNames.hasMoreElements()){
//            System.out.println(parameterNames.nextElement());
//        }

        // 获取所有参数的map集合
        Map<String, String[]> parameterMap = req.getParameterMap();
        // 遍历
        for (String s : parameterMap.keySet()) {
            // 根据键获取值
//            System.out.println(parameterMap.get(s).toString());
            for (String s1 : parameterMap.get(s)) {
                System.out.println(s1);
            }
            System.out.println("====================");
        }
    }
}
