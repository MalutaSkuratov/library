package com.alex.library.models;

public class Book {

    private int id_book;
    private String title;
    private String author;
    private int book_year;

    public Book() {
    }

    public Book(int id_book, String title, String author, int book_year) {
        this.id_book = id_book;
        this.title = title;
        this.author = author;
        this.book_year = book_year;
    }


    public int getId_book() {
        return id_book;
    }
    public void setId_book(int id_book) {
        this.id_book = id_book;
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

    public int getBook_Year() {
        return  book_year;
    }
    public void setYear(int  book_year) {
        this. book_year =  book_year;
    }


}
