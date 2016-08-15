package com.spring.injection._02_xml;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.injection._01_base.service.ICustomerService;

@RunWith(JUnit4.class)
public class Application {

	@Test
	public void testPropertyGetById() {
		try {
			ApplicationContext appContext = new ClassPathXmlApplicationContext("com/spring/injection/_02_xml/applicationContext.xml");
			System.out.println("before GetBean customerServiceProperty");
			ICustomerService service = appContext.getBean("customerServiceProperty", ICustomerService.class);
			System.out.println(service.findAll().get(0).getFirstname() + " " +  service.getDescription());
			/*
			Default Constructor 1 Hash:484589713
			Setter Injection 1 Hash:484589713
			Default Constructor 1 Hash:793138072
			Setter Injection 1 Hash:793138072
			Default Constructor 1 Hash:1418620248
			Setter Injection 1 Hash:1418620248
			Default Constructor 1 Hash:1648001170
			Setter Injection 1 Hash:1648001170
			Default Constructor 2 Hash:391877669
			Setter Injection with string 'Constant Name' 2 Hash:391877669
			Default Constructor 2 Hash:301749835
			Setter Injection with string 'Constant Name2' 2 Hash:301749835
			Default Constructor 2 Hash:961160488
			Setter Injection with string '90' 2 Hash:961160488
			Constructor 1 Hash:532087022
			Constructor 1 Hash:1248234350
			Constructor 1 Hash:2030036700
			Constructor with string 'Constant Name' 2 Hash:1710265848
			Constructor with string 'Constant Name2' 2 Hash:1047460013
			Constructor with string '90' 2 Hash:1431530910
			Constructor with int '90' 2 Hash:1025309396
			before GetBean customerServiceProperty
			Brian1 Default Constructor 1 + Setter Injection 1 Hash: 484589713		
			*/
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testPropertyGetByName() {
		try {
			ApplicationContext appContext = new ClassPathXmlApplicationContext("com/spring/injection/_02_xml/applicationContext.xml");
			System.out.println("before GetBean customerServicePropertyName");
			ICustomerService service = appContext.getBean("customerServicePropertyName", ICustomerService.class);
			System.out.println(service.findAll().get(0).getFirstname() + " " +  service.getDescription());
			/*
			Default Constructor 1 Hash:484589713
			Setter Injection 1 Hash:484589713
			Default Constructor 1 Hash:793138072
			Setter Injection 1 Hash:793138072
			Default Constructor 1 Hash:1418620248
			Setter Injection 1 Hash:1418620248
			Default Constructor 1 Hash:1648001170
			Setter Injection 1 Hash:1648001170
			Default Constructor 2 Hash:391877669
			Setter Injection with string 'Constant Name' 2 Hash:391877669
			Default Constructor 2 Hash:301749835
			Setter Injection with string 'Constant Name2' 2 Hash:301749835
			Default Constructor 2 Hash:961160488
			Setter Injection with string '90' 2 Hash:961160488
			Constructor 1 Hash:532087022
			Constructor 1 Hash:1248234350
			Constructor 1 Hash:2030036700
			Constructor with string 'Constant Name' 2 Hash:1710265848
			Constructor with string 'Constant Name2' 2 Hash:1047460013
			Constructor with string '90' 2 Hash:1431530910
			Constructor with int '90' 2 Hash:1025309396
			before GetBean customerServicePropertyName
			Brian1 Default Constructor 1 + Setter Injection 1 Hash: 484589713		
			*/		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testPropertyGetByName2() {
		try {
			ApplicationContext appContext = new ClassPathXmlApplicationContext("com/spring/injection/_02_xml/applicationContext.xml");
			System.out.println("before GetBean customerServicePropertyName2");
			ICustomerService service = appContext.getBean("customerServicePropertyName2", ICustomerService.class);
			System.out.println(service.findAll().get(0).getFirstname() + " " +  service.getDescription());
			/*
			Default Constructor 1 Hash:484589713
			Setter Injection 1 Hash:484589713
			Default Constructor 1 Hash:793138072
			Setter Injection 1 Hash:793138072
			Default Constructor 1 Hash:1418620248
			Setter Injection 1 Hash:1418620248
			Default Constructor 1 Hash:1648001170
			Setter Injection 1 Hash:1648001170
			Default Constructor 2 Hash:391877669
			Setter Injection with string 'Constant Name' 2 Hash:391877669
			Default Constructor 2 Hash:301749835
			Setter Injection with string 'Constant Name2' 2 Hash:301749835
			Default Constructor 2 Hash:961160488
			Setter Injection with string '90' 2 Hash:961160488
			Constructor 1 Hash:532087022
			Constructor 1 Hash:1248234350
			Constructor 1 Hash:2030036700
			Constructor with string 'Constant Name' 2 Hash:1710265848
			Constructor with string 'Constant Name2' 2 Hash:1047460013
			Constructor with string '90' 2 Hash:1431530910
			Constructor with int '90' 2 Hash:1025309396
			before GetBean customerServicePropertyName2
			Brian1 Default Constructor 1 + Setter Injection 1 Hash: 484589713			
			*/		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	@Test
	public void testPropertyRefBean() {
		try {
			ApplicationContext appContext = new ClassPathXmlApplicationContext("com/spring/injection/_02_xml/applicationContext.xml");
			System.out.println("before GetBean customerServicePropertyRefBean");
			ICustomerService service = appContext.getBean("customerServicePropertyRefBean", ICustomerService.class);
			System.out.println(service.findAll().get(0).getFirstname() + " " +  service.getDescription());
			/*
			Default Constructor 1 Hash:484589713
			Setter Injection 1 Hash:484589713
			Default Constructor 1 Hash:793138072
			Setter Injection 1 Hash:793138072
			Default Constructor 1 Hash:1418620248
			Setter Injection 1 Hash:1418620248
			Default Constructor 1 Hash:1648001170
			Setter Injection 1 Hash:1648001170
			Default Constructor 2 Hash:391877669
			Setter Injection with string 'Constant Name' 2 Hash:391877669
			Default Constructor 2 Hash:301749835
			Setter Injection with string 'Constant Name2' 2 Hash:301749835
			Default Constructor 2 Hash:961160488
			Setter Injection with string '90' 2 Hash:961160488
			Constructor 1 Hash:532087022
			Constructor 1 Hash:1248234350
			Constructor 1 Hash:2030036700
			Constructor with string 'Constant Name' 2 Hash:1710265848
			Constructor with string 'Constant Name2' 2 Hash:1047460013
			Constructor with string '90' 2 Hash:1431530910
			Constructor with int '90' 2 Hash:1025309396
			before GetBean customerServicePropertyRefBean
			Brian1 Default Constructor 1 + Setter Injection 1 Hash: 793138072			
			*/		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testPropertyRefBeanName() {
		try {
			ApplicationContext appContext = new ClassPathXmlApplicationContext("com/spring/injection/_02_xml/applicationContext.xml");
			System.out.println("before GetBean customerServicePropertyRefBeanName");
			ICustomerService service = appContext.getBean("customerServicePropertyRefBeanName", ICustomerService.class);
			System.out.println(service.findAll().get(0).getFirstname() + " " +  service.getDescription());
			/*
			Default Constructor 1 Hash:484589713
			Setter Injection 1 Hash:484589713
			Default Constructor 1 Hash:793138072
			Setter Injection 1 Hash:793138072
			Default Constructor 1 Hash:1418620248
			Setter Injection 1 Hash:1418620248
			Default Constructor 1 Hash:1648001170
			Setter Injection 1 Hash:1648001170
			Default Constructor 2 Hash:391877669
			Setter Injection with string 'Constant Name' 2 Hash:391877669
			Default Constructor 2 Hash:301749835
			Setter Injection with string 'Constant Name2' 2 Hash:301749835
			Default Constructor 2 Hash:961160488
			Setter Injection with string '90' 2 Hash:961160488
			Constructor 1 Hash:532087022
			Constructor 1 Hash:1248234350
			Constructor 1 Hash:2030036700
			Constructor with string 'Constant Name' 2 Hash:1710265848
			Constructor with string 'Constant Name2' 2 Hash:1047460013
			Constructor with string '90' 2 Hash:1431530910
			Constructor with int '90' 2 Hash:1025309396
			before GetBean customerServicePropertyRefBeanName
			Brian1 Default Constructor 1 + Setter Injection 1 Hash: 1418620248			
			*/		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testPropertyRefBeanId() {
		try {
			ApplicationContext appContext = new ClassPathXmlApplicationContext("com/spring/injection/_02_xml/applicationContext.xml");
			System.out.println("before GetBean customerServicePropertyRefBeanId");
			ICustomerService service = appContext.getBean("customerServicePropertyRefBeanId", ICustomerService.class);
			System.out.println(service.findAll().get(0).getFirstname() + " " +  service.getDescription());
			/*
			Default Constructor 1 Hash:484589713
			Setter Injection 1 Hash:484589713
			Default Constructor 1 Hash:793138072
			Setter Injection 1 Hash:793138072
			Default Constructor 1 Hash:1418620248
			Setter Injection 1 Hash:1418620248
			Default Constructor 1 Hash:1648001170
			Setter Injection 1 Hash:1648001170
			Default Constructor 2 Hash:391877669
			Setter Injection with string 'Constant Name' 2 Hash:391877669
			Default Constructor 2 Hash:301749835
			Setter Injection with string 'Constant Name2' 2 Hash:301749835
			Default Constructor 2 Hash:961160488
			Setter Injection with string '90' 2 Hash:961160488
			Constructor 1 Hash:532087022
			Constructor 1 Hash:1248234350
			Constructor 1 Hash:2030036700
			Constructor with string 'Constant Name' 2 Hash:1710265848
			Constructor with string 'Constant Name2' 2 Hash:1047460013
			Constructor with string '90' 2 Hash:1431530910
			Constructor with int '90' 2 Hash:1025309396
			before GetBean customerServicePropertyRefBeanId
			Brian2 Default Constructor 1 + Setter Injection 1 Hash: 1648001170			
			*/		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testPropertyWithConstant() {
		try {
			ApplicationContext appContext = new ClassPathXmlApplicationContext("com/spring/injection/_02_xml/applicationContext.xml");
			System.out.println("before GetBean customerServicePropertyWithConstant");
			ICustomerService service = appContext.getBean("customerServicePropertyWithConstant", ICustomerService.class);
			System.out.println(service.findAll().get(0).getFirstname() + " " +  service.getDescription());
			/*
			Default Constructor 1 Hash:484589713
			Setter Injection 1 Hash:484589713
			Default Constructor 1 Hash:793138072
			Setter Injection 1 Hash:793138072
			Default Constructor 1 Hash:1418620248
			Setter Injection 1 Hash:1418620248
			Default Constructor 1 Hash:1648001170
			Setter Injection 1 Hash:1648001170
			Default Constructor 2 Hash:391877669
			Setter Injection with string 'Constant Name' 2 Hash:391877669
			Default Constructor 2 Hash:301749835
			Setter Injection with string 'Constant Name2' 2 Hash:301749835
			Default Constructor 2 Hash:961160488
			Setter Injection with string '90' 2 Hash:961160488
			Constructor 1 Hash:532087022
			Constructor 1 Hash:1248234350
			Constructor 1 Hash:2030036700
			Constructor with string 'Constant Name' 2 Hash:1710265848
			Constructor with string 'Constant Name2' 2 Hash:1047460013
			Constructor with string '90' 2 Hash:1431530910
			Constructor with int '90' 2 Hash:1025309396
			before GetBean customerServicePropertyWithConstant
			Brian1 Default Constructor 2 + Setter Injection with string 'Constant Name' 2 Hash: 391877669 
			*/		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testPropertyWithConstant2() {
		try {
			ApplicationContext appContext = new ClassPathXmlApplicationContext("com/spring/injection/_02_xml/applicationContext.xml");
			System.out.println("before GetBean customerServicePropertyWithConstant2");
			ICustomerService service = appContext.getBean("customerServicePropertyWithConstant2", ICustomerService.class);
			System.out.println(service.findAll().get(0).getFirstname() + " " +  service.getDescription());
			/*
			Default Constructor 1 Hash:484589713
			Setter Injection 1 Hash:484589713
			Default Constructor 1 Hash:793138072
			Setter Injection 1 Hash:793138072
			Default Constructor 1 Hash:1418620248
			Setter Injection 1 Hash:1418620248
			Default Constructor 1 Hash:1648001170
			Setter Injection 1 Hash:1648001170
			Default Constructor 2 Hash:391877669
			Setter Injection with string 'Constant Name' 2 Hash:391877669
			Default Constructor 2 Hash:301749835
			Setter Injection with string 'Constant Name2' 2 Hash:301749835
			Default Constructor 2 Hash:961160488
			Setter Injection with string '90' 2 Hash:961160488
			Constructor 1 Hash:532087022
			Constructor 1 Hash:1248234350
			Constructor 1 Hash:2030036700
			Constructor with string 'Constant Name' 2 Hash:1710265848
			Constructor with string 'Constant Name2' 2 Hash:1047460013
			Constructor with string '90' 2 Hash:1431530910
			Constructor with int '90' 2 Hash:1025309396
			before GetBean customerServicePropertyWithConstant2
			Brian1 Default Constructor 2 + Setter Injection with string 'Constant Name2' 2 Hash: 301749835		
			*/		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	@Test
	public void testCtorRefBean() {
		try {
			ApplicationContext appContext = new ClassPathXmlApplicationContext("com/spring/injection/_02_xml/applicationContext.xml");
			System.out.println("before GetBean customerServiceCtorRefBean");
			ICustomerService service = appContext.getBean("customerServiceCtorRefBean", ICustomerService.class);
			System.out.println(service.findAll().get(0).getFirstname() + " " +  service.getDescription());
			/*
			Default Constructor 1 Hash:484589713
			Setter Injection 1 Hash:484589713
			Default Constructor 1 Hash:793138072
			Setter Injection 1 Hash:793138072
			Default Constructor 1 Hash:1418620248
			Setter Injection 1 Hash:1418620248
			Default Constructor 1 Hash:1648001170
			Setter Injection 1 Hash:1648001170
			Default Constructor 2 Hash:391877669
			Setter Injection with string 'Constant Name' 2 Hash:391877669
			Default Constructor 2 Hash:301749835
			Setter Injection with string 'Constant Name2' 2 Hash:301749835
			Default Constructor 2 Hash:961160488
			Setter Injection with string '90' 2 Hash:961160488
			Constructor 1 Hash:532087022
			Constructor 1 Hash:1248234350
			Constructor 1 Hash:2030036700
			Constructor with string 'Constant Name' 2 Hash:1710265848
			Constructor with string 'Constant Name2' 2 Hash:1047460013
			Constructor with string '90' 2 Hash:1431530910
			Constructor with int '90' 2 Hash:1025309396
			before GetBean customerServiceCtorRefBean
			Brian1 Constructor 1 Hash: 532087022	
			*/		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	@Test
	public void testCtorRefBeanName() {
		try {
			ApplicationContext appContext = new ClassPathXmlApplicationContext("com/spring/injection/_02_xml/applicationContext.xml");
			System.out.println("before GetBean customerServiceCtorRefBeanName");
			ICustomerService service = appContext.getBean("customerServiceCtorRefBeanName", ICustomerService.class);
			System.out.println(service.findAll().get(0).getFirstname() + " " +  service.getDescription());
			/*
			Default Constructor 1 Hash:484589713
			Setter Injection 1 Hash:484589713
			Default Constructor 1 Hash:793138072
			Setter Injection 1 Hash:793138072
			Default Constructor 1 Hash:1418620248
			Setter Injection 1 Hash:1418620248
			Default Constructor 1 Hash:1648001170
			Setter Injection 1 Hash:1648001170
			Default Constructor 2 Hash:391877669
			Setter Injection with string 'Constant Name' 2 Hash:391877669
			Default Constructor 2 Hash:301749835
			Setter Injection with string 'Constant Name2' 2 Hash:301749835
			Default Constructor 2 Hash:961160488
			Setter Injection with string '90' 2 Hash:961160488
			Constructor 1 Hash:532087022
			Constructor 1 Hash:1248234350
			Constructor 1 Hash:2030036700
			Constructor with string 'Constant Name' 2 Hash:1710265848
			Constructor with string 'Constant Name2' 2 Hash:1047460013
			Constructor with string '90' 2 Hash:1431530910
			Constructor with int '90' 2 Hash:1025309396
			before GetBean customerServiceCtorRefBeanName
			Brian1 Constructor 1 Hash: 1248234350	
			*/		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCtorRefBeanId() {
		try {
			ApplicationContext appContext = new ClassPathXmlApplicationContext("com/spring/injection/_02_xml/applicationContext.xml");
			System.out.println("before GetBean customerServiceCtorRefBeanId");
			ICustomerService service = appContext.getBean("customerServiceCtorRefBeanId", ICustomerService.class);
			System.out.println(service.findAll().get(0).getFirstname() + " " +  service.getDescription());
			/*
			Default Constructor 1 Hash:484589713
			Setter Injection 1 Hash:484589713
			Default Constructor 1 Hash:793138072
			Setter Injection 1 Hash:793138072
			Default Constructor 1 Hash:1418620248
			Setter Injection 1 Hash:1418620248
			Default Constructor 1 Hash:1648001170
			Setter Injection 1 Hash:1648001170
			Default Constructor 2 Hash:391877669
			Setter Injection with string 'Constant Name' 2 Hash:391877669
			Default Constructor 2 Hash:301749835
			Setter Injection with string 'Constant Name2' 2 Hash:301749835
			Default Constructor 2 Hash:961160488
			Setter Injection with string '90' 2 Hash:961160488
			Constructor 1 Hash:532087022
			Constructor 1 Hash:1248234350
			Constructor 1 Hash:2030036700
			Constructor with string 'Constant Name' 2 Hash:1710265848
			Constructor with string 'Constant Name2' 2 Hash:1047460013
			Constructor with string '90' 2 Hash:1431530910
			Constructor with int '90' 2 Hash:1025309396
			before GetBean customerServiceCtorRefBeanId
			Brian1 Constructor 1 Hash: 2030036700			
			*/		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	@Test
	public void testCtorWithConstant() {
		try {
			ApplicationContext appContext = new ClassPathXmlApplicationContext("com/spring/injection/_02_xml/applicationContext.xml");
			System.out.println("before GetBean customerServiceCtorWithConstant");
			ICustomerService service = appContext.getBean("customerServiceCtorWithConstant", ICustomerService.class);
			System.out.println(service.findAll().get(0).getFirstname() + " " +  service.getDescription());
			/*
			Default Constructor 1 Hash:484589713
			Setter Injection 1 Hash:484589713
			Default Constructor 1 Hash:793138072
			Setter Injection 1 Hash:793138072
			Default Constructor 1 Hash:1418620248
			Setter Injection 1 Hash:1418620248
			Default Constructor 1 Hash:1648001170
			Setter Injection 1 Hash:1648001170
			Default Constructor 2 Hash:391877669
			Setter Injection with string 'Constant Name' 2 Hash:391877669
			Default Constructor 2 Hash:301749835
			Setter Injection with string 'Constant Name2' 2 Hash:301749835
			Default Constructor 2 Hash:961160488
			Setter Injection with string '90' 2 Hash:961160488
			Constructor 1 Hash:532087022
			Constructor 1 Hash:1248234350
			Constructor 1 Hash:2030036700
			Constructor with string 'Constant Name' 2 Hash:1710265848
			Constructor with string 'Constant Name2' 2 Hash:1047460013
			Constructor with string '90' 2 Hash:1431530910
			Constructor with int '90' 2 Hash:1025309396
			before GetBean customerServiceCtorWithConstant
			Brian1 Constructor with string 'Constant Name' 2 Hash: 1710265848		
			*/		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCtorWithConstant2() {
		try {
			ApplicationContext appContext = new ClassPathXmlApplicationContext("com/spring/injection/_02_xml/applicationContext.xml");
			System.out.println("before GetBean customerServiceCtorWithConstant2");
			ICustomerService service = appContext.getBean("customerServiceCtorWithConstant2", ICustomerService.class);
			System.out.println(service.findAll().get(0).getFirstname() + " " +  service.getDescription());
			/*
			Default Constructor 1 Hash:484589713
			Setter Injection 1 Hash:484589713
			Default Constructor 1 Hash:793138072
			Setter Injection 1 Hash:793138072
			Default Constructor 1 Hash:1418620248
			Setter Injection 1 Hash:1418620248
			Default Constructor 1 Hash:1648001170
			Setter Injection 1 Hash:1648001170
			Default Constructor 2 Hash:391877669
			Setter Injection with string 'Constant Name' 2 Hash:391877669
			Default Constructor 2 Hash:301749835
			Setter Injection with string 'Constant Name2' 2 Hash:301749835
			Default Constructor 2 Hash:961160488
			Setter Injection with string '90' 2 Hash:961160488
			Constructor 1 Hash:532087022
			Constructor 1 Hash:1248234350
			Constructor 1 Hash:2030036700
			Constructor with string 'Constant Name' 2 Hash:1710265848
			Constructor with string 'Constant Name2' 2 Hash:1047460013
			Constructor with string '90' 2 Hash:1431530910
			Constructor with int '90' 2 Hash:1025309396
			before GetBean customerServiceCtorWithConstant2
			Brian1 Constructor with string 'Constant Name2' 2 Hash: 1047460013			
			*/		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}		
	
	@Test
	public void testCtorWithConstantString() {
		try {
			ApplicationContext appContext = new ClassPathXmlApplicationContext("com/spring/injection/_02_xml/applicationContext.xml");
			System.out.println("before GetBean customerServiceCtorWithConstantString");
			ICustomerService service = appContext.getBean("customerServiceCtorWithConstantString", ICustomerService.class);
			System.out.println(service.findAll().get(0).getFirstname() + " " +  service.getDescription());
			/*
			Default Constructor 1 Hash:484589713
			Setter Injection 1 Hash:484589713
			Default Constructor 1 Hash:793138072
			Setter Injection 1 Hash:793138072
			Default Constructor 1 Hash:1418620248
			Setter Injection 1 Hash:1418620248
			Default Constructor 1 Hash:1648001170
			Setter Injection 1 Hash:1648001170
			Default Constructor 2 Hash:391877669
			Setter Injection with string 'Constant Name' 2 Hash:391877669
			Default Constructor 2 Hash:301749835
			Setter Injection with string 'Constant Name2' 2 Hash:301749835
			Default Constructor 2 Hash:961160488
			Setter Injection with string '90' 2 Hash:961160488
			Constructor 1 Hash:532087022
			Constructor 1 Hash:1248234350
			Constructor 1 Hash:2030036700
			Constructor with string 'Constant Name' 2 Hash:1710265848
			Constructor with string 'Constant Name2' 2 Hash:1047460013
			Constructor with string '90' 2 Hash:1431530910
			Constructor with int '90' 2 Hash:1025309396
			before GetBean customerServiceCtorWithConstantString
			Brian1 Constructor with string '90' 2 Hash: 1431530910		
			*/		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCtorWithConstantInt() {
		try {
			ApplicationContext appContext = new ClassPathXmlApplicationContext("com/spring/injection/_02_xml/applicationContext.xml");
			System.out.println("before GetBean customerServiceCtorWithConstantInt");
			ICustomerService service = appContext.getBean("customerServiceCtorWithConstantInt", ICustomerService.class);
			System.out.println(service.findAll().get(0).getFirstname() + " " +  service.getDescription());
			/*
			Default Constructor 1 Hash:484589713
			Setter Injection 1 Hash:484589713
			Default Constructor 1 Hash:793138072
			Setter Injection 1 Hash:793138072
			Default Constructor 1 Hash:1418620248
			Setter Injection 1 Hash:1418620248
			Default Constructor 1 Hash:1648001170
			Setter Injection 1 Hash:1648001170
			Default Constructor 2 Hash:391877669
			Setter Injection with string 'Constant Name' 2 Hash:391877669
			Default Constructor 2 Hash:301749835
			Setter Injection with string 'Constant Name2' 2 Hash:301749835
			Default Constructor 2 Hash:961160488
			Setter Injection with string '90' 2 Hash:961160488
			Constructor 1 Hash:532087022
			Constructor 1 Hash:1248234350
			Constructor 1 Hash:2030036700
			Constructor with string 'Constant Name' 2 Hash:1710265848
			Constructor with string 'Constant Name2' 2 Hash:1047460013
			Constructor with string '90' 2 Hash:1431530910
			Constructor with int '90' 2 Hash:1025309396
			before GetBean customerServiceCtorWithConstantInt
			Brian1 Constructor with int '90' 2 Hash: 1025309396		
			*/		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}
