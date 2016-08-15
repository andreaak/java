package com.spring.injection._05_scope._01_xml;

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
			
			ApplicationContext appContext = new ClassPathXmlApplicationContext("com/spring/injection/_05_scope/_01_xml/applicationContext.xml");
			
			System.out.println("Before getBean");
			
			ICustomerService service = appContext.getBean("customerServicePrototype", ICustomerService.class);
			System.out.println(service.findAll().get(0).getFirstname() + " " +  service.getDescription());
			System.out.println(service);
			
			ICustomerService service2 = appContext.getBean("customerServicePrototype", ICustomerService.class);
			
			System.out.println(service2);
			
			ICustomerService service3 = appContext.getBean("customerServicePrototype", ICustomerService.class);
			
			System.out.println(service3);
			
			
			System.out.println("---------------------------------------------------");
			
			ICustomerService service4 = appContext.getBean("customerServiceSingleton", ICustomerService.class);
			
			System.out.println(service4);
			
			ICustomerService service5 = appContext.getBean("customerServiceSingleton", ICustomerService.class);
			
			System.out.println(service5);
			System.out.println(service4.findAll().get(0).getFirstname() + " " +  service4.getDescription());	
			
			/*
			Default Constructor 1 + 1069716895 + 
			Setter Injection By Name + 1069716895 + 
			Before getBean
			Default Constructor 1 + 1231156911 + 
			Setter Injection By Name + 1231156911 + 
			Brian1 Default Constructor 1 + 1231156911 + Setter Injection By Name + 1231156911 + 
			com.spring.injection._01_base.service.CustomerServiceImpl@4961f6af
			Default Constructor 1 + 1708169732 + 
			Setter Injection By Name + 1708169732 + 
			com.spring.injection._01_base.service.CustomerServiceImpl@65d09a04
			Default Constructor 1 + 868815265 + 
			Setter Injection By Name + 868815265 + 
			com.spring.injection._01_base.service.CustomerServiceImpl@33c911a1
			---------------------------------------------------
			com.spring.injection._01_base.service.CustomerServiceImpl@3fc2959f
			com.spring.injection._01_base.service.CustomerServiceImpl@3fc2959f
			Brian1 Default Constructor 1 + 1069716895 + Setter Injection By Name + 1069716895 + 
			*/				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
