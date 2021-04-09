package com.example.FullBlog2021.dao;

import com.example.FullBlog2021.model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao extends BaseDao implements ICRUDDao<Category> {
    final String SQL_GET_ALL = "select * from category";
    final String SQL_ADD = "insert into category(title,description) values (?,?)";
    final String SQL_UPDATE = "update  category set title=? ,description=? where id=?";
    final String SQL_DELETE = "call delete_category (?);";
    final String SQL_FIND_NAME_CATEGORY = "select * from category where title=?";
    final String SQL_FIND_BY_ID_CATEGORY = "select * from category where id=?";

    @Override
    public List<Category> getAll() throws SQLException {
        List<Category> rt = new ArrayList<>();
//        goi ham lay connection tu VaseDao

        PreparedStatement st = getConnection().prepareStatement(SQL_GET_ALL);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String title = rs.getString("title");
            String description = rs.getString("description");
            Category category = new Category(id, title, description);
            rt.add(category);
        }
        return rt;
    }

    @Override
    public List<Category> findByKeyword(String keyword) {
        List<Category> categoryList = new ArrayList<>();
        try (PreparedStatement statement = getConnection().prepareStatement(SQL_FIND_NAME_CATEGORY);
        ) {
            statement.setString(1, keyword);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String description = rs.getString("description");
                Category category = new Category(id, title, description);
                categoryList.add(category);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return categoryList;
    }

    @Override
    public Category findById(int ids) throws SQLException {
        Category category = new Category();
        try (PreparedStatement statement = getConnection().prepareStatement(SQL_FIND_BY_ID_CATEGORY)) {
            statement.setInt(1,ids);
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String description = rs.getString("description");
                category = new Category(id, title, description);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return category;
    }
        @Override
        public boolean add (Category object) throws SQLException {
            PreparedStatement st = getConnection().prepareStatement(SQL_ADD);
            st.setString(1, object.getTitle());
            st.setString(2, object.getDescription());
            System.out.println(st);
            return st.executeUpdate() > 0 ? true : false;

        }

        @Override
        public boolean update (Category object) throws SQLException {
            PreparedStatement st = getConnection().prepareStatement(SQL_UPDATE);
            st.setString(1, object.getTitle());
            st.setString(2, object.getDescription());
            st.setInt(3, object.getId());

            return st.executeUpdate() > 0 ? true : false;
        }

        @Override
        public boolean delete ( int id) throws SQLException {
            boolean rt = false;
            Connection connection = getConnection();
            try {
                connection.setAutoCommit(false);
              CallableStatement st = getConnection().prepareCall(SQL_DELETE);
                st.setInt(1, id);
                rt = st.executeUpdate() > 0 ? true : false;

               connection.commit();
            } catch (SQLException throwables) {
                connection.rollback();
            }
            return rt;
        }
    }
