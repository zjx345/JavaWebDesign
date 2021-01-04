package com.jsu.zjx.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "LoginFilter",urlPatterns = {"/folkMusicRankList.jsp"})
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 强转
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();

        response.setContentType("text/html;charset=UTF-8");
        // 解决重复登录的问题：session里面有登录数据就不需要在登录
        // 简单判断缓存中是否有登录用户
        System.out.println(session.getAttribute("SESSION_USER"));
        String str = request.getServletPath();
            if (session.getAttribute("SESSION_USER") == null) {// 没有用户
                // 没登录，驳回访问请求并重定向到登录页面
                PrintWriter writer = response.getWriter();
                writer.write("<script>");
                writer.write("alert('请先登录在进行操作！');");
                writer.write("window.location.href = 'index.jsp'");
                writer.write("</script>");
                writer.flush();
                writer.close();
            } else {
                filterChain.doFilter(request, response); // 放行，交给下一个过滤器
            }

    }

    @Override
    public void destroy() {

    }
}
