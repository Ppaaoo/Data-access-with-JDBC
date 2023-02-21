package com.example.dataaccesswithjdbc;

import com.example.dataaccesswithjdbc.models.Customer;
import com.example.dataaccesswithjdbc.models.CustomerCountry;
import com.example.dataaccesswithjdbc.models.CustomerDAO;
import com.example.dataaccesswithjdbc.models.CustomerSpender;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataAccessWithJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataAccessWithJdbcApplication.class, args);
		CustomerDAO customerDAO = new CustomerDAO();
		Customer customer = new Customer();
		CustomerCountry customerCountry = new CustomerCountry();
		CustomerSpender customerSpender = new CustomerSpender();
		customerDAO.testConnection();
		//customer.getAllCustomers(customerDAO.getUrl(), customerDAO.getUsername(), customerDAO.getPassword());
		//customer.getSpecificCustomer(customerDAO.getUrl(), customerDAO.getUsername(), customerDAO.getPassword(), 58);
		//customer.getCustomerByName(customerDAO.getUrl(), customerDAO.getUsername(), customerDAO.getPassword(), "Mark");
		customer.getCustomerPage(customerDAO.getUrl(), customerDAO.getUsername(), customerDAO.getPassword(), 5, 2);
		//customer.addCustomer(customerDAO.getUrl(), customerDAO.getUsername(), customerDAO.getPassword(), "Paulina", "Bonnevier", "Sweden", "37130", "+46 702000924", "paulina.bonnevier1@gmail.com");
		//customerSpender.getHighestSpender(customerDAO.getUrl(), customerDAO.getUsername(), customerDAO.getPassword());
		customerCountry.getCustomerCountries(customerDAO.getUrl(), customerDAO.getUsername(), customerDAO.getPassword());
	}

}
