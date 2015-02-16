package com.spring.injection._05_scope._03_annotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.injection._01_base.service.CustomerService;


@RunWith(JUnit4.class)
public class Application {

	@SuppressWarnings("resource")
	@Test
	public void test() {
		
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		CustomerService service = appContext.getBean("customerServiceProt", CustomerService.class);
		
		System.out.println(service);
		
		CustomerService service2 = appContext.getBean("customerServiceProt", CustomerService.class);
		
		System.out.println(service2);
		
		System.out.println("---------------------------------------");
		
		CustomerService service3 = appContext.getBean("customerServiceSingle", CustomerService.class);
		
		System.out.println(service3);
		
		CustomerService service4 = appContext.getBean("customerServiceSingle", CustomerService.class);
		
		System.out.println(service4);
		
		System.out.println(service.findAll().get(0).getFirstname());
	}

}
