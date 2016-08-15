package com.spring.injection._05_scope._02_annotationAndXml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.spring.injection._01_base.model.Customer;
import com.spring.injection._01_base.repository.HibernateCustomerRepositoryImpl;
import com.spring.injection._01_base.repository.ICustomerRepository;
import com.spring.injection._01_base.service.ICustomerService;

@Service("customerServicePrototype")
@Scope("prototype")
public class CustomerServiceImpl implements ICustomerService {

	private String desc = "";
	public String getDescription() {
		return desc;
	}

	private ICustomerRepository customerRepository;
	
	public CustomerServiceImpl() {
		String data = "Default Constructor 5_2 + " + this.hashCode() + " + ";
		System.out.println(data);
		desc += data;
		this.customerRepository = new HibernateCustomerRepositoryImpl();
	}
	
	public CustomerServiceImpl(ICustomerRepository customerRepository) {
		String data = "Constructor 5_2 + " + this.hashCode() + " + ";
		System.out.println(data);
		desc += data;
		this.customerRepository = customerRepository;
	}
	
	@Autowired
	public void setCustomerRepository(ICustomerRepository customerRepository) {
		String data = "Setter Injection 5_2 + " + this.hashCode() + " + ";
		System.out.println(data);
		desc += data;
		this.customerRepository = customerRepository;
	}
	
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}
}
