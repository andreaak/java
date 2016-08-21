package com.spring.injection._01_base.service;

import java.util.List;

import com.spring.injection._01_base.model.Customer;
import com.spring.injection._01_base.repository.ICustomerRepository;
import com.spring.injection._01_base.repository.HibernateCustomerRepositoryImpl;
public class CustomerServiceImpl2 extends CustomerServiceBase implements ICustomerService {

	private ICustomerRepository customerRepository ;
	
	@Override
	protected String getIndex() {
		return "2";
	}
	
	public CustomerServiceImpl2() {
		LoggingInfo info = getMethodDescription("Default Constructor");
		System.out.println(info);
		this.customerRepository = new HibernateCustomerRepositoryImpl();
	}
	
	public CustomerServiceImpl2(String temp) {
		LoggingInfo info = getMethodDescription("Constructor with string '" + temp + "'");
		System.out.println(info);
		this.customerRepository = new HibernateCustomerRepositoryImpl();
	}
	
	public CustomerServiceImpl2(int temp) {
		LoggingInfo info = getMethodDescription("Constructor with int '" + temp + "'");
		System.out.println(info);
		this.customerRepository = new HibernateCustomerRepositoryImpl();
	}
	
	public void setCustomerRepository(String temp) {
		LoggingInfo info = getMethodDescription("Setter Injection with string '" + temp + "'");
		System.out.println(info);
		this.customerRepository = new HibernateCustomerRepositoryImpl();
	}
	
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}
}