package com.spring.injection._01_base.service;

import java.util.List;

import com.spring.injection._01_base.model.Customer;
import com.spring.injection._01_base.repository.HibernateCustomerRepositoryImpl;
import com.spring.injection._01_base.repository.ICustomerRepository;

public class CustomerServiceImpl extends CustomerServiceBase implements ICustomerService {

	private ICustomerRepository customerRepository;
	
	@Override
	protected String getIndex() {
		return "1";
	}
	
	public CustomerServiceImpl() {
		LoggingInfo info = getMethodDescription("Default Constructor");
		System.out.println(info);
		this.customerRepository = new HibernateCustomerRepositoryImpl();//for Autowire="default"
	}
	
	public CustomerServiceImpl(ICustomerRepository customerRepository) {
		LoggingInfo info = getMethodDescription("Constructor");
		System.out.println(info);
		this.customerRepository = customerRepository;
	}
	
	public void setCustomerRepository(ICustomerRepository customerRepository) {
		LoggingInfo info = getMethodDescription("Setter Injection");
		System.out.println(info);
		this.customerRepository = customerRepository;
	}
	
	//by name bean name="customerRepository2"
	public void setCustomerRepository2(ICustomerRepository customerRepository) {
		LoggingInfo info = getMethodDescription("Setter Injection By Name");
		System.out.println(info);
		this.customerRepository = customerRepository;
	}
	
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}
}