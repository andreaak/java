package com.spring.injection._04_annotation.autowired;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.injection._01_base.service.ICustomerService;

@RunWith(JUnit4.class)
public class Application {
	
	@Test
	public void testAutoWiredSetter() {
		
		try {
		
			ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfigAutowired.class);
			System.out.println("Before getBean customerService");			
			ICustomerService service = appContext.getBean("customerService", ICustomerService.class);
			System.out.println(service.findAll().get(0).getFirstname() + " " +  service.getDescription());
			/*
			Use getCustomerService
			Default Constructor 4_2 Hash:1212116343
			Use getCustomerServiceCtor
			Constructor 4_2 Hash:454305524
			Before getBean customerService
			Bryan4_2 Default Constructor 4_2 Hash: 1212116343 
			*/				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAutoWiredCtor() {
		
		try {
		
			ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfigAutowired.class);
			System.out.println("Before getBean customerServiceCtor");			
			ICustomerService service = appContext.getBean("customerServiceCtor", ICustomerService.class);
			System.out.println(service.findAll().get(0).getFirstname() + " " +  service.getDescription());
			/*
			Use getCustomerService
			Default Constructor 4_2 Hash:1212116343
			Use getCustomerServiceCtor
			Constructor 4_2 Hash:454305524
			Before getBean customerServiceCtor
			Bryan4_2 Constructor 4_2 Hash: 454305524
			*/				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
