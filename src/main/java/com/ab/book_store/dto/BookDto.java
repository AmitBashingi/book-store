package com.ab.book_store.dto;

import jakarta.persistence.Id;

public class BookDto {

    String bookId;
    String bookName;
    String author;
    String description;
    String price;

    public BookDto(String bookId, String bookName, String author, String description, String price) {
        this.bookId = bookId;
        this.price = price;
        this.description = description;
        this.author = author;
        this.bookName = bookName;
    }

    public BookDto() {
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}