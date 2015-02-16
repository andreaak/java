package com.spring.injection._04_annotation.service;

import java.util.List;

import com.spring.injection._01_base.model.Customer;
import com.spring.injection._01_base.repository.CustomerRepository;
import com.spring.injection._01_base.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository;
	
	public CustomerServiceImpl() {
		
	}

	public CustomerServiceImpl(CustomerRepository customerRepository) {
		System.out.println("Injection through Ctor04");
		this.customerRepository = customerRepository;
	}

	public void setCustomerRepository(CustomerRepository customerRepository) {
		System.out.println("Injection through Setter04");
		this.customerRepository = customerRepository;
	}

	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

}
