package com.hsbc.dal;

import com.hsbc.models.BookStore;

import java.util.Comparator;

public class BookStoreSorter implements Comparator<BookStore> {
    @Override
    public int compare(BookStore o1, BookStore o2) {
        if (o1.getBookId()>o2.getBookId())
            return 1;
        else if(o1.getBookId()<o2.getBookId())
            return -1;
        else
            return 0;
    }
}
