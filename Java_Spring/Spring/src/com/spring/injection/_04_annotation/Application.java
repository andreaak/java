package com.spring.injection._04_annotation;

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
		
		try {
			ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
			
			CustomerService service2= appContext.getBean("customerServiceSetter", CustomerService.class);
			System.out.println(service2.findAll().get(0).getFirstname());
			
			CustomerService service3= appContext.getBean("customerServiceCtor", CustomerService.class);
			System.out.println(service3.findAll().get(0).getFirstname());
			
			ApplicationContext appContext2 = new AnnotationConfigApplicationContext(AppConfig2.class);
			
			CustomerService service4 = appContext2.getBean("customerService", CustomerService.class);
			System.out.println(service4.findAll().get(0).getFirstname());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
