package com.spring.injection._03_annotationAndXml.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.injection._01_base.model.Customer;
import com.spring.injection._01_base.repository.ICustomerRepository;
import com.spring.injection._01_base.service.ICustomerService;

@Service("customerService3_1")
public class CustomerServiceImpl implements ICustomerService {

	//@Autowired
	private ICustomerRepository customerRepository;
	
	public CustomerServiceImpl() {
		
	}
	@Autowired
	public CustomerServiceImpl(ICustomerRepository customerRepository) {
		System.out.println("Injection through Ctor3_1");
		this.customerRepository = customerRepository;
	}
	//@Autowired//@Resource(name="customerRepository3_1")//
	public void setCustomerRepository(ICustomerRepository customerRepository) {
		System.out.println("Injection through Setter3_1");
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
