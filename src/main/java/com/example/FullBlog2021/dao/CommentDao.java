package com.example.FullBlog2021.dao;

import com.example.FullBlog2021.model.Comment;
import com.example.FullBlog2021.model.Post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentDao extends BaseDao implements ICRUDDao<Comment> {
    private final String SELECT_ALL = "select c.*,p.title as name_post from comment c inner join post p on p.id =c.post_id ";
    private final String SELECT_FINDNAME = "select* from comment where content=?";
    private final String SELECT_FINDNAID = "select c.*,p.title as name_post from comment c inner join post p on p.id =c.post_id where c.id=?";
    private final String SQL_ADD = "INSERT INTO newblogs.comment(content,email,post_id) VALUES (?,?,?)";
    public final String SQL_UPDATE = "UPDATE newblogs.comment SET content = ?, email = ? ,post_id =? WHERE id=?";
    final String SQL_DELETE = "delete from comment where id =?";

    @Override
    public List<Comment> getAll() throws SQLException {
        List<Comment> comments = new ArrayList<>();
        PreparedStatement statement = getConnection().prepareStatement(SELECT_ALL);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String content = rs.getString("content");
            String email = rs.getString("email");
            Date createDate = rs.getDate("createdate");
            int idPost = rs.getInt("post_id");
            String namePost = rs.getString("name_post");

            Comment comment = new Comment(id, content, email, createDate, new Post(idPost, namePost));
            comments.add(comment);

        }
        return comments;
    }

    @Override
    public List<Comment> findByKeyword(String keyword) {
        List<Comment> comments = new ArrayList<>();
        try (PreparedStatement statement = getConnection().prepareStatement(SELECT_FINDNAME)) {
            statement.setString(1, keyword);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String content = rs.getString("content");
                String email = rs.getString("email");
                Date createDate = rs.getDate("createdate");

                Comment comment = new Comment(id, content, email, createDate);
                comments.add(comment);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return comments;
    }

    @Override
    public Comment findById(int id) throws SQLException {
        Comment comments = new Comment();
        PreparedStatement statement = getConnection().prepareStatement(SELECT_FINDNAID);
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            String content = rs.getString("content");
            String email = rs.getString("email");
            Date createDate = rs.getDate("createdate");
            int idPost = rs.getInt("post_id");
            String namePost = rs.getString("name_post");

            comments = new Comment(id, content, email, createDate, new Post(idPost, namePost));
        }

        return comments;
    }

    @Override
    public boolean add(Comment oject) throws SQLException {
        PreparedStatement st = getConnection().prepareStatement(SQL_ADD);
        st.setString(1, oject.getContent());
        st.setString(2, oject.getEmail());
        st.setInt(3, oject.getPost().getId());
        return st.executeUpdate() > 0 ? true : false;
    }

    @Override
    public boolean update(Comment object) throws SQLException {
        PreparedStatement st = getConnection().prepareStatement(SQL_UPDATE);
        st.setString(1, object.getContent());
        st.setString(2, object.getEmail());
        st.setInt(3, object.getPost().getId());
        st.setInt(4, object.getId());
        return st.executeUpdate() > 0 ? true : false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rt = false;
        Connection connection = getConnection();
        try {
            connection.setAutoCommit(false);
            PreparedStatement st = getConnection().prepareStatement(SQL_DELETE);
            st.setInt(1, id);
            rt = st.executeUpdate() > 0 ? true : false;

            connection.commit();
        } catch (SQLException throwables) {
            connection.rollback();
        }
        return rt;
    }
}
