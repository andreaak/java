package com.spring.injection._05_scope._02_annotationAndXml;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.injection._01_base.model.Customer;
import com.spring.injection._01_base.repository.ICustomerRepository;

@Repository("customerRepository")
public class HibernateCustomerRepositoryImpl implements ICustomerRepository {
	
	public List<Customer> findAll() {
		
		List<Customer> customers = new ArrayList<Customer>();
		
		Customer customer = new Customer();
		
		customer.setFirstname("Bryan5_2");
		customer.setLastname("Hansen5_2");
		
		customers.add(customer);
		
		return customers;
	}
}
