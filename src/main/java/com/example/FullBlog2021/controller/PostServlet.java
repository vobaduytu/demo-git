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

@WebServlet(name = "PostServlet", urlPatterns = "/post")
public class PostServlet extends HttpServlet {
    PostDao postDao = new PostDao();
    UserDao userDao = new UserDao();
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

    private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        HttpSession session=request.getSession();
        Post post=null;
        int id= Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String shortContent = request.getParameter("shortContent");
        String fullContent = request.getParameter("fullContent");
        String image = request.getParameter("image");
        int idCategory = Integer.parseInt(request.getParameter("category"));

        int roleSession= (int) session.getAttribute("role");
        if(roleSession ==3){
            post = new Post(id,title,shortContent,fullContent,image,new User((Integer) session.getAttribute("id")), new Category(idCategory));
        }else {
            int idUser = Integer.parseInt(request.getParameter("user"));
            post = new Post(id,title,shortContent,fullContent,image,new User(idUser), new Category(idCategory));
        }
        postDao.update(post);
        request.setAttribute("mess","Update Success!");
        List<Category> categoryList = categoryDao.getAll();
        request.setAttribute("categoryList",categoryList);
        List<User> userList = userDao.getAll();
        request.setAttribute("userList",userList);
        request.setAttribute("post",post);

        RequestDispatcher dispatcher=request.getRequestDispatcher("blogs/post-update.jsp");
        dispatcher.forward(request,response);

    }

    private void doSearch(HttpServletRequest request, HttpServletResponse response) {
    }

    private void doAdd(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        HttpSession session=request.getSession();
        Post post=null;
        String title = request.getParameter("title");
        String shortContent = request.getParameter("shortContent");
        String fullContent = request.getParameter("fullContent");
        String image = request.getParameter("image");
        int idCategory = Integer.parseInt(request.getParameter("category"));

        int roleSession= (int) session.getAttribute("role");
        if(roleSession ==3){
            post = new Post(title,shortContent,fullContent,image,new User((Integer) session.getAttribute("id")), new Category(idCategory));
        }else {
            int idUser = Integer.parseInt(request.getParameter("user"));
            post = new Post(title,shortContent,fullContent,image,new User(idUser), new Category(idCategory));
        }
        postDao.add(post);
        request.setAttribute("mess","Add Success!");
        List<Category> categoryList = categoryDao.getAll();
        request.setAttribute("categoryList",categoryList);
        List<User> userList = userDao.getAll();
        request.setAttribute("userList",userList);

        RequestDispatcher dispatcher=request.getRequestDispatcher("blogs/post-add.jsp");
        dispatcher.forward(request,response);
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
                try {
                    showUpdateForm(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
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

    private void showViewList(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        HttpSession session=request.getSession();

        List<Post> postList=postDao.getAll();
        request.setAttribute("list",postList);

        List<Post> postListUser = postDao.getPostUser((Integer) session.getAttribute("id"));
        request.setAttribute("postListUser",postListUser);

        RequestDispatcher dispatcher=request.getRequestDispatcher("blogs/post-list.jsp");
        dispatcher.forward(request,response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean rs= postDao.delete(id);

        if(rs == true){
            request.setAttribute("mess", "Delete Success!");
        }else {
            request.setAttribute("mess", "Delete Fail!");
        }
        List<Post> postLists = postDao.getAll();
        request.setAttribute("postListUser", postLists);
        List<Post> postList = postDao.getAll();
        request.setAttribute("list", postList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("blogs/post-list.jsp");
        dispatcher.forward(request, response);

    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Post post = postDao.findById(id);
        request.setAttribute("post",post);
        List<Category> categoryList = categoryDao.getAll();
        request.setAttribute("categoryList",categoryList);
        List<User> userList = userDao.getAll();
        request.setAttribute("userList",userList);
        RequestDispatcher dispatcher=request.getRequestDispatcher("blogs/post-update.jsp");
        dispatcher.forward(request,response);
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Category> categoryList = categoryDao.getAll();
        request.setAttribute("categoryList",categoryList);
        List<User> userList = userDao.getAll();
        request.setAttribute("userList",userList);
        List<Post> postList=postDao.getAll();
        request.setAttribute("list",postList);
        RequestDispatcher dispatcher=request.getRequestDispatcher("blogs/post-add.jsp");
        dispatcher.forward(request,response);
    }
}
