package com.qiao.interception;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterception implements HandlerInterceptor {
    private int number = 0;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean res = false;
        
        String success = (String) request.getSession().getAttribute("success");
        System.out.println("拦截器工作！");
        System.out.println("success====="+success);
        System.out.println("第"+number+"次请求！");
        number += 1;
        if(success != null){
            res = "success".equals(success);
        }
        if(!res){
            request.getRequestDispatcher("userLogin.jsp").forward(request,response);
        }
        return res;
    }


}
