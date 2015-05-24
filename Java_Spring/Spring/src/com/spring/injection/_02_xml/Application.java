package com.spring.injection._02_xml;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.injection._01_base.service.CustomerService;

@RunWith(JUnit4.class)
public class Application {

	@SuppressWarnings("resource")
	@Test
	public void test() {
		try {
			ApplicationContext appContext = new ClassPathXmlApplicationContext("com/spring/injection/_02_xml/applicationContext.xml");
			
			CustomerService service = appContext.getBean("customerServiceProperty", CustomerService.class);
			System.out.println("customerServiceProperty: " +service.findAll().get(0).getFirstname());
			
			service = appContext.getBean("customerServicePropertyName", CustomerService.class);
			System.out.println("customerServicePropertyName: " + service.findAll().get(0).getFirstname());

			service = appContext.getBean("customerServicePropertyName2", CustomerService.class);
			System.out.println("customerServicePropertyName2: " + service.findAll().get(0).getFirstname());
			
			service = appContext.getBean("customerServiceProperty2_1", CustomerService.class);
			System.out.println("customerServiceProperty2_1: " + service.findAll().get(0).getFirstname());			
			
			service = appContext.getBean("customerServiceProperty2_2", CustomerService.class);
			System.out.println("customerServiceProperty2_2: " + service.findAll().get(0).getFirstname());
			
			service = appContext.getBean("customerServiceProperty2_3", CustomerService.class);
			System.out.println("customerServiceProperty2_3: " + service.findAll().get(0).getFirstname());			
			
			service = appContext.getBean("customerServicePropertyWithConstant", CustomerService.class);
			System.out.println("customerServicePropertyWithConstant: " + service.findAll().get(0).getFirstname());	
			
			service = appContext.getBean("customerServicePropertyWithConstant2", CustomerService.class);
			System.out.println("customerServicePropertyWithConstant2: " + service.findAll().get(0).getFirstname());				
			
			
			service = appContext.getBean("customerServiceCtor", CustomerService.class);
			System.out.println("customerServiceCtor: " + service.findAll().get(0).getFirstname());
			
			service = appContext.getBean("customerServiceCtor2_1", CustomerService.class);
			System.out.println("customerServiceCtor2_1: " + service.findAll().get(0).getFirstname());			
			
			service = appContext.getBean("customerServiceCtor2_2", CustomerService.class);
			System.out.println("customerServiceCtor2_2: " + service.findAll().get(0).getFirstname());				
			
			service = appContext.getBean("customerServiceCtorWithConstant", CustomerService.class);
			System.out.println("customerServiceCtorWithConstant: " + service.findAll().get(0).getFirstname());
			
			service = appContext.getBean("customerServiceCtorWithConstant2", CustomerService.class);
			System.out.println("customerServiceCtorWithConstant2: " + service.findAll().get(0).getFirstname());			
			
			service = appContext.getBean("customerServiceCtorWithConstantString", CustomerService.class);
			System.out.println("customerServiceCtorWithConstantString: " + service.findAll().get(0).getFirstname());			
			
			service = appContext.getBean("customerServiceCtorWithConstantInt", CustomerService.class);
			System.out.println("customerServiceCtorWithConstantInt: " + service.findAll().get(0).getFirstname());					
			
			appContext = new GenericXmlApplicationContext("classpath:com/spring/injection/_02_xml/applicationContext.xml");
			
			service = appContext.getBean("customerServiceCtorWithConstant", CustomerService.class);
			System.out.println("customerServiceCtorWithConstant: " + service.findAll().get(0).getFirstname());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
