package com.example.FullBlog2021.controller;

import com.example.FullBlog2021.dao.CommentDao;
import com.example.FullBlog2021.dao.PostDao;
import com.example.FullBlog2021.model.Comment;
import com.example.FullBlog2021.model.Post;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CommentServlet", urlPatterns = "/comment")
public class CommentServlet extends HttpServlet {
    CommentDao commentDao = new CommentDao();
    PostDao postDao = new PostDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

    private void doAdd(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String content = request.getParameter("content");
        String email = request.getParameter("email");
        int idPost = Integer.parseInt(request.getParameter("post"));

        commentDao.add(new Comment(content, email, new Post(idPost)));
        List<Post> postList = postDao.getAll();

        request.setAttribute("postList", postList);
        request.setAttribute("mess", "Add Success!");
        RequestDispatcher dispatcher = request.getRequestDispatcher("blogs/comment-add.jsp");
        dispatcher.forward(request, response);
    }

    private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String content = request.getParameter("content");
        String email = request.getParameter("email");
        int idPost = Integer.parseInt(request.getParameter("post"));

        List<Post> postList = postDao.getAll();

        Comment comment = new Comment(id, content, email, new Post(idPost));
        commentDao.update(comment);
        request.setAttribute("comment", comment);
        request.setAttribute("mess", "Update Success!");
        request.setAttribute("postList", postList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("blogs/comment-update.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
                break;
        }

    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Post> postList = postDao.getAll();

        request.setAttribute("postList", postList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("blogs/comment-add.jsp");
        dispatcher.forward(request, response);

    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        commentDao.delete(id);

        showViewList(request,response);
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Comment comment = commentDao.findById(id);
        List<Post> postList = postDao.getAll();

        request.setAttribute("comment", comment);
        request.setAttribute("postList", postList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("blogs/comment-update.jsp");
        dispatcher.forward(request, response);
    }

    private void showViewList(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Comment> commentList = commentDao.getAll();
        request.setAttribute("list", commentList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("blogs/comment-list.jsp");
        dispatcher.forward(request, response);
    }


}
