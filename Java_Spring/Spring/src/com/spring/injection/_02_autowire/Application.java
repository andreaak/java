package com.spring.injection._02_autowire;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.injection._01_base.service.CustomerService;

@RunWith(JUnit4.class)
public class Application {

	@SuppressWarnings("resource")
	@Test
	public void test() {
		try {
			ApplicationContext appContext = new ClassPathXmlApplicationContext("com/spring/injection/_02_autowire/applicationContext.xml");
			
			CustomerService service = appContext.getBean("customerServicePropertyByType", CustomerService.class);
			System.out.println(service.findAll().get(0).getFirstname() + " " +  service.getDescription());
			System.out.println("---------");
			
			 service = appContext.getBean("customerServicePropertyByName", CustomerService.class);
			System.out.println(service.findAll().get(0).getFirstname()+ " " +  service.getDescription());
			System.out.println("---------");

//If a default constructor is found, use “autowired by constructor”; Otherwise, use “autowire by type”.
//			service = appContext.getBean("customerServicePropertyDefault", CustomerService.class);
//			System.out.println(service.findAll().get(0).getFirstname());
//			System.out.println("---------");
			service = appContext.getBean("customerServiceByCtor", CustomerService.class);
			System.out.println(service.findAll().get(0).getFirstname()+ " " +  service.getDescription());
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
