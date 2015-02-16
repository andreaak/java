package com.spring.injection._01_base.service;

import java.util.List;

import com.spring.injection._01_base.model.Customer;
import com.spring.injection._01_base.repository.CustomerRepository;
public class CustomerServiceImpl implements CustomerService {

	private String desc;
	public String getDescription() {
		return desc;
	}

	private CustomerRepository customerRepository;
	
	public CustomerServiceImpl() {
		desc = "We are using default Constructor Injection 1_1";
		System.out.println(desc);
		//this.customerRepository = new HibernateCustomerRepositoryImpl(); //for Autowire="default"
	}
	
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		desc = "We are using Constructor Injection 1_1";
		System.out.println(desc);
		this.customerRepository = customerRepository;
	}
	
	public void setCustomerRepository(CustomerRepository customerRepository) {
		desc = "We are using Setter Injection 1_1";
		System.out.println(desc);
		this.customerRepository = customerRepository;
	}
	
	public void setCustomerRepository2(CustomerRepository customerRepository) {
		desc = "We are using Setter Injection 1_2";
		System.out.println(desc);
		this.customerRepository = customerRepository;
	}
	
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

}