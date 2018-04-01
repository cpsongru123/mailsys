package com.pltm.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginIntercepter implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        boolean isIn = request.getSession().getAttribute("user")!=null;
        System.out.println("username in scession:"+isIn);
        System.out.println("check in handler, secession in "+request.getRequestURI()+": "+request.getSession());
        if(!isIn) {
            response.sendRedirect("/");
            return false;
        }
        return true;
    }
}
