package com.spring.injection._06_propfile._01_annotationAndXml.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.injection._01_base.model.Customer;
import com.spring.injection._01_base.repository.ICustomerRepository;
import com.spring.injection._01_base.service.ICustomerService;

@Service("customerService")
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

	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}
}
