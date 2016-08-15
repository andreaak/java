package com.spring.injection._05_scope._02_annotationAndXml;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.spring.injection._01_base.model.Customer;
import com.spring.injection._01_base.repository.HibernateCustomerRepositoryImpl;
import com.spring.injection._01_base.repository.ICustomerRepository;
import com.spring.injection._01_base.service.CustomerServiceBase;
import com.spring.injection._01_base.service.ICustomerService;
import com.spring.injection._01_base.service.LoggingInfo;

@Service("customerServiceSingleton")
@Scope("singleton")
public class CustomerServiceImpl2 extends CustomerServiceBase implements ICustomerService {

	private ICustomerRepository customerRepository;
	
	@Override
	protected String getIndex() {
		return "5_2_2";
	}
	
	public CustomerServiceImpl2() {
		LoggingInfo info = getMethodDescription("Default Constructor");
		System.out.println(info);
		this.customerRepository = new HibernateCustomerRepositoryImpl();
	}
	
	public CustomerServiceImpl2(ICustomerRepository customerRepository) {
		LoggingInfo info = getMethodDescription("Constructor");
		System.out.println(info);
		this.customerRepository = customerRepository;
	}
	
	public void setCustomerRepository(ICustomerRepository customerRepository) {
		LoggingInfo info = getMethodDescription("Setter Injection");
		System.out.println(info);
		this.customerRepository = customerRepository;
	}

	public List<Customer> findAll() {
		return customerRepository.findAll();
	}
}
