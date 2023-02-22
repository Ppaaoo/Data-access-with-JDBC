package com.example.dataaccesswithjdbc;

import com.example.dataaccesswithjdbc.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataAccessWithJdbcApplication implements ApplicationRunner {
	@Autowired
	CustomerDAO customerDAO;
	@Autowired
	Customer customer;
	@Autowired
	CustomerCountry customerCountry;
	@Autowired
	CustomerSpender customerSpender;
	@Autowired
	CustomerGenre customerGenre;
	public static void main(String[] args) {
		SpringApplication.run(DataAccessWithJdbcApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		customerDAO.testConnection();
		//Commented out test functions if you want to try them out, feel free to change the parameters as see fit
		//customer.getAllCustomers();
		//customer.getSpecificCustomer(58);
		//customer.getCustomerByName("Mark");
		//customer.addCustomer("Paulina", "Bonnevier", "Sweden", "37130", "+46 702000924", "paulina.bonnevier1@gmail.com");
		//customerSpender.getHighestSpender();
		//System.out.println(customerCountry.getCustomerCountries());
		//customer.updateCustomerById(5, "first_name", "June");
		//customer.getCustomerPage(5, 2);
		//System.out.println(customerGenre.getCustomerFavouriteGenre(2));
	}
}
