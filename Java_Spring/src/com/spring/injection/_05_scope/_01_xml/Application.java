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
			Default Constructor 1 Hash:1760126453
			Setter Injection By Name 1 Hash:1760126453
			Before getBean
			Default Constructor 1 Hash:16868310
			Setter Injection By Name 1 Hash:16868310
			Brian1 Default Constructor 1 + Setter Injection By Name 1 Hash: 16868310
			com.spring.injection._01_base.service.CustomerServiceImpl@10163d6
			Default Constructor 1 Hash:364639279
			Setter Injection By Name 1 Hash:364639279
			com.spring.injection._01_base.service.CustomerServiceImpl@15bbf42f
			Default Constructor 1 Hash:1427040229
			Setter Injection By Name 1 Hash:1427040229
			com.spring.injection._01_base.service.CustomerServiceImpl@550ee7e5
			---------------------------------------------------
			com.spring.injection._01_base.service.CustomerServiceImpl@68e965f5
			com.spring.injection._01_base.service.CustomerServiceImpl@68e965f5
			Brian1 Default Constructor 1 + Setter Injection By Name 1 Hash: 1760126453
			*/				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
