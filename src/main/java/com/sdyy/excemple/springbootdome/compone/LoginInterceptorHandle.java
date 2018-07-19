package com.sdyy.excemple.springbootdome.compone;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 重写连接器
 */
public class LoginInterceptorHandle implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
         Object user = httpServletRequest.getSession().getAttribute("loginUser");
         if(user != null){
             return true;
         }else {
             httpServletRequest.setAttribute("msg","没有权限，请先登录");
             httpServletRequest.getRequestDispatcher("/index.html").forward(httpServletRequest,httpServletResponse);
             return false;
        }

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
