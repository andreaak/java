package com.spring.injection._03_annotationAndXml.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.injection._01_base.model.Customer;
import com.spring.injection._01_base.repository.ICustomerRepository;

//@Repository("customerRepository")
public class HibernateCustomerRepositoryImpl2 implements ICustomerRepository {

	public List<Customer> findAll() {
		
		List<Customer> customers = new ArrayList<Customer>();
		
		Customer customer = new Customer();
		
		customer.setFirstname("Bryan3_2");
		customer.setLastname("Hansen3_2");
		
		customers.add(customer);
		
		return customers;
		
	}

}
