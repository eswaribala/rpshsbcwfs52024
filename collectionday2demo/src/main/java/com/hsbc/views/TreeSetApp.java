package com.hsbc.views;

import com.hsbc.dal.BookDAL;
import com.hsbc.dal.BookImpl;
import com.hsbc.models.BookStore;

import java.util.Random;
import java.util.UUID;

public class TreeSetApp {

    public static void main(String[] args){

        BookDAL bookDAL=new BookImpl();
        //adding itself sorting happens
        addBooks(bookDAL);
        //retrieve the books
        for(BookStore bookStore: bookDAL.getAllBooks()){
            System.out.println(bookStore);
        }

    }

    public static void addBooks(BookDAL bookDAL){
        UUID uuid=null;
        for(int count=0;count<100;count++){
            uuid=UUID.randomUUID();
            bookDAL.addBook(new BookStore(new Random().nextInt(1,1000),"Book"+uuid));
        }
    }
}
