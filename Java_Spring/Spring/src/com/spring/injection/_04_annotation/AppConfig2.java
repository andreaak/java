package com.spring.injection._04_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.spring.injection._01_base.service.CustomerService;
import com.spring.injection._04_annotation.service.CustomerServiceImpl2;

@Configuration
@ComponentScan({"com.spring.injection._04_annotation"})
public class AppConfig2 {
	
//	@Bean(name="customerRepository2")
//	public CustomerRepository getCustomerRepository2() {
//		return new HibernateCustomerRepositoryImpl();
//	}
	
//	@Bean(name="customerRepository3")
//	public CustomerRepository getCustomerRepository3() {
//		return new HibernateCustomerRepositoryImpl2();
//	}
	
	@Bean(name="customerService")
	public CustomerService getCustomerService() {
		System.out.println("Use customerService");
		return new CustomerServiceImpl2();
	}
}
