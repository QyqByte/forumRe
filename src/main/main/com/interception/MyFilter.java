package com.qiao.interception;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

@Component
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器开始工作。。。。。。。。。");
        /*Enumeration<String> attributeNames = servletRequest.getAttributeNames();
        while (attributeNames.hasMoreElements()){
            System.out.println(attributeNames.nextElement());
        }*/
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("过滤器结束工作。。。。。。。。。");
    }

    @Override
    public void destroy() {

    }
}
