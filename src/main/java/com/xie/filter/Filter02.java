package com.xie.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

// 使用web.xml配置过滤器
// 定义一个过滤器
public class Filter02 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 对request对象请求数据增强
        System.out.println("Filter02被执行了......");
        filterChain.doFilter(servletRequest, servletResponse);
        // 对response响应请求数据增强
        System.out.println("Filter02回来了......");
    }

    @Override
    public void destroy() {

    }
}
