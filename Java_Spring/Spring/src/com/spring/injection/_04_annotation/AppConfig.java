package com.spring.injection._04_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.injection._01_base.repository.ICustomerRepository;
import com.spring.injection._01_base.service.ICustomerService;
import com.spring.injection._04_annotation.repository.HibernateCustomerRepositoryImpl;
import com.spring.injection._04_annotation.service.CustomerServiceImpl;

@Configuration
public class AppConfig {
	
	@Bean(name="customerServiceSetter")
	public ICustomerService getCustomerServiceSetter() {
		System.out.println("Use bean customerServiceSetter");
		CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
		customerServiceImpl.setCustomerRepository(getCustomerRepository());
		return customerServiceImpl;
	}
	
	@Bean(name="customerServiceCtor")
	public ICustomerService getCustomerServiceCtor() {
		System.out.println("Use bean customerServiceCtor");
		return new CustomerServiceImpl(getCustomerRepository());
	}
	
	//@Bean(name="customerRepository")
	public ICustomerRepository getCustomerRepository() {
		System.out.println("Create CustomerRepository");
		return new HibernateCustomerRepositoryImpl();
	}
}
