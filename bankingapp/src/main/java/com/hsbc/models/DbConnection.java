package com.hsbc.models;

public class DbConnection {

    //declare static variable
    public static int count;
    private DbConnection(){
       count++;
    }
    //static method
    public static DbConnection getConnection(){
        if (count<=0)
          return new DbConnection();
        else
            throw new RuntimeException("Singleton Violation");
    }

}
