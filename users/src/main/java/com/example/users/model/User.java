package com.example.users.model;

public class User {
    private static int idUserCounter = 1;

    private int id;
    private String name;
    private int age;

    public User() {
        this.id = idUserCounter++;
    }

    public User(String name, int age) {
        this.id = idUserCounter++;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
