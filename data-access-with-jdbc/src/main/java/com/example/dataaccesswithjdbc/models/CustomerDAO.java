package com.example.dataaccesswithjdbc.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.*;
@Component
public class CustomerDAO {
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    public CustomerDAO() {

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
