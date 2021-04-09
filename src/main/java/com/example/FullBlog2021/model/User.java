package com.example.FullBlog2021.model;

import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;

public class User {
    private int id;
    private String email;
    private String password;
    private String fullname;
    private String alias;
    private int role;
    private String about;
    private String image;
    private Date createdate;
    private int yob;
    public User(){}

    public User(int id) {
        this.id = id;
    }

    public User(String email, String password, String fullname, int yob) {
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.yob = yob;
    }

    public User(int id, String email, String password, String fullname, String alias, int role, String about, String image, Date createdate, int yob) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.alias = alias;
        this.role = role;
        this.about = about;
        this.image = image;
        this.createdate = createdate;
        this.yob = yob;
    }

    public User(String email, String password, String fullname, String alias, int role, String about, String image, int yob) {
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.alias = alias;
        this.role = role;
        this.about = about;
        this.image = image;
        this.yob = yob;
    }

    public User(int id, String email, String password, String fullname, String alias, int role, String about, String image, int yob) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.alias = alias;
        this.role = role;
        this.about = about;
        this.image = image;
        this.yob = yob;
    }

    public User(String email, String password, String fullname, String alias, int role, String about, String image, Date createdate, int yob) {
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.alias = alias;
        this.role = role;
        this.about = about;
        this.image = image;
        this.createdate = createdate;
        this.yob = yob;
    }

    public User(int id, String fullname) {
        this.id = id;
        this.fullname = fullname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public int getYob() {
        return yob;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }
}
