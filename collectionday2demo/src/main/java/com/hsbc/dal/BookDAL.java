package com.hsbc.dal;

import com.hsbc.models.BookStore;

import java.util.TreeSet;

public interface BookDAL {
    void addBook(BookStore bookStore);
    TreeSet<BookStore> getAllBooks();

}
