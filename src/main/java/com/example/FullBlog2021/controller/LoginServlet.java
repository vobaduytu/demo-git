package com.example.FullBlog2021.controller;

import com.example.FullBlog2021.dao.UserDao;
import com.example.FullBlog2021.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "LoginServlet",urlPatterns = "/authentication")
public class LoginServlet extends HttpServlet {
    UserDao userDao=new UserDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if(action == null){
            action ="login";
        }
        switch (action){
            case "login":
                try {
                    doLogin(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "register":
                try {
                    doRegister(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
        }
    }

    private void doLogin(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String email=request.getParameter("email");
        String password=request.getParameter("password");

        User user=userDao.login(email,password);
        if(user != null){
            HttpSession session= request.getSession();
            session.setAttribute("user",user);
            session.setAttribute("id",user.getId());
            session.setAttribute("role",user.getRole());
            response.sendRedirect("dashboard");
        }else {
            request.setAttribute("mess","Email or password is fail!");
            showLoginForm(request,response);
        }
    }

    private void doRegister(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String fullName = request.getParameter("fullname");
        int yob = Integer.parseInt(request.getParameter("yob"));

        User user = new User(email, password, fullName, yob);
        List<User> userList=userDao.getAll();
        HttpSession session= request.getSession();
        for(User user1:userList){
            if(user1.getEmail().equals(user.getEmail())){
                request.setAttribute("mess","Email has existed!");
                session.invalidate();
                RequestDispatcher dispatcher=request.getRequestDispatcher("blogs/register.jsp");
                dispatcher.forward(request,response);
                break;
            }
        }
        userDao.register(user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("blogs/login.jsp");
        dispatcher.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if(action == null){
            action ="login";
        }
        switch (action){
            case "login":
                showLoginForm(request,response);
                break;
            case "logout":
                doLogout(request,response);
                break;
            case "register":
                showRegisterForm(request,response);
                break;
        }
    }


    private void showLoginForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher=request.getRequestDispatcher("blogs/login.jsp");
        dispatcher.forward(request,response);
    }

    private void doLogout(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session= request.getSession();
        session.invalidate();
        showLoginForm(request,response);
    }

    private void showRegisterForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher=request.getRequestDispatcher("blogs/register.jsp");
        dispatcher.forward(request,response);
    }
}
