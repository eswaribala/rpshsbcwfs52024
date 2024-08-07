package com.hsbc.exceptions;

//checked exception
public class DbConnectionException  extends Exception{

    public DbConnectionException(String message) {
        super(message);
    }
}
