package com.example.dataaccesswithjdbc.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

@Component
public class CustomerSpender {
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    HashMap<Integer, Double> customerInvoiceMap = new HashMap<>();
    int currentHighestID;
    double currentHighestTotal;

    public void getHighestSpender() {
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
            getHighestSpenderFromId(currentHighestID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void getHighestSpenderFromId(int id) {
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
