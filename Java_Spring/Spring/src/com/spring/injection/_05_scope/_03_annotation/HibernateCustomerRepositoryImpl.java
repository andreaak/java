package com.spring.injection._05_scope._03_annotation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.injection._01_base.model.Customer;
import com.spring.injection._01_base.repository.ICustomerRepository;


@Repository("customerRepository2")
public class HibernateCustomerRepositoryImpl implements ICustomerRepository {
	
	public List<Customer> findAll() {
		
		List<Customer> customers = new ArrayList<Customer>();
		
		Customer customer = new Customer();
		
		customer.setFirstname("Bryan5_3");
		customer.setLastname("Hansen5_3");
		
		customers.add(customer);
		
		return customers;
	}
}
