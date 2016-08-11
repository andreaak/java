package com.spring.injection._05_scope._02_annotationAndXml.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.spring.injection._01_base.model.Customer;
import com.spring.injection._01_base.repository.ICustomerRepository;
import com.spring.injection._01_base.service.ICustomerService;

@Service("customerServiceSingle")
@Scope("singleton")
public class CustomerServiceImpl2 implements ICustomerService {

	private ICustomerRepository customerRepository;
	
	public CustomerServiceImpl2() {
		
	}
	
	public CustomerServiceImpl2(ICustomerRepository customerRepository) {
		System.out.println("We are using constructor injection");
		this.customerRepository = customerRepository;
	}
	
	@Autowired
	public void setCustomerRepository(ICustomerRepository customerRepository) {
		System.out.println("We are using setter injection");
		
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
