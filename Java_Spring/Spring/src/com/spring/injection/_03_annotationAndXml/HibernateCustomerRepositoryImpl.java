package com.spring.injection._03_annotationAndXml;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.injection._01_base.model.Customer;
import com.spring.injection._01_base.repository.ICustomerRepository;

@Repository("customerRepository3_1")
public class HibernateCustomerRepositoryImpl implements ICustomerRepository {

	public List<Customer> findAll() {
		
		List<Customer> customers = new ArrayList<Customer>();
		
		Customer customer = new Customer();
		
		customer.setFirstname("Bryan3_1");
		customer.setLastname("Hansen3_1");
		
		customers.add(customer);
		
		return customers;
	}
}
