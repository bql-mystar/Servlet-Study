package com.xie.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServletContextListener01 implements ServletContextListener {
    /**
     * 监听ServletContext对象创建，ServletContext对象服务器启动后自动创建
     * @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ServletContextListener01对象被创建......");
    }

    /**
     * 在服务器关闭后，ServletContext对象被销毁，当服务器正常关闭后该方法被调用
     * @param sce
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContextListener01对象被销毁......");
    }
}
