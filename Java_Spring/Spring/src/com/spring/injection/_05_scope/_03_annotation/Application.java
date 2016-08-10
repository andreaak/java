package com.spring.injection._05_scope._03_annotation;

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
	public void test() {
		
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		ICustomerService service = appContext.getBean("customerServiceProt", ICustomerService.class);
		
		System.out.println(service);
		
		ICustomerService service2 = appContext.getBean("customerServiceProt", ICustomerService.class);
		
		System.out.println(service2);
		
		System.out.println("---------------------------------------");
		
		ICustomerService service3 = appContext.getBean("customerServiceSingle", ICustomerService.class);
		
		System.out.println(service3);
		
		ICustomerService service4 = appContext.getBean("customerServiceSingle", ICustomerService.class);
		
		System.out.println(service4);
		
		System.out.println(service.findAll().get(0).getFirstname());
	}

}
