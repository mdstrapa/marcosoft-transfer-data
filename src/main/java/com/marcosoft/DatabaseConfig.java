package com.marcosoft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {

    public Connection createPeopleConnection(){
        final String dbUrl = "jdbc:mysql://192.168.0.19:3306/Activity";
        final String dbUser = "root";
        final String dbPassword = "mysql";
        try {
            return DriverManager.getConnection(dbUrl,dbUser,dbPassword);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection createActivityConnection(){
        final String dbUrl = "jdbc:mysql://localhost:3306/Activity";
        final String dbUser = "root";
        final String dbPassword = "mysql";
        try {
            return DriverManager.getConnection(dbUrl,dbUser,dbPassword);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
