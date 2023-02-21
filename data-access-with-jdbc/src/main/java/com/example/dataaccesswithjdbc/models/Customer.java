package com.example.dataaccesswithjdbc.models;

import java.sql.*;

public class Customer {
    public int customer_id;
    public String first_name;
    public String last_name;
    public String company;
    public String address;
    public String city;
    public String state;
    public String country;
    public String postal_code;
    public String phone;
    public String fax;
    public String email;
    public int support_rep_id;

    public Customer() {

    }
    public Customer(int customer_id, String first_name, String last_name) {
        this.customer_id = customer_id;
        this.first_name = first_name;
        this.last_name = last_name;
    }
    public Customer(int customer_id, String first_name, String last_name, String company, String address, String city, String state, String country, String postal_code, String phone, String fax, String email, int support_rep_id) {
        this.customer_id = customer_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.company = company;
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postal_code = postal_code;
        this.phone = phone;
        this.fax = fax;
        this.email = email;
        this.support_rep_id = support_rep_id;
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
        String sql = "SELECT * FROM customer ORDER BY customer_id LIMIT " + String.valueOf(limit) + " OFFSET " + String.valueOf(offset);
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
