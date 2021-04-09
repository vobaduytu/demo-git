package com.example.FullBlog2021.model;

import java.time.LocalDateTime;
import java.util.Date;

public class Post {
    private int id;
    private String title;
    private String shortContent;
    private String fullContent;
    private String image;
    private LocalDateTime createDate;
    private LocalDateTime modifiledDate;

    private User user;
    private Category category;

    public Post(String title, String shortContent, String fullContent, String image, User user, Category category) {
        this.title = title;
        this.shortContent = shortContent;
        this.fullContent = fullContent;
        this.image = image;
        this.user = user;
        this.category = category;
    }

    public Post(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public Post(int id) {
        this.id = id;
    }

    public Post(int id, String title, String shortContent, String fullContent, String image, User user, Category category) {
        this.id = id;
        this.title = title;
        this.shortContent = shortContent;
        this.fullContent = fullContent;
        this.image = image;
        this.user = user;
        this.category = category;
    }

    public Post() {
    }

    public Post(int id, String title, String shortContent, String fullContent, String image, LocalDateTime createDate, LocalDateTime modifiledDate, User user, Category category) {
        this.id = id;
        this.title = title;
        this.shortContent = shortContent;
        this.fullContent = fullContent;
        this.image = image;
        this.createDate = createDate;
        this.modifiledDate = modifiledDate;
        this.user = user;
        this.category = category;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortContent() {
        return shortContent;
    }

    public void setShortContent(String shortContent) {
        this.shortContent = shortContent;
    }

    public String getFullContent() {
        return fullContent;
    }

    public void setFullContent(String fullContent) {
        this.fullContent = fullContent;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getModifiledDate() {
        return modifiledDate;
    }

    public void setModifiledDate(LocalDateTime modifiledDate) {
        this.modifiledDate = modifiledDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", shortContent='" + shortContent + '\'' +
                ", fullContent='" + fullContent + '\'' +
                ", createDate=" + createDate +
                ", modifiledDate=" + modifiledDate +
                ", image='" + image + '\'' +
                ", user=" + user +
                ", category=" + category +
                '}';
    }
}