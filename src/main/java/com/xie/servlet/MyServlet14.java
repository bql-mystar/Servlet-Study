package com.xie.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/demo14")
public class MyServlet14 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 解决输出流乱码问题
        // 在获取流对象之前，设置流的默认编码，默认是ISO-8859-1，设置为GBK
//        resp.setCharacterEncoding("utf-8");

        // 告诉浏览器，服务器发送的消息体数据的编码，建议浏览器使用该编码解码
//        resp.setHeader("Content-Type", "text/html;charset=utf-8");

        // 简单形式，设置编码
        resp.setContentType("text/html;charset=utf-8");

        // 获取字符输出流
        PrintWriter pw = resp.getWriter();
        // 输出数据
//        pw.write("hello response");
        pw.write("<h1>你好啊啊啊 response</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
