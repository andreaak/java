package com.spring.injection._04_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.injection._01_base.repository.CustomerRepository;
import com.spring.injection._01_base.service.CustomerService;
import com.spring.injection._04_annotation.repository.HibernateCustomerRepositoryImpl;
import com.spring.injection._04_annotation.service.CustomerServiceImpl;

@Configuration
public class AppConfig {
	
	@Bean(name="customerServiceSetter")
	public CustomerService getCustomerServiceSetter() {
		System.out.println("Use customerServiceSetter");
		CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
		customerServiceImpl.setCustomerRepository(getCustomerRepository());
		return customerServiceImpl;
	}
	
	@Bean(name="customerServiceCtor")
	public CustomerService getCustomerServiceCtor() {
		System.out.println("Use customerServiceCtor");
		return new CustomerServiceImpl(getCustomerRepository());
	}
	
	//@Bean(name="customerRepository")
	public CustomerRepository getCustomerRepository() {
		return new HibernateCustomerRepositoryImpl();
	}
}
