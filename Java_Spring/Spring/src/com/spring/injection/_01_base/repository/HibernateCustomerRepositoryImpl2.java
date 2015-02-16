package com.spring.injection._01_base.repository;

import java.util.ArrayList;
import java.util.List;

import com.spring.injection._01_base.model.Customer;


public class HibernateCustomerRepositoryImpl2 implements CustomerRepository {

	public List<Customer> findAll() {
		
		List<Customer> customers = new ArrayList<Customer>();
		
		Customer customer = new Customer();
		
		customer.setFirstname("Brian1_2");
		customer.setLastname("Hansen1_2");
		
		customers.add(customer);
		
		return customers;
		
	}

}
