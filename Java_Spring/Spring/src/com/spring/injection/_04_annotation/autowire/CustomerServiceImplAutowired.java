package com.spring.injection._04_annotation.autowire;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.injection._01_base.model.Customer;
import com.spring.injection._01_base.repository.HibernateCustomerRepositoryImpl;
import com.spring.injection._01_base.repository.ICustomerRepository;
import com.spring.injection._01_base.service.CustomerServiceBase;
import com.spring.injection._01_base.service.ICustomerService;
import com.spring.injection._01_base.service.LoggingInfo;

public class CustomerServiceImplAutowired extends CustomerServiceBase implements ICustomerService {

	@Autowired
	private ICustomerRepository customerRepository;
	
	@Override
	protected String getIndex() {
		return "4_2";
	}
	
	public CustomerServiceImplAutowired() {
		LoggingInfo info = getMethodDescription("Default Constructor");
		System.out.println(info);
		this.customerRepository = new HibernateCustomerRepositoryImpl();
	}
	
	//@Autowired
	public CustomerServiceImplAutowired(ICustomerRepository customerRepository) {
		LoggingInfo info = getMethodDescription("Constructor");
		System.out.println(info);
		this.customerRepository = customerRepository;
	}
	
	//@Autowired
	public void setCustomerRepository(ICustomerRepository customerRepository) {
		LoggingInfo info = getMethodDescription("Setter Injection");
		System.out.println(info);
		this.customerRepository = customerRepository;
	}

	public List<Customer> findAll() {
		return customerRepository.findAll();
	}
}