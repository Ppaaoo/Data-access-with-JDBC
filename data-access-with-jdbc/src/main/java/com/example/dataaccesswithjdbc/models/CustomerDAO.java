package com.example.dataaccesswithjdbc.models;

import java.sql.*;

public class CustomerDAO {
    private String url = "jdbc:postgresql://localhost:5432/postgres";
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

    public String getUrl() {
        return this.url;
    }
    public String getUsername() {
        return this.username;
    }
    public String getPassword() {
        return this.password;
    }
}
