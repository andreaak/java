package com.spring.injection._02_autowire;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.injection._01_base.service.ICustomerService;

@RunWith(JUnit4.class)
public class Application {

	@Test
	public void testPropertyByName() {
		
		ApplicationContext appContext = null;
		
		try {
			appContext = new ClassPathXmlApplicationContext("com/spring/injection/_02_autowire/applicationContext.xml");
			
			System.out.println("before GetBean customerServicePropertyByName");
			ICustomerService service = appContext.getBean("customerServicePropertyByName", ICustomerService.class);
			System.out.println(service.findAll().get(0).getFirstname()+ " " +  service.getDescription());
			/*
			Default Constructor 1 + 564623280 + 
			Setter Injection By Name + 564623280 + 
			Default Constructor 1 + 2040714514 + 
			Setter Injection 1_1 + 2040714514 + 
			Setter Injection By Name + 2040714514 + 
			Constructor 1 + 865900755 + 
			Default Constructor 1 + 1844797213 + 
			before GetBean customerServicePropertyByName
			Brian2 Default Constructor 1 + 564623280 + Setter Injection By Name + 564623280 + 
			*/
			
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	@Test
	public void testPropertyByType() {
		try {
			ApplicationContext appContext = new ClassPathXmlApplicationContext("com/spring/injection/_02_autowire/applicationContext.xml");
			
			System.out.println("before GetBean customerServicePropertyByType");
			ICustomerService service = appContext.getBean("customerServicePropertyByType", ICustomerService.class);
			System.out.println(service.findAll().get(0).getFirstname() + " " +  service.getDescription());
			/*
			Default Constructor 1 + 627798450 + 
			Setter Injection By Name + 627798450 + 
			Default Constructor 1 + 821391439 + 
			Setter Injection 1_1 + 821391439 + 
			Setter Injection By Name + 821391439 + 
			Constructor 1 + 184237900 + 
			Default Constructor 1 + 1962449973 + 
			before GetBean customerServicePropertyByType
			Brian2 Default Constructor 1 + 821391439 + Setter Injection 1_1 + 821391439 + Setter Injection By Name + 821391439 +
 			*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCtor() {
		try {
			ApplicationContext appContext = new ClassPathXmlApplicationContext("com/spring/injection/_02_autowire/applicationContext.xml");
			
			System.out.println("before GetBean customerServiceByCtor");
			ICustomerService service = appContext.getBean("customerServiceByCtor", ICustomerService.class);
			System.out.println(service.findAll().get(0).getFirstname()+ " " +  service.getDescription());
			/*
			Default Constructor 1 + 141438114 + 
			Setter Injection By Name + 141438114 + 
			Default Constructor 1 + 716847386 + 
			Setter Injection 1_1 + 716847386 + 
			Setter Injection By Name + 716847386 + 
			Constructor 1 + 1910696297 + 
			Default Constructor 1 + 1749690088 + 
			before GetBean customerServiceByCtor
			Brian2 Constructor 1 + 1910696297 + 
			*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDefault() {
		try {
			ApplicationContext appContext = new ClassPathXmlApplicationContext("com/spring/injection/_02_autowire/applicationContext.xml");
			
			System.out.println("before GetBean customerServicePropertyDefault");
			//If a default constructor is found, use “autowired by constructor”; Otherwise, use “autowire by type”.
			ICustomerService service = appContext.getBean("customerServicePropertyDefault", ICustomerService.class);
			System.out.println(service.findAll().get(0).getFirstname() + " " +  service.getDescription());
			/*
			Default Constructor 1 + 1378505534 + 
			Setter Injection By Name + 1378505534 + 
			Default Constructor 1 + 1488926102 + 
			Setter Injection 1_1 + 1488926102 + 
			Setter Injection By Name + 1488926102 + 
			Constructor 1 + 355851636 + 
			Default Constructor 1 + 56489357 + 
			before GetBean customerServicePropertyDefault
			Brian1 Default Constructor 1 + 56489357 + 
			*/

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
