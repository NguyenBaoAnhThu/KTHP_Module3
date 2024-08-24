package com.example.kthp.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnect {
    private static final String URL = "jdbc:mysql://localhost:3306/CHOTHUEPHONGTRO";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "nguyenbaoanhthu";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("Cannot find JDBC driver.");
        }
    }
}
