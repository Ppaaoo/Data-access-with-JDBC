package com.example.dataaccesswithjdbc.models;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class CustomerSpender {

    //Customer who is the highest spender (total in invoice table is the largest
    HashMap<Integer, Double> customerInvoiceMap = new HashMap<>();
    int currentHighestID;
    double currentHighestTotal;

    public void getHighestSpender(String url, String username, String password) {
        String sql = "SELECT * FROM invoice ORDER BY customer_id";
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            while(result.next()) {
                customerInvoiceMap.merge(result.getInt("customer_id"), result.getDouble("total"), Double::sum);
            }
            for (Map.Entry<Integer, Double> entry: customerInvoiceMap.entrySet()) {
                if(entry.getValue() > currentHighestTotal) {
                    currentHighestTotal = entry.getValue();
                    currentHighestID = entry.getKey();
                    System.out.println("Current Highest Total: " + currentHighestTotal);
                    System.out.println("Current id: " + currentHighestID);
                }
            }
            getHighestSpenderFromId(url, username, password, currentHighestID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void getHighestSpenderFromId(String url, String username, String password, int id) {
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
}
