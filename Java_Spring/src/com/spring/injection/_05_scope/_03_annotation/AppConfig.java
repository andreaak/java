package com.spring.injection._05_scope._03_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.spring.injection._01_base.service.ICustomerService;

@Configuration
@ComponentScan({"com.spring.injection._05_scope._03_annotation"})
public class AppConfig {
	
	@Bean(name = "customerServicePrototype")
	@Scope("prototype")
	public ICustomerService getCustomerService() {
		CustomerServiceImpl customerService = new CustomerServiceImpl();
		return customerService;
	}
	
	@Bean(name = "customerServiceSingleton")
	@Scope("singleton")
	public ICustomerService getCustomerService2() {
		CustomerServiceImpl customerService = new CustomerServiceImpl();		
		return customerService;
	}
	
}
