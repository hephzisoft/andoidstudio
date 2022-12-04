package com.hephzisoft.bookapps;

public class Book {
    private int image;
    private String book_title;
    private String author_name;
    private String book_content;

    public Book(int image, String author_name, String book_title, String book_content) {
        this.image = image;
        this.book_title = book_title;
        this.author_name = author_name;
        this.book_content = book_content;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getBook_content() {
        return book_content;
    }

    public void setBook_content(String book_content) {
        this.book_content = book_content;
    }
}
