package com.spring.injection._05_scope._03_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.spring.injection._01_base.service.CustomerService;
import com.spring.injection._05_scope._03_annotation.service.CustomerServiceImpl;

@Configuration
@ComponentScan({"com.spring.injection._05_scope._03_annotation"})
public class AppConfig {
	
	@Bean(name = "customerServiceProt")
	@Scope("prototype")
	public CustomerService getCustomerService() {
		CustomerServiceImpl customerService = new CustomerServiceImpl();
		return customerService;
	}
	
	@Bean(name = "customerServiceSingle")
	@Scope("singleton")
	public CustomerService getCustomerService2() {
		CustomerServiceImpl customerService = new CustomerServiceImpl();		
		return customerService;
	}
	
}
