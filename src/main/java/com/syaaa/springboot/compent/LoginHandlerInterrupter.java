package com.syaaa.springboot.compent;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName LoginHandlerInterrupter
 * @Description TODO
 * @Author APPO
 * @Date 13:09   2018-9-18
 * @Version 1.0
 **/
public class LoginHandlerInterrupter implements HandlerInterceptor {
    /*访问之前记性页面拦截*/

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        Object loginUser = httpServletRequest.getSession().getAttribute("loginUser");
        if (StringUtils.isEmpty(loginUser)) {
            /*未登录，进行页面转发*/
            httpServletRequest.setAttribute("msg","没有权限访问当前界面");
            httpServletRequest.getRequestDispatcher("/index.html").forward(httpServletRequest,httpServletResponse);
            return false;
        }else{
            return true;
        }

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
