package com.example.FullBlog2021.controller;

import com.example.FullBlog2021.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "DashBoardServlet",urlPatterns = "/dashboard")
public class DashBoardServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String username = user.getEmail();
        if (username == null || username.isEmpty()) {
            response.sendRedirect("authentication");
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("blogs/dashboard.jsp");
            rd.forward(request, response);
        }
    }
}
