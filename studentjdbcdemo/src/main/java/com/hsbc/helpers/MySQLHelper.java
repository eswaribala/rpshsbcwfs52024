package com.hsbc.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MySQLHelper {

    private static ResourceBundle resourceBundle;
    private MySQLHelper(){

    }
    //singleton
    public static Connection getConnection() throws ClassNotFoundException, SQLException {

        resourceBundle=ResourceBundle.getBundle("db");
        String userName=resourceBundle.getString("userName");
        String password=resourceBundle.getString("password");
        String url=resourceBundle.getString("url");
        String driver=resourceBundle.getString("driverClassName");
        Class.forName(driver);
        return DriverManager.getConnection(url,userName,password);

    }


}
