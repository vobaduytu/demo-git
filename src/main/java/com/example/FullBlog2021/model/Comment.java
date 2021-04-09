package com.example.FullBlog2021.model;

import java.util.Date;

public class Comment {
    private int id;
    private String content;
    private String email;
    private Date createdate;
    private Post post;

    public Comment(int id, String content, String email, Date createdate, Post post) {
        this.id = id;
        this.content = content;
        this.email = email;
        this.createdate = createdate;
        this.post = post;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Comment(){}
    public Comment(int id, String content, String email, Date createdate) {
        this.id = id;
        this.content = content;
        this.email = email;
        this.createdate = createdate;
    }

    public Comment(String content, String email, Post post) {
        this.content = content;
        this.email = email;
        this.post = post;
    }

    public Comment(int id, String content, String email, Post post) {
        this.id = id;
        this.content = content;
        this.email = email;
        this.post = post;
    }

    public Comment(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", email='" + email + '\'' +
                ", createdate=" + createdate +
                ", post=" + post +
                '}';
    }
}
