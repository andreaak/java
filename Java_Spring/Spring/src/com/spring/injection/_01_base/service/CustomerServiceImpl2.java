package com.spring.injection._01_base.service;

import java.util.List;

import com.spring.injection._01_base.model.Customer;
import com.spring.injection._01_base.repository.CustomerRepository;
import com.spring.injection._01_base.repository.HibernateCustomerRepositoryImpl;
public class CustomerServiceImpl2 implements CustomerService {

	
	private CustomerRepository customerRepository;
	private String desc;
	public String getDescription() {
		return desc;
	}
	
	public CustomerServiceImpl2() {
		System.out.println("We are using default Constructor Injection 1_2");
	}
	
	public CustomerServiceImpl2(String temp) {
		System.out.println("We are using Constructor Injection 1_2");
		this.customerRepository = new HibernateCustomerRepositoryImpl();
		this.desc = temp;
	}
	
	public CustomerServiceImpl2(int temp) {
		System.out.println("We are using Int Constructor Injection 1_2");
		this.customerRepository = new HibernateCustomerRepositoryImpl();
		this.desc = Integer.toString(temp) + "Int";
	}
	
	public void setCustomerRepository(String temp) {
		System.out.println("We are using Setter Injection 1_2");
		this.customerRepository = new HibernateCustomerRepositoryImpl();
		this.desc = temp;
	}
	
	public List<Customer> findAll() {
		
		List<Customer> customers = customerRepository.findAll();
		for(Customer customer : customers) {
			
			customer.setFirstname(desc);
		}
		return customers;
	}

}