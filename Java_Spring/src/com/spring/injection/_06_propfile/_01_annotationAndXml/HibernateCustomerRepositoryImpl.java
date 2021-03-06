package com.spring.injection._06_propfile._01_annotationAndXml;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.spring.injection._01_base.model.Customer;
import com.spring.injection._01_base.repository.ICustomerRepository;

@Repository("customerRepository")
public class HibernateCustomerRepositoryImpl implements ICustomerRepository {

	@Value("${anotherName}")
	private String someValue;
	
	public List<Customer> findAll() {
		
		List<Customer> customers = new ArrayList<Customer>();
		
		Customer customer = new Customer();
		
		customer.setFirstname("anotherName = " + someValue);
		customer.setLastname("Hansen");
		
		customers.add(customer);
		
		return customers;
	}

}
