package com.example.pageadmin.generator;


import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

public class DataBaseHelper {


    public static Connection getConnection(String url, String user,String password, String driverName) throws Exception{
        Class.forName(driverName);
        return (Connection) DriverManager.getConnection(url, user, password);
    }


}
