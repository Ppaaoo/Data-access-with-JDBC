package com.example.dataaccesswithjdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataAccessWithJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataAccessWithJdbcApplication.class, args);
		CustomerDAO customerDAO = new CustomerDAO();
		customerDAO.testConnection();
	}

}
