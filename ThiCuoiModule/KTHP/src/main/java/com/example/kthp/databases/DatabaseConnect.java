package com.example.kthp.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnect {

    private static final String URL = "jdbc:mysql://localhost:3306/CHOTHUEPHONGTRO?useSSL=false&allowPublicKeyRetrieval=true&characterEncoding=UTF-8";
    private static final String USER = "root";
    private static final String PASSWORD = "nguyenbaoanhthu";

    private static Connection connection;

    private DatabaseConnect() {
    }

    public static Connection getConnection() {
        if (connection == null) {
            synchronized (DatabaseConnect.class) {
                if (connection == null) {
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        connection = DriverManager.getConnection(URL, USER, PASSWORD);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                        throw new RuntimeException("MySQL JDBC driver not found", e);
                    } catch (SQLException e) {
                        e.printStackTrace();
                        throw new RuntimeException("Failed to connect to the database", e);
                    }
                }
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
