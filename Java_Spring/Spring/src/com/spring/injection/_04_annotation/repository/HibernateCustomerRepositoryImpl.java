package com.spring.injection._04_annotation.repository;

import java.util.ArrayList;
import java.util.List;

//import org.springframework.stereotype.Repository;

import com.spring.injection._01_base.model.Customer;
import com.spring.injection._01_base.repository.CustomerRepository;

//@Repository("customerRepository")
public class HibernateCustomerRepositoryImpl implements CustomerRepository {

	public List<Customer> findAll() {
		
		List<Customer> customers = new ArrayList<Customer>();
		
		Customer customer = new Customer();
		
		customer.setFirstname("Bryan04");
		customer.setLastname("Hansen04");
		
		customers.add(customer);
		
		return customers;
		
	}

}
