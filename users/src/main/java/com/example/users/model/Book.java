package com.example.users.model;

public class Book {
    private static int idCounter = 1;

    private int id;
    private String title;
    private String author;
    private String category;
    private boolean borrowed;

    public Book() {
        this.id = idCounter++;
    }

    public Book(String title, String author, String category) {
        this.id = idCounter++;
        this.title = title;
        this.author = author;
        this.category = category;
        this.borrowed = false;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }
}

