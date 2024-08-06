package com.hsbc.models;

public class BookStore {
    private int bookId;
    private String name;

    public BookStore() {
    }

    public BookStore(int bookId, String name) {
        this.bookId = bookId;
        this.name = name;
    }

    public int getBookId() {
        return bookId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "BookStore{" +
                "bookId=" + bookId +
                ", name='" + name + '\'' +
                '}';
    }
}
