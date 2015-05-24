package com.spring.injection._01_base.repository;

import java.util.ArrayList;
import java.util.List;

import com.spring.injection._01_base.model.Customer;


public class HibernateCustomerRepositoryImpl implements CustomerRepository {

	public List<Customer> findAll() {
		
		List<Customer> customers = new ArrayList<Customer>();
		
		Customer customer = new Customer();
		
		customer.setFirstname("Brian1");
		customer.setLastname("Hansen1");
		
		customers.add(customer);
		
		return customers;
		
	}

}
