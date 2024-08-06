package com.hsbc.dal;

import com.hsbc.models.BookStore;

import java.util.Comparator;
import java.util.TreeSet;

public class BookImpl implements BookDAL{
    //declaration
    private TreeSet<BookStore> bookStores;

    public BookImpl(){

        bookStores=new TreeSet<BookStore>(new BookStoreSorter());
    }

    @Override
    public void addBook(BookStore bookStore) {

        bookStores.add(bookStore);
    }

    @Override
    public TreeSet<BookStore> getAllBooks() {
        return bookStores;
    }


}
