package com.spring.injection._06_propfile._02_annotation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.injection._01_base.model.Customer;
import com.spring.injection._01_base.repository.ICustomerRepository;
import com.spring.injection._01_base.service.ICustomerService;

public class CustomerServiceImpl implements ICustomerService {

	
	private ICustomerRepository customerRepository;
	
	public CustomerServiceImpl() {
		
	}
	
	public CustomerServiceImpl(ICustomerRepository customerRepository) {
		System.out.println("We are using Constructor Injection");
		this.customerRepository = customerRepository;
	}
	
	@Autowired
	public void setCustomerRepository(ICustomerRepository customerRepository) {
		System.out.println("We are using Setter Injection");
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
