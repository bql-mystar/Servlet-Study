package com.xie.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/demo19")
public class MyServlet19 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取MIME类型
        ServletContext context = this.getServletContext();

        // 获取文件的真实(服务器)路径
        // 1、获取web目录下的文件，直接以/开头
        String a = context.getRealPath("/a.txt");
        System.out.println(a);

        // 2、获取WEB-INF目录下的文件，直接以/WEB-INF开头
        String b = context.getRealPath("/WEB-INF/b.txt");
        System.out.println(b);

        // 3、获取src目录下的文件，直接以/WEB-INF/classes开头
        // 放在src目录下的文件最后会被放到WEB-INF下的classes目录
        String c = context.getRealPath("/WEB-INF/classes/c.txt");
        System.out.println(c);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
