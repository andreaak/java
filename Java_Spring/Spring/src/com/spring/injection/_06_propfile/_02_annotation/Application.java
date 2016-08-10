package com.spring.injection._06_propfile._02_annotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.injection._01_base.service.ICustomerService;


@RunWith(JUnit4.class)
public class Application {

	@SuppressWarnings("resource")
	@Test
	public void est() {
		
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		
		ICustomerService service = appContext.getBean("customerService", ICustomerService.class);
		
		
		System.out.println(service.findAll().get(0).getFirstname());
	}

}
