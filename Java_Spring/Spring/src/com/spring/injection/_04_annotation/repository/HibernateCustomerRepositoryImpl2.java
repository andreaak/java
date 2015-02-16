package com.spring.injection._04_annotation.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.injection._01_base.model.Customer;
import com.spring.injection._01_base.repository.CustomerRepository;

@Repository("customerRepository2")
public class HibernateCustomerRepositoryImpl2 implements CustomerRepository {

	public List<Customer> findAll() {
		
		List<Customer> customers = new ArrayList<Customer>();
		
		Customer customer = new Customer();
		
		customer.setFirstname("Bryan042");
		customer.setLastname("Hansen042");
		
		customers.add(customer);
		
		return customers;
		
	}

}
