package com.spring.injection._05_scope._02_annotationAndXml;

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
			Default Constructor 5_2_2 Hash:1409160703
			Before getBean
			Default Constructor 5_2 Hash:661119548
			Brian1 Default Constructor 5_2 Hash: 661119548
			com.spring.injection._05_scope._02_annotationAndXml.CustomerServiceImpl@2767e23c
			Default Constructor 5_2 Hash:216856121
			com.spring.injection._05_scope._02_annotationAndXml.CustomerServiceImpl@cecf639
			Default Constructor 5_2 Hash:480903748
			com.spring.injection._05_scope._02_annotationAndXml.CustomerServiceImpl@1caa0244
			---------------------------------------------------
			com.spring.injection._05_scope._02_annotationAndXml.CustomerServiceImpl2@53fe15ff
			com.spring.injection._05_scope._02_annotationAndXml.CustomerServiceImpl2@53fe15ff
			Brian1 Default Constructor 5_2_2 Hash: 1409160703
			*/				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
