package com.example.dataaccesswithjdbc.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

@Component
public class CustomerCountry {
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    HashMap<String, Integer> countryMap = new HashMap<>();
    int count = 1;
    int currentHighest = 0;

    public void getCustomerCountries() {
        String sql = "SELECT * FROM customer ORDER BY country";
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            while(result.next()) {
                countryMap.merge(result.getString("country"), count, Integer::sum);
            }
            for (Map.Entry<String, Integer> entry: countryMap.entrySet()) {
                if(entry.getValue() > currentHighest) {
                    currentHighest = entry.getValue();
                    System.out.println("The country with the most customers is: " + entry.getKey());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
