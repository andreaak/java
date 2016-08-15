package com.spring.injection._04_annotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.injection._01_base.service.ICustomerService;

@RunWith(JUnit4.class)
public class Application {

	@Test
	public void testSetter() {
		
		try {
			ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
			System.out.println("Before getBean customerServiceSetter");
			ICustomerService service= appContext.getBean("customerServiceSetter", ICustomerService.class);
			System.out.println(service.findAll().get(0).getFirstname() + " " +  service.getDescription());
			/*
			Use getCustomerServiceSetter
			Default Constructor 4 Hash:1047460013
			Use getCustomerRepository
			Setter Injection 4 Hash:1047460013
			Use getCustomerServiceCtor
			Use getCustomerRepository
			Constructor 4 Hash:1025309396
			Before getBean customerServiceSetter
			Bryan4_1 Default Constructor 4 + Setter Injection 4 Hash: 1047460013 
			*/
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCtor() {
		
		try {
			ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
			System.out.println("Before getBean customerServiceCtor");			
			ICustomerService service= appContext.getBean("customerServiceCtor", ICustomerService.class);
			System.out.println(service.findAll().get(0).getFirstname() + " " +  service.getDescription());
			/*
			Use getCustomerServiceSetter
			Default Constructor 4 Hash:1047460013
			Use getCustomerRepository
			Setter Injection 4 Hash:1047460013
			Use getCustomerServiceCtor
			Use getCustomerRepository
			Constructor 4 Hash:1025309396
			Before getBean customerServiceCtor
			Bryan4_1 Constructor 4 Hash: 1025309396
			*/			
	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
