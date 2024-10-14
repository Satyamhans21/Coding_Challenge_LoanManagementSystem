package com.hexaware.crimeanalysis.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection getConnection() {
        Connection conn = null;

        try {
            // Register the MySQL JDBC Driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            
            // Establish the connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cars", "root", "admin");
            
            // Optional: You can create a statement here if needed
            // java.sql.Statement stmt = conn.createStatement();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }
}