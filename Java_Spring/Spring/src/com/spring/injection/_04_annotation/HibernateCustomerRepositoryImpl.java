package com.spring.injection._04_annotation;

import java.util.ArrayList;
import java.util.List;

//import org.springframework.stereotype.Repository;

import com.spring.injection._01_base.model.Customer;
import com.spring.injection._01_base.repository.ICustomerRepository;

//@Repository("customerRepository")
public class HibernateCustomerRepositoryImpl implements ICustomerRepository {

	public List<Customer> findAll() {
		
		List<Customer> customers = new ArrayList<Customer>();
		
		Customer customer = new Customer();
		
		customer.setFirstname("Bryan4_1");
		customer.setLastname("Hansen4_1");
		
		customers.add(customer);
		
		return customers;
	}
}
