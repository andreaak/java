package com.spring.injection._04_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.injection._01_base.repository.ICustomerRepository;
import com.spring.injection._01_base.service.ICustomerService;

@Configuration
public class AppConfig {
	
	@Bean(name="customerServiceSetter")
	public ICustomerService getCustomerServiceSetter() {
		System.out.println("Use getCustomerServiceSetter");
		CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
		customerServiceImpl.setCustomerRepository(getCustomerRepository());
		return customerServiceImpl;
	}
	
	@Bean(name="customerServiceCtor")
	public ICustomerService getCustomerServiceCtor() {
		System.out.println("Use getCustomerServiceCtor");
		return new CustomerServiceImpl(getCustomerRepository());
	}
	
	//@Bean(name="customerRepository")
	public ICustomerRepository getCustomerRepository() {
		System.out.println("Use getCustomerRepository");
		return new HibernateCustomerRepositoryImpl();
	}
}
