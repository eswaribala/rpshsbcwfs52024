package com.hsbc.utility;

import com.hsbc.models.DbConnection;

public class SingletonApp {
    public static void main(String[] args){
        DbConnection dbConnection=DbConnection.getConnection();
        //count the object
        System.out.println("Count="+DbConnection.count);
        dbConnection=DbConnection.getConnection();
        //count the object
        System.out.println("Count="+DbConnection.count);
    }
}
