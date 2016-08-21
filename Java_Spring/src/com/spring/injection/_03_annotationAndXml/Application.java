package com.spring.injection._03_annotationAndXml;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.injection._01_base.service.ICustomerService;

@RunWith(JUnit4.class)
public class Application {

	@Test
	public void testScanAndAutowired() {
		
		try {
			ApplicationContext appContext = new ClassPathXmlApplicationContext("com/spring/injection/_03_annotationAndXml/applicationContext.xml");
			
			ICustomerService service = appContext.getBean("customerService3_1", ICustomerService.class);
			System.out.println(service.findAll().get(0).getFirstname() + " " +  service.getDescription());
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		Constructor 3 Hash:1225038340
		Default Constructor 1 Hash:658909832
		Setter Injection 1 Hash:658909832
		Setter Injection By Name 1 Hash:658909832
		Bryan3_1 Constructor 3 Hash: 1225038340
		*/
	}
	
	@Test
	public void testXmlConfig() {
		
		try {
			ApplicationContext appContext = new ClassPathXmlApplicationContext("com/spring/injection/_03_annotationAndXml/applicationContext.xml");
			
			ICustomerService service = appContext.getBean("customerService3_2", ICustomerService.class);
			System.out.println(service.findAll().get(0).getFirstname() + " " +  service.getDescription());		
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		Constructor 3 Hash:1225038340
		Default Constructor 1 Hash:658909832
		Setter Injection 1 Hash:658909832
		Setter Injection By Name 1 Hash:658909832
		Bryan3_1 Default Constructor 1 + Setter Injection 1 + Setter Injection By Name 1 Hash: 658909832 
		*/		
	}

}
