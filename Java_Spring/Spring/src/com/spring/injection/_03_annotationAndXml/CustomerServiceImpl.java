package com.spring.injection._03_annotationAndXml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.injection._01_base.model.Customer;
import com.spring.injection._01_base.repository.HibernateCustomerRepositoryImpl;
import com.spring.injection._01_base.repository.ICustomerRepository;
import com.spring.injection._01_base.service.CustomerServiceBase;
import com.spring.injection._01_base.service.ICustomerService;
import com.spring.injection._01_base.service.LoggingInfo;

@Service("customerService3_1")
public class CustomerServiceImpl extends CustomerServiceBase implements ICustomerService {

	//@Autowired//инжекция через Default Ctor + поле
	private ICustomerRepository customerRepository;
	
	@Override
	protected String getIndex() {
		return "3";
	}
	
	public CustomerServiceImpl() {
		LoggingInfo info = getMethodDescription("Default Constructor");
		System.out.println(info);
		this.customerRepository = new HibernateCustomerRepositoryImpl();
	}
	
	@Autowired//инжекция через ctor
	public CustomerServiceImpl(ICustomerRepository customerRepository) {
		LoggingInfo info = getMethodDescription("Constructor");
		System.out.println(info);
		this.customerRepository = customerRepository;
	}
	
	//@Autowired//инжекция через Setter
	//@Resource(name="customerRepository3_1")//
	public void setCustomerRepository(ICustomerRepository customerRepository) {
		LoggingInfo info = getMethodDescription("Setter Injection");
		System.out.println(info);
		this.customerRepository = customerRepository;
	}
	
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}
}
