package com.xie.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * Servlet的生命周期
 * 1、被创建：执行init方法，只执行一次
 *        Servlet什么时候被创建？
 *                  默认情况下，第一次访问时，Servlet被创建
 *                  可以配置执行Servlet的创建时机，通过配置web.xml中的<load-on-startup>标签的值及性能配置
 *                  一般用于加载资源
 *
 *         Servlet的init方法只执行一次，说明一个Servlet在内存中只存在一个对象，Servlet是单例的
 *                  多个用户同时访问，可能存在线程安全问题
 *                  解决：尽量不要在Servlet中定义成员变量，即使定义了成员变量，也不要修改值
 *
 * 2、提供服务：执行service方法，执行多次
 *         每次访问Servlet时，Service方法都会被调用一次
 *
 * 3、被销毁：执行destroy方法，只执行一次
 *          Servlet被销毁时执行，服务器关闭时，Servlet被销毁，
 *          只有服务器正常关闭时，才会执行destroy方法
 *          是在Servlet被销毁前执行，一般用于释放资源
 */
public class MyServlet01 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        // 初始化方法，再Servlet被创建时执行，只会执行一次
        System.out.println("init......");

    }

    @Override
    public ServletConfig getServletConfig() {
        // 获取ServletConfig对象，
        // ServletConfig:Servlet的配置对象
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        // 提供服务的方法，每一次Servlet被访问时执行，执行多次
        System.out.println("service......");
    }

    @Override
    public String getServletInfo() {
        // 获取Servlet的一些信息，版本、作者等
        return null;
    }

    @Override
    public void destroy() {
        // 销毁方法，在服务器正常关闭时执行，只执行一次
        System.out.println("destroy......");
    }
}
