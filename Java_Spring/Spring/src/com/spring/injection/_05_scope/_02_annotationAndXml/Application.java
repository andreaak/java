package com.spring.injection._05_scope._02_annotationAndXml;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.injection._01_base.service.ICustomerService;

@RunWith(JUnit4.class)
public class Application {

	@SuppressWarnings("resource")
	@Test
	public void test() {
		
		try {
			
			ApplicationContext appContext = new ClassPathXmlApplicationContext("com/spring/injection/_05_scope/_02_annotationAndXml/applicationContext.xml");
			
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
			Default Constructor 5_2_2 + 1866875501 + 
			Setter Injection 5_2_2 + 1866875501 + 
			Before getBean
			Default Constructor 5_2 + 844112759 + 
			Setter Injection 5_2 + 844112759 + 
			Bryan5_2 Default Constructor 5_2 + 844112759 + Setter Injection 5_2 + 844112759 + 
			com.spring.injection._05_scope._02_annotationAndXml.CustomerServiceImpl@32502377
			Default Constructor 5_2 + 1426963578 + 
			Setter Injection 5_2 + 1426963578 + 
			com.spring.injection._05_scope._02_annotationAndXml.CustomerServiceImpl@550dbc7a
			Default Constructor 5_2 + 556281560 + 
			Setter Injection 5_2 + 556281560 + 
			com.spring.injection._05_scope._02_annotationAndXml.CustomerServiceImpl@21282ed8
			---------------------------------------------------
			com.spring.injection._05_scope._02_annotationAndXml.CustomerServiceImpl2@6f46426d
			com.spring.injection._05_scope._02_annotationAndXml.CustomerServiceImpl2@6f46426d
			Bryan5_2 Default Constructor 5_2_2 + 1866875501 + Setter Injection 5_2_2 + 1866875501 + 
			*/				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
