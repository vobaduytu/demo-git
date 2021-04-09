package com.example.FullBlog2021.model;

public class Category {
    private int id;
    private String title;
    private String description;

    public Category(){}

    public Category(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Category(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public Category(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Category(int id) {
        this.id = id;
    }

    public Category(String title) {
        this.title = title;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
