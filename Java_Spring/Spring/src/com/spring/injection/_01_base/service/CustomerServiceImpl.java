package com.spring.injection._01_base.service;

import java.util.List;

import com.spring.injection._01_base.model.Customer;
import com.spring.injection._01_base.repository.HibernateCustomerRepositoryImpl;
import com.spring.injection._01_base.repository.HibernateCustomerRepositoryImpl2;
import com.spring.injection._01_base.repository.ICustomerRepository;
public class CustomerServiceImpl implements ICustomerService {

	private String desc = "";
	public String getDescription() {
		return desc;
	}

	private ICustomerRepository customerRepository;
	
	public CustomerServiceImpl() {
		String data = "Default Constructor 1 + " + this.hashCode() + " + ";
		System.out.println(data);
		desc += data;
		this.customerRepository = new HibernateCustomerRepositoryImpl(); //for Autowire="default"
	}
	
	public CustomerServiceImpl(ICustomerRepository customerRepository) {
		String data = "Constructor 1 + " + this.hashCode() + " + ";
		System.out.println(data);
		desc += data;
		this.customerRepository = customerRepository;
	}
	
	public void setCustomerRepository(ICustomerRepository customerRepository) {
		String data = "Setter Injection 1_1 + " + this.hashCode() + " + ";
		System.out.println(data);
		desc += data;
		this.customerRepository = customerRepository;
	}
	
	//by name bean name="customerRepository2"
	public void setCustomerRepository2(ICustomerRepository customerRepository) {
		String data = "Setter Injection By Name + " + this.hashCode() + " + ";
		System.out.println(data);
		desc += data;
		this.customerRepository = customerRepository;
	}
	
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}
}