package com.spring.injection._05_scope._03_annotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.injection._01_base.service.ICustomerService;


@RunWith(JUnit4.class)
public class Application {

	@Test
	public void test() {
		
		try {
			
			ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);

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
			Default Constructor 5_3 + 1771667101 + 
			Setter Injection 5_3 + 1771667101 + 
			Before getBean
			Default Constructor 5_3 + 1992550266 + 
			Setter Injection 5_3 + 1992550266 + 
			Bryan5_3 Default Constructor 5_3 + 1992550266 + Setter Injection 5_3 + 1992550266 + 
			com.spring.injection._05_scope._03_annotation.CustomerServiceImpl@76c3e77a
			Default Constructor 5_3 + 1740846921 + 
			Setter Injection 5_3 + 1740846921 + 
			com.spring.injection._05_scope._03_annotation.CustomerServiceImpl@67c33749
			Default Constructor 5_3 + 263885523 + 
			Setter Injection 5_3 + 263885523 + 
			com.spring.injection._05_scope._03_annotation.CustomerServiceImpl@fba92d3
			---------------------------------------------------
			com.spring.injection._05_scope._03_annotation.CustomerServiceImpl@69997e9d
			com.spring.injection._05_scope._03_annotation.CustomerServiceImpl@69997e9d
			Bryan5_3 Default Constructor 5_3 + 1771667101 + Setter Injection 5_3 + 1771667101 + 
			*/				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
