package com.spring.injection._04_annotation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.injection._01_base.model.Customer;
import com.spring.injection._01_base.repository.CustomerRepository;
import com.spring.injection._01_base.service.CustomerService;

public class CustomerServiceImpl2 implements CustomerService {
	
	//@Autowired
	private CustomerRepository customerRepository;
	
	public CustomerServiceImpl2() {
		
	}
	
	public CustomerServiceImpl2(CustomerRepository customerRepository2) {
		System.out.println("Injection through Ctor042");
		this.customerRepository = customerRepository2;
	}
	
	@Autowired// Use HibernateCustomerRepositoryImpl2
	public void setCustomerRepository2(CustomerRepository customerRepository2) {
		System.out.println("Injection through Setter042.2");
		this.customerRepository = customerRepository2;
	}	
	
//	@Autowired// Use HibernateCustomerRepositoryImpl
//	public void setCustomerRepository(CustomerRepository customerRepository) {
//		System.out.println("Injection through Setter2");
//		this.customerRepository = customerRepository;
//	}
	
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

}
