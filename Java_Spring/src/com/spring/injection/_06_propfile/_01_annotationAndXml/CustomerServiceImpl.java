package com.spring.injection._06_propfile._01_annotationAndXml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.injection._01_base.model.Customer;
import com.spring.injection._01_base.repository.HibernateCustomerRepositoryImpl;
import com.spring.injection._01_base.repository.ICustomerRepository;
import com.spring.injection._01_base.service.CustomerServiceBase;
import com.spring.injection._01_base.service.ICustomerService;
import com.spring.injection._01_base.service.LoggingInfo;

@Service("customerService")
public class CustomerServiceImpl extends CustomerServiceBase implements ICustomerService {

	private ICustomerRepository customerRepository;
	
	@Override
	protected String getIndex() {
		return "6_1";
	}
	
	public CustomerServiceImpl() {
		LoggingInfo info =  getMethodDescription("Default Constructor");
		System.out.println(info);
		this.customerRepository = new HibernateCustomerRepositoryImpl();
	}
	
	public CustomerServiceImpl(ICustomerRepository customerRepository) {
		LoggingInfo info =  getMethodDescription("Constructor");
		System.out.println(info);
		this.customerRepository = customerRepository;
	}
	
	@Autowired
	public void setCustomerRepository(ICustomerRepository customerRepository) {
		LoggingInfo info = getMethodDescription("Setter Injection");
		System.out.println(info);
		this.customerRepository = customerRepository;
	}
	
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}
}
