package com.ming.base.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

/**
 * use filter impl auth
 *
 * @author ming
 * @date 2024-04-02 22:23:43
 */
@WebFilter(urlPatterns = "/**")
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String uri = request.getRequestURI();
        if (notNeedAuth(uri)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            var user = request.getSession().getAttribute("user");
            request.getRequestDispatcher("").forward(servletRequest, servletResponse);
        }
    }

    private boolean notNeedAuth(String uri) {
        return false;
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
