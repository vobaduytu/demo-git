package com.example.FullBlog2021.dao;

import com.example.FullBlog2021.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDao extends BaseDao implements ICRUDDao<User> {
    final String SQL_SELEC_USER = "select * from users";
    final String SQL_ADD_USER = "INSERT INTO newblogs.users (email,password,full_name,alias,role,about,image,yob) VALUES (?,?,?,?,?,?,?,?)";
    final String SQL_REGISTER_USER = "INSERT INTO newblogs.users(email,password,full_name,yob) VALUES (?,?,?,?)";
    final String SQL_DELETE_USER="call delete_user(?)";
    final String SQL_UPDATE_USER = "update  users set email=? ,password=?,full_name=?,alias=?,role=?,about=?,image=?,yob=? where id=?";
    final String SQL_FINDBYID_USER="select * from users where id =?";
    final String SQL_FINDBYFULLNAME_USER="select * from users where full_name  like ('%' || ? ||'%')";
    final String SQL_LOGIN="select * from users where email=? and password=?";

    final String SQL_SELEC_1 = "select * from users where id order by create_date desc limit 1 ";



    @Override
    public List<User> getAll() throws SQLException {
        List<User> userList = new ArrayList<>();
        PreparedStatement st = getConnection().prepareStatement(SQL_SELEC_USER);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String myEmail = rs.getString("email");
            String myPassword = rs.getString("password");
            String fullName = rs.getString("full_name");
            int role = rs.getInt("role");
            String alias = rs.getString("alias");
            String about = rs.getString("about");
            String image = rs.getString("image");
            Date createdate = rs.getDate("create_date");
            int yob = rs.getInt("yob");

            User user = new User(id, myEmail, myPassword, fullName, alias, role, about, image, createdate, yob);
            userList.add(user);

        }
        return userList;
    }
    public List<User> getTop1() throws SQLException {
        List<User> userList = new ArrayList<>();
        PreparedStatement st = getConnection().prepareStatement(SQL_SELEC_1);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String myEmail = rs.getString("email");
            String myPassword = rs.getString("password");
            String fullName = rs.getString("full_name");
            int role = rs.getInt("role");
            String alias = rs.getString("alias");
            String about = rs.getString("about");
            String image = rs.getString("image");
            Date createdate = rs.getDate("create_date");
            int yob = rs.getInt("yob");

            User user = new User(id, myEmail, myPassword, fullName, alias, role, about, image, createdate, yob);
            userList.add(user);

        }
        return userList;
    }
    @Override
    public List<User> findByKeyword(String keyword) {
       List<User> userList = new ArrayList<>();
       try(PreparedStatement statement = getConnection().prepareStatement(SQL_FINDBYFULLNAME_USER)){
           statement.setString(1,keyword);
           ResultSet rs = statement.executeQuery();
           while (rs.next()){
               int id = rs.getInt("id");
               String myEmail = rs.getString("email");
               String myPassword = rs.getString("password");
               int role = rs.getInt("role");
               String alias = rs.getString("alias");
               String about = rs.getString("about");
               String image = rs.getString("image");
               Date creatdate = rs.getDate("create_date");
               int yob = rs.getInt("yob");
              User user = new User(id,myEmail,myPassword,keyword,alias,role,about,image,creatdate,yob);
              userList.add(user);
           }
       } catch (SQLException throwables) {
           throwables.printStackTrace();
       }
       return userList;
    }

    @Override
    public User findById(int ids) {
        User user = new User();
        try(PreparedStatement statement = getConnection().prepareStatement(SQL_FINDBYID_USER)) {
            statement.setInt(1,ids);
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                int id = rs.getInt("id");
                String myEmail = rs.getString("email");
                String myPassword = rs.getString("password");
                String fullName = rs.getString("full_name");
                int role = rs.getInt("role");
                String alias = rs.getString("alias");
                String about = rs.getString("about");
                String image = rs.getString("image");
                Date creatdate = rs.getDate("create_date");
                int yob = rs.getInt("yob");
                user = new User(id,myEmail,myPassword,fullName,alias,role,about,image,creatdate,yob);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean add(User oject) throws SQLException {
        PreparedStatement st = getConnection().prepareStatement(SQL_ADD_USER);

        st.setString(1, oject.getEmail());
        st.setString(2, oject.getPassword());
        st.setString(3, oject.getFullname());
        st.setString(4, oject.getAlias());
        st.setInt(5, oject.getRole());
        st.setString(6, oject.getAbout());
        st.setString(7, oject.getImage());
        st.setInt(8, oject.getYob());
        return st.executeUpdate() > 0 ? true : false;
    }

    public boolean register(User oject) throws SQLException {
        PreparedStatement st = getConnection().prepareStatement(SQL_REGISTER_USER);

        st.setString(1, oject.getEmail());
        st.setString(2, oject.getPassword());
        st.setString(3, oject.getFullname());
        st.setInt(4, oject.getYob());
        return st.executeUpdate() > 0 ? true : false;
    }

    @Override
    public boolean update(User object) throws SQLException {
        PreparedStatement st = getConnection().prepareStatement(SQL_UPDATE_USER);
        st.setString(1, object.getEmail());
        st.setString(2, object.getPassword());
        st.setString(3, object.getFullname());
        st.setString(4, object.getAlias());
        st.setInt(5, object.getRole());
        st.setString(6, object.getAbout());
        st.setString(7, object.getImage());
        st.setInt(8, object.getYob());

        st.setInt(9,object.getId());

        return st.executeUpdate() > 0 ? true : false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rt = false;
        Connection connection = getConnection();
        try {
            connection.setAutoCommit(false);
            PreparedStatement st = getConnection().prepareStatement(SQL_DELETE_USER);
            st.setInt(1, id);
            rt = st.executeUpdate() > 0;

            connection.commit();
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
            throwables.printStackTrace();
            connection.rollback();
        }
        return rt;

    }


    public User login(String email, String password) throws SQLException {
        User user = null;

        PreparedStatement st = getConnection().prepareStatement(SQL_LOGIN);
        st.setString(1, email);
        st.setString(2, password);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String myEmail = rs.getString("email");
            String myPassword = rs.getString("password");
            String fullName = rs.getString("full_name");
            String alias = rs.getString("alias");
            int role = rs.getInt("role");
            String about = rs.getString("about");
            String image = rs.getString("image");
            Date createDate = rs.getDate("create_date");
            int yob = rs.getInt("yob");

            user = new User(id, myEmail, myPassword, fullName, alias, role, about, image, createDate, yob);
        }
        return user;
    }
}
