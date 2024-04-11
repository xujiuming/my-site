package com.ming.base.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * use filter impl auth
 *
 * @author ming
 * @date 2024-04-02 22:23:43
 */
@WebFilter(urlPatterns = "/**")
@Component
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String uri = request.getRequestURI();
        //不需要认证的接口 直接跳过
        if (notNeedAuth(uri)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        //判断是否登录
        var user = request.getSession().getAttribute("userInfo");
        if (user != null) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        //由于使用的iframe方式做的内嵌页面  这里需要借助一个空白页 用js 去跳转
        OutputStream out = ((HttpServletResponse) servletResponse).getOutputStream();
        out.write("<html><script>top.location.href = '/admin/login?errorAuthMsg=filter';</script></html".getBytes(StandardCharsets.UTF_8));
        out.flush();
        out.close();
    }


    private boolean notNeedAuth(String uri) {
        //不是后台的不需要认证
        if (!uri.startsWith("/admin")) {
            return true;
        }
        //后台登录、验证码接口不需要权限
        if (uri.startsWith("/admin/login")
                || uri.startsWith("/captcha/generator")) {
            return true;
        }
        if (uri.endsWith(".js")
                || uri.endsWith(".css")
                || uri.endsWith(".woff")
                || uri.endsWith(".woff2")
                || uri.endsWith(".ttf")
                || uri.endsWith(".eof")
                || uri.endsWith(".swf")
                || uri.endsWith(".png")
                || uri.endsWith(".jpeg")
                || uri.endsWith(".gif")
                || uri.endsWith(".ico")) {
            return true;
        }
        return false;
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
