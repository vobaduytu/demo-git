package com.example.FullBlog2021.dao;

import java.sql.SQLException;
import java.util.List;

public interface ICRUDDao<T> {
    List<T> getAll() throws SQLException;
    List<T> findByKeyword(String keyword) throws SQLException;
    T findById(int id) throws SQLException;
    boolean add(T oject) throws SQLException;
    boolean update(T object) throws SQLException;
    boolean delete(int id) throws SQLException;

}
