package com.example.dataaccesswithjdbc;

import com.example.dataaccesswithjdbc.models.Customer;
import com.example.dataaccesswithjdbc.models.CustomerCountry;
import com.example.dataaccesswithjdbc.models.CustomerDAO;
import com.example.dataaccesswithjdbc.models.CustomerSpender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataAccessWithJdbcApplication implements ApplicationRunner {
	@Autowired
	CustomerDAO customerDAO;
	/*@Autowired
	Customer customer;
	@Autowired
	CustomerCountry customerCountry;
	@Autowired
	CustomerSpender customerSpender;*/
	public static void main(String[] args) {
		SpringApplication.run(DataAccessWithJdbcApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		customerDAO.testConnection();
		//customer.getAllCustomers();
		//customer.getSpecificCustomer(58);
		//customer.getCustomerByName("Mark");
		//customer.addCustomer("Paulina", "Bonnevier", "Sweden", "37130", "+46 702000924", "paulina.bonnevier1@gmail.com");
		//customerSpender.getHighestSpender();
		//customer.getCustomerPage(5, 2);
		//customerCountry.getCustomerCountries();
	}
}
