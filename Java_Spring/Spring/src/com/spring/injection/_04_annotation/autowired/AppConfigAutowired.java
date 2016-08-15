package com.spring.injection._04_annotation.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.spring.injection._01_base.repository.ICustomerRepository;
import com.spring.injection._01_base.service.ICustomerService;

@Configuration
@ComponentScan({"com.spring.injection._04_annotation.autowired"})
public class AppConfigAutowired {
	
	@Autowired
	ICustomerRepository repository;
	
	@Bean(name="customerRepository2")
	public ICustomerRepository getCustomerRepository2() {
		return new HibernateCustomerRepositoryImplAutowired();
	}
	
//	@Bean(name="customerRepository3")
//	public CustomerRepository getCustomerRepository3() {
//		return new HibernateCustomerRepositoryImpl2();
//	}
	
	@Bean(name="customerService")
	public ICustomerService getCustomerService() {
		System.out.println("Use getCustomerService");
		return new CustomerServiceImplAutowired();
	}
	
	@Bean(name="customerServiceCtor")
	public ICustomerService getCustomerServiceCtor() {
		System.out.println("Use getCustomerServiceCtor");
		return new CustomerServiceImplAutowired(repository);
	}
}
