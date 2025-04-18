package com.example.users.model;

import java.time.LocalDate;

public class Borrow {
    private static int idBorrowCounter = 1;

    private int id;
    private User user;
    private Book book;
    private LocalDate borrowedDate;
    private LocalDate devolutionDate;

    public Borrow() {
        this.id = idBorrowCounter++;
        this.borrowedDate = LocalDate.now();
    }

    public Borrow(User user, Book book) {
        this.id = idBorrowCounter++;
        this.user = user;
        this.book = book;
        this.borrowedDate = LocalDate.now();
        this.devolutionDate = null;
    }

    public void devolution() {
        this.devolutionDate = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getBorrowedDate() {
        return borrowedDate;
    }

    public LocalDate getDevolutionDate() {
        return devolutionDate;
    }
}
