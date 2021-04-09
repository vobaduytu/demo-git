package com.example.FullBlog2021.dao;

import com.example.FullBlog2021.model.Category;
import com.example.FullBlog2021.model.Post;
import com.example.FullBlog2021.model.User;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PostDao extends BaseDao implements ICRUDDao<Post>{
    private final String GET_FIND_BY_ID="select p.*,c.title as name_category,u.full_name as name_user from post p inner join category c on  c.id=p.id_category inner join users u on u.id=p.id_user where p.id=?";
    private final String GET_ALL="select p.*,c.title as name_category,u.full_name as name_user from post p inner join category c on  c.id=p.id_category inner join users u on u.id=p.id_user order by p.create_date desc";
    private final String GET_ALL_POST_USER="select p.*,c.title as name_category,u.full_name as name_user from post p inner join category c on  c.id=p.id_category inner join users u on u.id=p.id_user where p.id_user=? order by p.create_date desc";
    private final String GET_FIND_NAME="select p.*,c.title as name_category,u.full_name as name_user from post p inner join category c on  c.id=p.id_category inner join users u on u.id=p.id_user where p.title like concat ('%',?,'%') order by p.create_date desc";
    private final String ADD = "INSERT INTO post(title,short_content,full_content,image,id_user,id_category) VALUES (?,?,?,?,?,?)";
    private final String UPDATE="UPDATE post SET title=?,short_content=?,full_content=?,image= ?,modifile_date=now(),id_user = ?, id_category =? WHERE (id = ?)";
    private final String DELETE="delete from post where id = ?";
    private final String SELECT_3 =" select p.*,c.title as name_category,u.full_name as name_user from post p inner join category c on  c.id=p.id_category inner join users u on u.id=p.id_user order by p.create_date desc limit 3";
    private final String SELECT_POST_CATEGORY= "select p.*,c.title as name_category,u.full_name as name_user from post p inner join category c on  c.id=p.id_category inner join users u on u.id=p.id_user where c.id=? order by p.create_date desc";
    private final String SELECT_CATEGORY="select p.*,c.title as name_category,u.full_name as name_user from post p inner join category c on  c.id=p.id_category inner join users u on u.id=p.id_user where id_category order by create_date desc limit 6";
    private final String SELECT_STAFF="select p.*,c.title as name_category,u.full_name as name_user from post p inner join category c on  c.id=p.id_category inner join users u on u.id=p.id_user where u.full_name=? order by p.create_date desc";
    @Override
    public List<Post> getAll() throws SQLException {
        List<Post> rt = new ArrayList<>();
        PreparedStatement st = getConnection().prepareStatement(GET_ALL);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String title = rs.getString("title");
            String shortContent = rs.getString("short_content");
            String fullContent = rs.getString("full_content");
            String image = rs.getString("image");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String create_Date = rs.getString("create_date");
            LocalDateTime createDate = LocalDateTime.parse(create_Date, formatter);
            String modifile_Date = rs.getString("modifile_date");
            LocalDateTime modifileDate = LocalDateTime.parse(modifile_Date,formatter);
            int idUser = rs.getInt("id_user");
            String nameUser = rs.getString("name_user");
            int idCategory = rs.getInt("id_category");
            String nameCategory = rs.getString("name_category");
            Category category = new Category(idCategory,nameCategory);
            User user=new User(idUser,nameUser);

            Post post = new Post(id,title,shortContent,fullContent,image,createDate,modifileDate,user,category);
            rt.add(post);
        }
        return rt;
    }

    public List<Post> select3() throws SQLException {
        List<Post> rt = new ArrayList<>();
        PreparedStatement st = getConnection().prepareStatement(SELECT_3);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String title = rs.getString("title");
            String shortContent = rs.getString("short_content");
            String fullContent = rs.getString("full_content");
            String image = rs.getString("image");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String create_Date = rs.getString("create_date");
            LocalDateTime createDate = LocalDateTime.parse(create_Date, formatter);
            String modifile_Date = rs.getString("modifile_date");
            LocalDateTime modifileDate = LocalDateTime.parse(modifile_Date,formatter);
            int idUser = rs.getInt("id_user");
            String nameUser = rs.getString("name_user");
            int idCategory = rs.getInt("id_category");
            String nameCategory = rs.getString("name_category");
            Category category = new Category(idCategory,nameCategory);
            User user=new User(idUser,nameUser);
            Post post = new Post(id,title,shortContent,fullContent,image,createDate,modifileDate,user,category);
            rt.add(post);
        }
        return rt;
    }

    public List<Post> getPostUser(int id) throws SQLException {
        List<Post> rt = new ArrayList<>();
        PreparedStatement st = getConnection().prepareStatement(GET_ALL_POST_USER);
        st.setInt(1,id);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            int idPost=rs.getInt("id");
            String title = rs.getString("title");
            String shortContent = rs.getString("short_content");
            String fullContent = rs.getString("full_content");
            String image = rs.getString("image");

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String create_Date = rs.getString("create_date");
            LocalDateTime createDate = LocalDateTime.parse(create_Date, formatter);
            String modifile_Date = rs.getString("modifile_date");
            LocalDateTime modifileDate = LocalDateTime.parse(modifile_Date,formatter);

            String nameUser = rs.getString("name_user");
            int idCategory = rs.getInt("id_category");
            String nameCategory = rs.getString("name_category");
            Category category = new Category(idCategory,nameCategory);
            User user=new User(id,nameUser);

            Post post = new Post(idPost,title,shortContent,fullContent,image,createDate,modifileDate,user,category);
            rt.add(post);
        }
        return rt;
    }

    @Override
    public List<Post> findByKeyword(String keyword) throws SQLException {
        List<Post> postList = new ArrayList<>();
        PreparedStatement st = getConnection().prepareStatement(GET_FIND_NAME);
        st.setString(1,keyword);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String shortContent = rs.getString("short_content");
            String fullContent = rs.getString("full_content");
            String image = rs.getString("image");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String create_Date = rs.getString("create_date");
            LocalDateTime createDate = LocalDateTime.parse(create_Date, formatter);
            String modifile_Date = rs.getString("modifile_date");
            LocalDateTime modifileDate = LocalDateTime.parse(modifile_Date,formatter);
            int idUser = rs.getInt("id_user");
            String nameUser = rs.getString("name_user");
            int idCategory = rs.getInt("id_category");
            String nameCategory = rs.getString("name_category");
            Category category = new Category(idCategory,nameCategory);
            User user=new User(idUser,nameUser);
           Post post =new Post(id,keyword,shortContent,fullContent,image,createDate,modifileDate,user,category);
           postList.add(post);
        }
        return postList;
    }
    public List<Post> findByCategory(int catId) throws SQLException {
        List<Post> postList = new ArrayList<>();
        PreparedStatement st = getConnection().prepareStatement(SELECT_POST_CATEGORY);
        st.setInt(1,catId);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String shortContent = rs.getString("short_content");
            String fullContent = rs.getString("full_content");
            String image = rs.getString("image");
            String title = rs.getString("title");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String create_Date = rs.getString("create_date");
            LocalDateTime createDate = LocalDateTime.parse(create_Date, formatter);
            String modifile_Date = rs.getString("modifile_date");
            LocalDateTime modifileDate = LocalDateTime.parse(modifile_Date,formatter);
            int idUser = rs.getInt("id_user");
            String nameUser = rs.getString("name_user");
            int idCategory = rs.getInt("id_category");
            String nameCategory = rs.getString("name_category");
            Category category = new Category(idCategory,nameCategory);
            User user=new User(idUser,nameUser);
            Post post =new Post(id,title,shortContent,fullContent,image,createDate,modifileDate,user,category);
            postList.add(post);
        }
        return postList;
    }
    public List<Post> findByFullname(String keyword) throws SQLException {
        List<Post> postList = new ArrayList<>();
        PreparedStatement st = getConnection().prepareStatement(SELECT_STAFF);
        st.setString(1,keyword);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String shortContent = rs.getString("short_content");
            String fullContent = rs.getString("full_content");
            String image = rs.getString("image");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String create_Date = rs.getString("create_date");
            LocalDateTime createDate = LocalDateTime.parse(create_Date, formatter);
            String modifile_Date = rs.getString("modifile_date");
            LocalDateTime modifileDate = LocalDateTime.parse(modifile_Date,formatter);
            int idUser = rs.getInt("id_user");
            String nameUser = rs.getString("name_user");
            int idCategory = rs.getInt("id_category");
            String nameCategory = rs.getString("name_category");
            Category category = new Category(idCategory,nameCategory);
            User user=new User(idUser,nameUser);
            Post post =new Post(id,keyword,shortContent,fullContent,image,createDate,modifileDate,user,category);
            postList.add(post);
        }
        return postList;
    }

    public Post categoryID(int idCategory) throws SQLException {
        Post post=null;
        PreparedStatement st = getConnection().prepareStatement(SELECT_CATEGORY);
        st.setInt(1,idCategory);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String title = rs.getString("title");
            String shortContent = rs.getString("short_content");
            String fullContent = rs.getString("full_content");
            String image = rs.getString("image");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String create_Date = rs.getString("create_date");
            LocalDateTime createDate = LocalDateTime.parse(create_Date, formatter);
            String modifile_Date = rs.getString("modifile_date");
            LocalDateTime modifileDate = LocalDateTime.parse(modifile_Date,formatter);
            int idUser = rs.getInt("id_user");
            String nameUser = rs.getString("name_user");
            String nameCategory = rs.getString("name_category");
            Category category = new Category(idCategory,nameCategory);
            User user=new User(idUser,nameUser);
            post =new Post(id,title,shortContent,fullContent,image,createDate,modifileDate,user,category);
        }
        return post;
    }

    public List<Post> categoryTop5() throws SQLException {
        List<Post> postList = new ArrayList<>();
        PreparedStatement st = getConnection().prepareStatement(SELECT_CATEGORY);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String shortContent = rs.getString("short_content");
            String fullContent = rs.getString("full_content");
            String image = rs.getString("image");
            String title = rs.getString("title");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String create_Date = rs.getString("create_date");
            LocalDateTime createDate = LocalDateTime.parse(create_Date, formatter);
            String modifile_Date = rs.getString("modifile_date");
            LocalDateTime modifileDate = LocalDateTime.parse(modifile_Date,formatter);

            int idUser = rs.getInt("id_user");
            String nameUser = rs.getString("name_user");
            int idCategory = rs.getInt("id_category");
            String nameCategory = rs.getString("name_category");
            Category category = new Category(idCategory,nameCategory);
            User user=new User(idUser,nameUser);

            Post post =new Post(id,title,shortContent,fullContent,image,createDate,modifileDate,user,category);
            postList.add(post);
        }
        return postList;
    }


    @Override
    public Post findById(int id) throws SQLException {
        Post post=null;
        PreparedStatement st = getConnection().prepareStatement(GET_FIND_BY_ID);
        st.setInt(1,id);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            String title = rs.getString("title");
            String shortContent = rs.getString("short_content");
            String fullContent = rs.getString("full_content");
            String image = rs.getString("image");

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String create_Date = rs.getString("create_date");
            LocalDateTime createDate = LocalDateTime.parse(create_Date, formatter);
            String modifile_Date = rs.getString("modifile_date");
            LocalDateTime modifileDate = LocalDateTime.parse(modifile_Date,formatter);

            int idUser = rs.getInt("id_user");
            String nameUser = rs.getString("name_user");
            int idCategory = rs.getInt("id_category");
            String nameCategory = rs.getString("name_category");
            Category category = new Category(idCategory,nameCategory);
            User user=new User(idUser,nameUser);

         post =new Post(id,title,shortContent,fullContent,image,createDate,modifileDate,user,category);
        }
        return post;
    }

    @Override
    public boolean add(Post object) throws SQLException {

        PreparedStatement st = getConnection().prepareStatement(ADD);
        st.setString(1, object.getTitle());
        st.setString(2, object.getShortContent());
        st.setString(3, object.getFullContent());
        st.setString(4, object.getImage());
        st.setInt(5, object.getUser().getId());
        st.setInt(6, object.getCategory().getId());

        System.out.println(st);
        return st.executeUpdate() > 0 ? true : false;
    }

    @Override
    public boolean update(Post object) throws SQLException {
        PreparedStatement st = getConnection().prepareStatement(UPDATE);
        st.setString(1, object.getTitle());
        st.setString(2, object.getShortContent());
        st.setString(3, object.getFullContent());
        st.setString(4, object.getImage());
        st.setInt(5, object.getUser().getId());
        st.setInt(6, object.getCategory().getId());
        st.setInt(7,object.getId());
        return st.executeUpdate() > 0 ? true : false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rt = false;
        Connection connection = getConnection();
        try {
            connection.setAutoCommit(false);
            PreparedStatement st = getConnection().prepareStatement(DELETE);
            st.setInt(1, id);
            rt = st.executeUpdate() > 0 ? true : false;

            connection.commit();
        } catch (SQLException throwables) {
            connection.rollback();
        }
        return rt;
    }

}
