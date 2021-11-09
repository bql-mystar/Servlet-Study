package com.xie.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/demo05")
public class MyServlet05 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求方式：String getMethod()
        System.out.println(req.getMethod());
        System.out.println("==========");
        // 获取虚拟目录：String getContextPath()
        System.out.println(req.getContextPath());
        System.out.println("==========");
        // 获取Servlet路径：String getServletPath()
        System.out.println(req.getServletPath());
        System.out.println("==========");
        // 获取get方式请求参数：String getQueryString()
        System.out.println(req.getQueryString());
        System.out.println("==========");
        // 获取请求的URI：String getRequestURI()  String getRequestURL()
        System.out.println(req.getRequestURI());
        System.out.println(req.getRequestURL());
        System.out.println("==========");
        // 获取协议及版本：String getProtocol()
        System.out.println(req.getProtocol());
        System.out.println("==========");
        // 获取客户机的ip地址：String getRemoteAddr()
        System.out.println(req.getRemoteAddr());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
