package com.spring.injection._06_propfile._01_annotationAndXml;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.injection._01_base.service.ICustomerService;

@RunWith(JUnit4.class)
public class Application {

	@Test
	public void test() {
		
		try {
			
			ApplicationContext appContext = new ClassPathXmlApplicationContext("com/spring/injection/_06_propfile/_01_annotationAndXml/applicationContext.xml");
	
			ICustomerService service = appContext.getBean("customerService", ICustomerService.class);
	
			System.out.println(service.findAll().get(0).getFirstname() + " " +  service.getDescription());	
			
			/*
			Default Constructor 6_1 Hash:556281560
			Setter Injection 6_1 Hash:556281560
			anotherName = John Default Constructor 6_1 + Setter Injection 6_1 Hash: 556281560
			*/				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
