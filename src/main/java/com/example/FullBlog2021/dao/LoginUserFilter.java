package com.example.FullBlog2021.dao;

import com.example.FullBlog2021.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginUserFilter",urlPatterns = "/user")
public class LoginUserFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("/authentication");
        } else {
            if (user.getRole() == 1) {
                chain.doFilter(req, resp);
            } else {
                response.sendRedirect("/Error404.jsp");
            }
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
