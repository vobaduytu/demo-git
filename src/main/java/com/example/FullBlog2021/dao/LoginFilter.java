package com.example.FullBlog2021.dao;

import com.example.FullBlog2021.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter",urlPatterns = {"/post"})
public class LoginFilter implements Filter {
    public void destroy() {
    }
// admin == `1` cho vo hết'
    // admin == 2 cho vô post category
    //admin == 3 vô được post
    //if(user.getrole == 1)
    // chain...

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");
        if (user == null){

            ((HttpServletResponse) resp).sendRedirect("/authentication");
        }else {
            chain.doFilter(req, resp);
        }


    }

    public void init(FilterConfig config) throws ServletException {

    }

}
