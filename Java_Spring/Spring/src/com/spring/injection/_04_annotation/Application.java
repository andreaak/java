package com.spring.injection._04_annotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.injection._01_base.service.ICustomerService;

@RunWith(JUnit4.class)
public class Application {

	@SuppressWarnings("resource")
	@Test
	public void testSetter() {
		
		try {
			ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
			System.out.println("Before getBean");
			ICustomerService service= appContext.getBean("customerServiceSetter", ICustomerService.class);
			System.out.println(service.findAll().get(0).getFirstname());
			/*
			Use bean customerServiceSetter
			Create CustomerRepository
			Injection through Setter04
			Use bean customerServiceCtor
			Create CustomerRepository
			Injection through Ctor04
			Before getBean
			Bryan04
			*/
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCtor() {
		
		try {
			ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
			System.out.println("Before getBean");			
			ICustomerService service= appContext.getBean("customerServiceCtor", ICustomerService.class);
			System.out.println(service.findAll().get(0).getFirstname());
			/*
			Use bean customerServiceSetter
			Create CustomerRepository
			Injection through Setter04
			Use bean customerServiceCtor
			Create CustomerRepository
			Injection through Ctor04
			Before getBean
			Bryan04
			*/			
	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAutoWired() {
		
		try {
		
			ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfigAutowired.class);
			System.out.println("Before getBean");			
			ICustomerService service = appContext.getBean("customerService", ICustomerService.class);
			System.out.println(service.findAll().get(0).getFirstname());
			/*
			Use bean customerServiceSetter
			Create CustomerRepository
			Injection through Setter04
			Use bean customerServiceCtor
			Create CustomerRepository
			Injection through Ctor04
			Use customerService
			Injection through Setter042.2
			Before getBean
			Bryan042
			*/				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
