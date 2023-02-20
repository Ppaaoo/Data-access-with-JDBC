package com.example.dataaccesswithjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CustomerDAO {
    private String url = "jdbc:postgresql://127.0.0.1:5432/test";
    private String username = "postgres";
    private String password = "postgres";

    public CustomerDAO() {

    }

    public CustomerDAO(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void testConnection() {
        try(Connection conn = DriverManager.getConnection(url,username,password)) {
            System.out.println("Connected to postgres...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
