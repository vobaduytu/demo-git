package com.example.FullBlog2021.controller;

import com.example.FullBlog2021.dao.UserDao;
import com.example.FullBlog2021.model.Category;
import com.example.FullBlog2021.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    UserDao userDao = new UserDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                try {
                    doAdd(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "update":
                try {
                    doUpdate(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
        }

    }

    private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));


        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String fullName = request.getParameter("fullName");
        String alias = request.getParameter("alias");
        int role = Integer.parseInt(request.getParameter("role"));
        String about = request.getParameter("about");
        String image = request.getParameter("image");
        int yob = Integer.parseInt(request.getParameter("yob"));

        User user = new User(id,email, password, fullName, alias, role, about, image, yob);
        userDao.update(user);
        request.setAttribute("mess", "Update Success!");
        request.setAttribute("user",user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("blogs/user-update.jsp");
        dispatcher.forward(request, response);
    }

    private void doAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String fullName = request.getParameter("fullName");
        String alias = request.getParameter("alias");
        int role = Integer.parseInt(request.getParameter("role"));
        String about = request.getParameter("about");
        String image = request.getParameter("image");
        int yob = Integer.parseInt(request.getParameter("yob"));

        User user = new User(email, password, fullName, alias, role, about, image, yob);
        System.out.println(user);
        userDao.add(user);
        request.setAttribute("mess", "Add Success!");

        RequestDispatcher dispatcher = request.getRequestDispatcher("blogs/user-add.jsp");
        dispatcher.forward(request, response);
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<User> userList = userDao.getAll();
        request.setAttribute("list", userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("blogs/user-list.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                try {
                    showAddForm(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "update":
                showUpdateForm(request, response);
                break;
            case "delete":
                try {
                    delete(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            default:
                try {
                    listUser(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
        }
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("blogs/user-add.jsp");
        List<User> userList = userDao.getAll();
        request.setAttribute("list", userList);
        dispatcher.forward(request, response);

    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
       boolean rs =  userDao.delete(id);

        if(rs == true){
            request.setAttribute("mess", "Delete Success!");
        }else {
            request.setAttribute("mess", "Delete Fail!");
        }
        List<User> userList = userDao.getAll();
        request.setAttribute("list", userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("blogs/user-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userDao.findById(id);
        request.setAttribute("user",user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("blogs/user-update.jsp");
        dispatcher.forward(request, response);
    }
}
