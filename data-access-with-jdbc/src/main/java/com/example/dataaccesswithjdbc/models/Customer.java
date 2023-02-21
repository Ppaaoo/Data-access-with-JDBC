package com.example.dataaccesswithjdbc.models;

import java.sql.*;

public class Customer {

    public Customer() {
    }

    public void getAllCustomers(String url, String username, String password) {
        String sql = "SELECT * FROM customer";
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery(); //returns a set of queried rows

            while (result.next()) {
                System.out.println(result.getInt("customer_id") + " " +
                        result.getString("first_name") + " " +
                        result.getString("last_name") + " " +
                        result.getString("country") + " " +
                        result.getString("postal_code") + " " +
                        result.getString("phone") + " " +
                        result.getString("email")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getSpecificCustomer(String url, String username, String password, int id) {
        String sql = "SELECT * FROM customer WHERE customer_id = ?";
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                System.out.println(result.getInt("customer_id") + " " +
                        result.getString("first_name") + " " +
                        result.getString("last_name") + " " +
                        result.getString("country") + " " +
                        result.getString("postal_code") + " " +
                        result.getString("phone") + " " +
                        result.getString("email")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getCustomerByName(String url, String username, String password, String name) {
        String sql = "SELECT * FROM customer WHERE first_name = ?";
        try (Connection conn = DriverManager.getConnection(url, username, password)){
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                System.out.println(result.getInt("customer_id") + " " +
                        result.getString("first_name") + " " +
                        result.getString("last_name") + " " +
                        result.getString("country") + " " +
                        result.getString("postal_code") + " " +
                        result.getString("phone") + " " +
                        result.getString("email")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getCustomerPage(String url, String username, String password, int limit, int offset) {
        String sql = "SELECT * FROM customer ORDER BY customer_id LIMIT " + limit + " OFFSET " + offset;
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                System.out.println(result.getInt("customer_id") + " " +
                        result.getString("first_name") + " " +
                        result.getString("last_name") + " " +
                        result.getString("country") + " " +
                        result.getString("postal_code") + " " +
                        result.getString("phone") + " " +
                        result.getString("email")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addCustomer(String url, String username, String password, String first_name, String last_name, String country, String postal_code, String phone, String email) {
        String sql = "INSERT INTO customer(first_name, last_name, country, postal_code, phone, email) VALUES(" + "'" + first_name + "'," + "'" + last_name + "'," + "'" + country + "'," + "'" + postal_code + "'," + "'" + phone + "'," + "'" + email + "')";
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            Statement statement = conn.createStatement();
            int result = statement.executeUpdate(sql);
            if(result > 0)
                System.out.println("Successfully inserted");
            else System.out.println("Unsuccessful insertion");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCustomerById(String url, String username, String password, int id) {

    }
}
