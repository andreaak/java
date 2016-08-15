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
	public void testSetterByName() {
		
		ApplicationContext appContext = null;
		
		try {
			appContext = new ClassPathXmlApplicationContext("com/spring/injection/_02_autowire/applicationContext.xml");
			
			System.out.println("before GetBean customerServicePropertyByName");
			ICustomerService service = appContext.getBean("customerServicePropertyByName", ICustomerService.class);
			System.out.println(service.findAll().get(0).getFirstname()+ " " +  service.getDescription());
			/*
			Default Constructor 1 Hash:590845366
			Setter Injection By Name 1 Hash:590845366
			Default Constructor 1 Hash:961409111
			Setter Injection 1 Hash:961409111
			Setter Injection By Name 1 Hash:961409111
			Constructor 1 Hash:2053591126
			Default Constructor 1 Hash:220309324
			before GetBean customerServicePropertyByName
			Brian2 Default Constructor 1 + Setter Injection By Name 1 Hash: 590845366
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
			Default Constructor 1 Hash:590845366
			Setter Injection By Name 1 Hash:590845366
			Default Constructor 1 Hash:961409111
			Setter Injection 1 Hash:961409111
			Setter Injection By Name 1 Hash:961409111
			Constructor 1 Hash:2053591126
			Default Constructor 1 Hash:220309324
			before GetBean customerServicePropertyByType
			Brian2 Default Constructor 1 + Setter Injection 1 + Setter Injection By Name 1 Hash: 961409111
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
			Default Constructor 1 Hash:590845366
			Setter Injection By Name 1 Hash:590845366
			Default Constructor 1 Hash:961409111
			Setter Injection 1 Hash:961409111
			Setter Injection By Name 1 Hash:961409111
			Constructor 1 Hash:2053591126
			Default Constructor 1 Hash:220309324
			before GetBean customerServiceByCtor
			Brian2 Constructor 1 Hash: 2053591126
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
			Default Constructor 1 Hash:590845366
			Setter Injection By Name 1 Hash:590845366
			Default Constructor 1 Hash:961409111
			Setter Injection 1 Hash:961409111
			Setter Injection By Name 1 Hash:961409111
			Constructor 1 Hash:2053591126
			Default Constructor 1 Hash:220309324
			before GetBean customerServicePropertyDefault
			Brian1 Default Constructor 1 Hash: 220309324
			*/

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
