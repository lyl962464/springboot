package com.syaaa.springboot.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ClassName MyFilter
 * @Description TODO
 * @Author APPO
 * @Date 18:53   2018-9-25
 * @Version 1.0
 **/
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFilter process...");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
