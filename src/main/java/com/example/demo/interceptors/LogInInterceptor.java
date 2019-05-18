package com.example.demo.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
 
@Component
public class LogInInterceptor extends HandlerInterceptorAdapter {
 
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        long startTime = System.currentTimeMillis();
        System.out.println("\n-------- LogInterception.preHandle --- ");
        System.out.println("Request URL: " + request.getRequestURL());
        System.out.println("Start Time: " + System.currentTimeMillis());
       
        if(request.getSession().getAttribute("name")==null){

            request.getSession().setAttribute("name","Jake");
            System.out.println("request.getSession().setAttribute " +request.getSession().getAttribute("name") );
        }
        System.out.println("request.getSession() " +request.getSession().getAttribute("name") );
        
        request.setAttribute("startTime", startTime);
 
        return true;
    }
 
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, //
            Object handler, ModelAndView modelAndView) throws Exception {
 
        System.out.println("\n-------- LogInterception.postHandle --- ");
        System.out.println("Request URL: " + request.getRequestURL());
 
        // You can add attributes in the modelAndView
        // and use that in the view page
    }
 
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, //
            Object handler, Exception ex) throws Exception {
        System.out.println("\n-------- LogInterception.afterCompletion --- ");
 
        long startTime = (Long) request.getAttribute("startTime");
        long endTime = System.currentTimeMillis();
        System.out.println("Request URL: " + request.getRequestURL());
        System.out.println("End Time: " + endTime);
 
        System.out.println("Time Taken: " + (endTime - startTime));
    }
 
}