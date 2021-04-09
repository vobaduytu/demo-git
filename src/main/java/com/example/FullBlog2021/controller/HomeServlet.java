package com.example.FullBlog2021.controller;

import com.example.FullBlog2021.dao.CategoryDao;
import com.example.FullBlog2021.dao.PostDao;
import com.example.FullBlog2021.dao.UserDao;
import com.example.FullBlog2021.model.Category;
import com.example.FullBlog2021.model.Post;
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

@WebServlet(name = "HomeServlet", urlPatterns = "/home")
public class HomeServlet extends HttpServlet {
    UserDao userDao = new UserDao();
    PostDao postDao = new PostDao();
    CategoryDao categoryDao = new CategoryDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "search":
                try {
                    search(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "staff":
                try {
                    staff(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
        }
    }



    private void staff(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {

        String fullName = request.getParameter("fullName");
        List<Post> post = postDao.findByFullname(fullName);
        if (post.size() < 1){
            request.setAttribute("mess","Không tìm thấy tác giả ");
        }else {
            request.setAttribute("postStaff", post);
        }
        List<Post> postList = postDao.select3();
        request.setAttribute("listTop3", postList);
        List<Post> categorylistTop6 = postDao.categoryTop5();
        request.setAttribute("listTop6", categorylistTop6);
        List<User> userList = userDao.getTop1();
        request.setAttribute("user", userList);
        List<Category> categoryList = categoryDao.getAll();
        request.setAttribute("category", categoryList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("blogs/home-staff.jsp");
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
            case "postList":
                try {
                    showPost(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "category":
                try {
                    showCategory(request, response);
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

    private void search(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String title = request.getParameter("title");
        List<Post> post = postDao.findByKeyword(title);
        if (post.size() < 1){
            request.setAttribute("mess","Không tìm thấy bài viết nào");
        }else {
            request.setAttribute("postSearch", post);
        }
        List<Post> postList = postDao.select3();
        request.setAttribute("listTop3", postList);
        List<Post> categorylistTop6 = postDao.categoryTop5();
        request.setAttribute("listTop6", categorylistTop6);
        List<User> userList = userDao.getTop1();
        request.setAttribute("user", userList);
        List<Category> categoryList = categoryDao.getAll();
        request.setAttribute("category", categoryList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("blogs/home-search.jsp");
        dispatcher.forward(request, response);
    }

    private void showCategory(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Category category = categoryDao.findById(id);
        request.setAttribute("categorys", category);
        List<Post> postListx = postDao.select3();
        request.setAttribute("listTop3", postListx);
        List<User> userList = userDao.getTop1();
        request.setAttribute("user", userList);
        List<Post> postList = postDao.findByCategory(id);
        request.setAttribute("postlist", postList);
        List<Category> categoryList = categoryDao.getAll();
        request.setAttribute("category", categoryList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("blogs/home-category.jsp");
        dispatcher.forward(request, response);
    }

    private void showPost(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Post post = postDao.findById(id);
        request.setAttribute("postt", post);
        List<Post> postList = postDao.select3();
        request.setAttribute("listTop3", postList);
        List<User> userList = userDao.getTop1();
        request.setAttribute("user", userList);
        List<Category> categoryList = categoryDao.getAll();
        request.setAttribute("category", categoryList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("blogs/home-post.jsp");
        dispatcher.forward(request, response);
    }

    private void showViewList(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {

        List<Post> postList = postDao.select3();
        request.setAttribute("listTop3", postList);
        List<Post> categorylistTop6 = postDao.categoryTop5();
        request.setAttribute("listTop6", categorylistTop6);
        List<User> userList = userDao.getTop1();
        request.setAttribute("user", userList);
        List<Category> categoryList = categoryDao.getAll();
        request.setAttribute("category", categoryList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("blogs/home.jsp");
        dispatcher.forward(request, response);
    }
}
