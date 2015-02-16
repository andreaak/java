package com.spring.injection._03_annotationAndXml;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.injection._01_base.repository.CustomerRepository;
import com.spring.injection._01_base.service.CustomerService;

@RunWith(JUnit4.class)
public class Application {

	@SuppressWarnings("resource")
	@Test
	public void test() {
		
		try {
			ApplicationContext appContext = new ClassPathXmlApplicationContext("com/spring/injection/_03_annotationAndXml/applicationContext.xml");
			
			CustomerService service = appContext.getBean("customerService3_1", CustomerService.class);
			System.out.println(service.findAll().get(0).getFirstname());
			
			service = appContext.getBean("customerService3_2", CustomerService.class);
			System.out.println(service.findAll().get(0).getFirstname());			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
