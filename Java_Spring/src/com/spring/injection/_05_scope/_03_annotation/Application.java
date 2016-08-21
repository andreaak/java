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
			Default Constructor 5_3 Hash:1064265473
			Setter Injection 5_3 Hash:1064265473
			Before getBean
			Default Constructor 5_3 Hash:953082513
			Setter Injection 5_3 Hash:953082513
			Bryan5_3 Default Constructor 5_3 + Setter Injection 5_3 Hash: 953082513
			com.spring.injection._05_scope._03_annotation.CustomerServiceImpl@38cee291
			Default Constructor 5_3 Hash:252277567
			Setter Injection 5_3 Hash:252277567
			com.spring.injection._05_scope._03_annotation.CustomerServiceImpl@f09733f
			Default Constructor 5_3 Hash:238357312
			Setter Injection 5_3 Hash:238357312
			com.spring.injection._05_scope._03_annotation.CustomerServiceImpl@e350b40
			---------------------------------------------------
			com.spring.injection._05_scope._03_annotation.CustomerServiceImpl@3f6f6701
			com.spring.injection._05_scope._03_annotation.CustomerServiceImpl@3f6f6701
			Bryan5_3 Default Constructor 5_3 + Setter Injection 5_3 Hash: 1064265473
			*/				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
