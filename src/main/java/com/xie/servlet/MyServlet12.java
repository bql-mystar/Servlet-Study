package com.xie.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/demo12")
public class MyServlet12 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("MyServlet12......");
        // 手写重定向
        // 1、设置状态码为302
//        resp.setStatus(302);
        // 2、设置响应头location
//        resp.setHeader("location", "/myServlet/demo13");

        // 简单的重定向方法
        resp.sendRedirect("/myServlet/demo13");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
