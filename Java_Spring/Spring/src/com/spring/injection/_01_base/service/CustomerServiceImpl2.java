package com.spring.injection._01_base.service;

import java.util.List;

import com.spring.injection._01_base.model.Customer;
import com.spring.injection._01_base.repository.ICustomerRepository;
import com.spring.injection._01_base.repository.HibernateCustomerRepositoryImpl;
public class CustomerServiceImpl2 implements ICustomerService {

	private ICustomerRepository customerRepository;
	
	private String desc = "";
	public String getDescription() {
		return desc;
	}
	
	public CustomerServiceImpl2() {
		String data = "Default Constructor 2 + " + this.hashCode() + " + ";
		System.out.println(data);
		desc += data;
	}
	
	public CustomerServiceImpl2(String temp) {
		String data = "Constructor 2 string '" + temp + "' + " + this.hashCode() + " + ";
		System.out.println(data);
		desc += data;
		
		this.customerRepository = new HibernateCustomerRepositoryImpl();

	}
	
	public CustomerServiceImpl2(int temp) {
		String data = "Constructor 2 int " + Integer.toString(temp) + " + " + this.hashCode() + " + ";
		System.out.println(data);
		desc += data;

		this.customerRepository = new HibernateCustomerRepositoryImpl();
	}
	
	public void setCustomerRepository(String temp) {
		
		String data = "Setter 2 string '" + temp + "' + " + this.hashCode() + " + ";
		System.out.println(data);
		desc += data;

		this.customerRepository = new HibernateCustomerRepositoryImpl();
	}
	
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}
}