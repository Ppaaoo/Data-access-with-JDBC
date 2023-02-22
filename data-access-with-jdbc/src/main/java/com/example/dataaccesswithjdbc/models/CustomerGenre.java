package com.example.dataaccesswithjdbc.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Component
public class CustomerGenre {
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    int count = 1;
    int currentHighest = 0;
    String finalGenre = "";
    ArrayList<Integer> invoiceIds = new ArrayList<>();
    ArrayList<Integer> trackIds = new ArrayList<>();
    ArrayList<Integer> genreIds = new ArrayList<>();
    HashMap<String, Integer> genres = new HashMap<>();

    //This is probably not the best approach as there is a lot of iteration, but it works
    //
    public String getCustomerFavouriteGenre(int customerId) {
        String sql = "SELECT * FROM invoice WHERE customer_id = " + customerId + "";
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                invoiceIds.add(result.getInt("invoice_id"));
            }
            getTrackIDFromInvoiceID();
            getGenreIDFromTrackID();
            getGenreNameFromGenreID();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "The customer with an id of " + customerId + " has " + finalGenre + " as their favourite genre";
    }

    public void getTrackIDFromInvoiceID() {
        for (Integer invoiceId : invoiceIds) {
            String sql = "SELECT * FROM invoice_line WHERE invoice_id = " + invoiceId + "";
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                PreparedStatement statement = conn.prepareStatement(sql);
                ResultSet result = statement.executeQuery();

                while (result.next()) {
                    trackIds.add(result.getInt("track_id"));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void getGenreIDFromTrackID() {
        for (Integer trackId : trackIds) {
            String sql = "SELECT * FROM track WHERE track_id = " + trackId + "";
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                PreparedStatement statement = conn.prepareStatement(sql);
                ResultSet result = statement.executeQuery();

                while (result.next()) {
                    genreIds.add(result.getInt("genre_id"));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void getGenreNameFromGenreID() {
        for (Integer genreId : genreIds) {
            String sql = "SELECT * FROM genre WHERE genre_id = " + genreId + "";
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                PreparedStatement statement = conn.prepareStatement(sql);
                ResultSet result = statement.executeQuery();

                while (result.next()) {
                    genres.merge(result.getString("name"), count, Integer::sum);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        for (Map.Entry<String, Integer> entry: genres.entrySet()) {
            if(entry.getValue() > currentHighest) {
                currentHighest = entry.getValue();
                finalGenre = entry.getKey();
            }
        }
    }
}
