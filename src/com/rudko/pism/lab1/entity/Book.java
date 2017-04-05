package com.rudko.pism.lab1.entity;

/**
 * Created by jack on 18/03/17.
 */

public class Book {

    private int id;
    private String name;
    private String author;
    private int year;

    public Book(String name, String author, int year) {
        setId(0);
        setName(name);
        setAuthor(author);
        setYear(year);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }
}
