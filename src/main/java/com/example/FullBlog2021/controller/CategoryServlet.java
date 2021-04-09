package com.example.FullBlog2021.controller;

import com.example.FullBlog2021.dao.CategoryDao;
import com.example.FullBlog2021.model.Category;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CategoryServlet", urlPatterns = "/category")
public class CategoryServlet extends HttpServlet {
    CategoryDao categoryDao = new CategoryDao();

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
            case "search":
                doSearch(request, response);
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

    private void doAdd(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");

        Category category = new Category(title, description);
        categoryDao.add(category);

        request.setAttribute("mess", "Add Success!");
        RequestDispatcher dispatcher = request.getRequestDispatcher("blogs/category-add.jsp");
        dispatcher.forward(request, response);
    }

    private void doSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("search");
        List<Category> categoryList = categoryDao.findByKeyword(title);

        request.setAttribute("categoryList", categoryList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("blogs/category-list.jsp");
        dispatcher.forward(request, response);
    }

    private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");

        Category category = new Category(id, title, description);
        categoryDao.update(category);

        request.setAttribute("category", category);
        request.setAttribute("mess", "Update Success!");
        RequestDispatcher dispatcher = request.getRequestDispatcher("blogs/category-update.jsp");
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
                showAddForm(request, response);
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
                    showViewList(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

        }
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("blogs/category-add.jsp");
        dispatcher.forward(request, response);
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Category category = categoryDao.findById(id);
            if(category != null) {
                request.setAttribute("category", category);
                RequestDispatcher dispatcher = request.getRequestDispatcher("blogs/category-update.jsp");
                dispatcher.forward(request, response);
            }else {
                response.sendRedirect("error");
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        boolean rs=categoryDao.delete(id);

        if(rs == true){
        request.setAttribute("mess", "Delete Success!");
    }else {
            request.setAttribute("mess", "Delete Fail!");
        }
        List<Category> categoryList = categoryDao.getAll();
        request.setAttribute("list", categoryList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("blogs/category-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showViewList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("blogs/category-list.jsp");
        List<Category> categoryList = categoryDao.getAll();
        request.setAttribute("list", categoryList);
        dispatcher.forward(request, response);
}}
