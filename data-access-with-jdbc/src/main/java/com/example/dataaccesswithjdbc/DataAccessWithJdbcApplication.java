package com.example.dataaccesswithjdbc;

import com.example.dataaccesswithjdbc.models.Customer;
import com.example.dataaccesswithjdbc.models.CustomerDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataAccessWithJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataAccessWithJdbcApplication.class, args);
		CustomerDAO customerDAO = new CustomerDAO();
		Customer customer = new Customer();
		customerDAO.testConnection();
		customer.getAllCustomers(customerDAO.getUrl(), customerDAO.getUsername(), customerDAO.getPassword());
		customer.getSpecificCustomer(customerDAO.getUrl(), customerDAO.getUsername(), customerDAO.getPassword(), 58);
	}

}
