package com.example.dataaccesswithjdbc.models;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class CustomerCountry {
    //Return the country with the most customers.
    HashMap<String, Integer> countryMap = new HashMap<>();
    int count = 1;
    int currentHighest = 0;

    public void getCustomerCountries(String url, String username, String password) {
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
