package com.spring.injection._06_propfile._02_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.spring.injection._01_base.service.ICustomerService;
import com.spring.injection._06_propfile._02_annotation.service.CustomerServiceImpl;


@Configuration
@ComponentScan({"com.spring.injection._06_propfile._02_annotation"})
@PropertySource("com/spring/injection/_06_propfile/_02_annotation/app.properties")
public class AppConfig {
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Bean(name = "customerService")
	public ICustomerService getCustomerService() {
		CustomerServiceImpl customerService = new CustomerServiceImpl();		
		return customerService;
	}
}
