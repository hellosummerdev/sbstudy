package com.sbstudy.common;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CustomInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
        //        HttpSession session = request.getSession(false);
//        String requestURI = request.getRequestURI();
//        System.out.println("uri = " + requestURI);
////        System.out.println("id = " + id);
////
//        if (requestURI.equals("/user/login") || session.getAttribute("id") != null) {
//            System.out.println("1");
//            return true;
//        } else {
//            System.out.println("2");
//            response.sendRedirect("/user/login");
//            return false;
//        }

//        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
