package com.spring.injection._02_xml;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.injection._01_base.service.ICustomerService;

@RunWith(JUnit4.class)
public class Application {

	@Test
	public void testProperty() {
		try {
			ApplicationContext appContext = new ClassPathXmlApplicationContext("com/spring/injection/_02_xml/applicationContext.xml");
			System.out.println("before GetBean customerServiceProperty");
			ICustomerService service = appContext.getBean("customerServiceProperty", ICustomerService.class);
			System.out.println(service.findAll().get(0).getFirstname() + " " +  service.getDescription());
			/*
			Default Constructor 1 + 2079453894 + 
			Setter Injection 1_1 + 2079453894 + 
			Default Constructor 1 + 1232725180 + 
			Setter Injection 1_1 + 1232725180 + 
			Default Constructor 1 + 1637357651 + 
			Setter Injection 1_1 + 1637357651 + 
			Default Constructor 1 + 1214587699 + 
			Setter Injection 1_1 + 1214587699 + 
			Default Constructor 2 + 1743392358 + 
			Setter 2 string 'Constant Name' + 1743392358 + 
			Default Constructor 2 + 928481238 + 
			Setter 2 string 'Constant Name2' + 928481238 + 
			Default Constructor 2 + 1367987964 + 
			Setter 2 string '90' + 1367987964 + 
			Constructor 1 + 638119430 + 
			Constructor 1 + 844772824 + 
			Constructor 1 + 1615801620 + 
			Constructor 2 string 'Constant Name' + 1467497219 + 
			Constructor 2 string 'Constant Name2' + 630302845 + 
			Constructor 2 string '90' + 196806031 + 
			Constructor 2 int 90 + 23569509 + 
			before GetBean customerServiceProperty
			Brian1 Default Constructor 1 + 2079453894 + Setter Injection 1_1 + 2079453894 + 			
			*/
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testPropertyName() {
		try {
			ApplicationContext appContext = new ClassPathXmlApplicationContext("com/spring/injection/_02_xml/applicationContext.xml");
			System.out.println("before GetBean customerServicePropertyName");
			ICustomerService service = appContext.getBean("customerServicePropertyName", ICustomerService.class);
			System.out.println(service.findAll().get(0).getFirstname() + " " +  service.getDescription());
			/*
			Default Constructor 1 + 1234470601 + 
			Setter Injection 1_1 + 1234470601 + 
			Default Constructor 1 + 907877340 + 
			Setter Injection 1_1 + 907877340 + 
			Default Constructor 1 + 823141445 + 
			Setter Injection 1_1 + 823141445 + 
			Default Constructor 1 + 448612141 + 
			Setter Injection 1_1 + 448612141 + 
			Default Constructor 2 + 9169170 + 
			Setter 2 string 'Constant Name' + 9169170 + 
			Default Constructor 2 + 1634901253 + 
			Setter 2 string 'Constant Name2' + 1634901253 + 
			Default Constructor 2 + 732095806 + 
			Setter 2 string '90' + 732095806 + 
			Constructor 1 + 795132749 + 
			Constructor 1 + 179648560 + 
			Constructor 1 + 484268062 + 
			Constructor 2 string 'Constant Name' + 34948851 + 
			Constructor 2 string 'Constant Name2' + 1199767081 + 
			Constructor 2 string '90' + 261398093 + 
			Constructor 2 int 90 + 2100371435 + 
			before GetBean customerServicePropertyName
			Brian1 Default Constructor 1 + 1234470601 + Setter Injection 1_1 + 1234470601 + 			
			*/		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testPropertyName2() {
		try {
			ApplicationContext appContext = new ClassPathXmlApplicationContext("com/spring/injection/_02_xml/applicationContext.xml");
			System.out.println("before GetBean customerServicePropertyName2");
			ICustomerService service = appContext.getBean("customerServicePropertyName2", ICustomerService.class);
			System.out.println(service.findAll().get(0).getFirstname() + " " +  service.getDescription());
			/*
			Default Constructor 1 + 840054516 + 
			Setter Injection 1_1 + 840054516 + 
			Default Constructor 1 + 1238755034 + 
			Setter Injection 1_1 + 1238755034 + 
			Default Constructor 1 + 2049382420 + 
			Setter Injection 1_1 + 2049382420 + 
			Default Constructor 1 + 480118707 + 
			Setter Injection 1_1 + 480118707 + 
			Default Constructor 2 + 1259046770 + 
			Setter 2 string 'Constant Name' + 1259046770 + 
			Default Constructor 2 + 1642689499 + 
			Setter 2 string 'Constant Name2' + 1642689499 + 
			Default Constructor 2 + 632643861 + 
			Setter 2 string '90' + 632643861 + 
			Constructor 1 + 914000857 + 
			Constructor 1 + 194859196 + 
			Constructor 1 + 1376957295 + 
			Constructor 2 string 'Constant Name' + 1153792315 + 
			Constructor 2 string 'Constant Name2' + 196888452 + 
			Constructor 2 string '90' + 1045850211 + 
			Constructor 2 int 90 + 1039390058 + 
			before GetBean customerServicePropertyName2
			Brian1 Default Constructor 1 + 840054516 + Setter Injection 1_1 + 840054516 + 			
			*/		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	@Test
	public void testPropertyName2_1() {
		try {
			ApplicationContext appContext = new ClassPathXmlApplicationContext("com/spring/injection/_02_xml/applicationContext.xml");
			System.out.println("before GetBean customerServicePropertyName2");
			ICustomerService service = appContext.getBean("customerServiceProperty2_1", ICustomerService.class);
			System.out.println(service.findAll().get(0).getFirstname() + " " +  service.getDescription());
			/*
			Default Constructor 1 + 1683471006 + 
			Setter Injection 1_1 + 1683471006 + 
			Default Constructor 1 + 1000148617 + 
			Setter Injection 1_1 + 1000148617 + 
			Default Constructor 1 + 1143300850 + 
			Setter Injection 1_1 + 1143300850 + 
			Default Constructor 1 + 1921196241 + 
			Setter Injection 1_1 + 1921196241 + 
			Default Constructor 2 + 2128589842 + 
			Setter 2 string 'Constant Name' + 2128589842 + 
			Default Constructor 2 + 279399121 + 
			Setter 2 string 'Constant Name2' + 279399121 + 
			Default Constructor 2 + 1461774305 + 
			Setter 2 string '90' + 1461774305 + 
			Constructor 1 + 1516006997 + 
			Constructor 1 + 418638324 + 
			Constructor 1 + 367052603 + 
			Constructor 2 string 'Constant Name' + 756645719 + 
			Constructor 2 string 'Constant Name2' + 612581943 + 
			Constructor 2 string '90' + 1801015376 + 
			Constructor 2 int 90 + 2084933658 + 
			before GetBean customerServicePropertyName2
			Brian1 Default Constructor 1 + 1000148617 + Setter Injection 1_1 + 1000148617 + 			
			*/		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testPropertyName2_2() {
		try {
			ApplicationContext appContext = new ClassPathXmlApplicationContext("com/spring/injection/_02_xml/applicationContext.xml");
			System.out.println("before GetBean customerServiceProperty2_2");
			ICustomerService service = appContext.getBean("customerServiceProperty2_2", ICustomerService.class);
			System.out.println(service.findAll().get(0).getFirstname() + " " +  service.getDescription());
			/*
			Default Constructor 1 + 1293579037 + 
			Setter Injection 1_1 + 1293579037 + 
			Default Constructor 1 + 58432631 + 
			Setter Injection 1_1 + 58432631 + 
			Default Constructor 1 + 677202538 + 
			Setter Injection 1_1 + 677202538 + 
			Default Constructor 1 + 79727066 + 
			Setter Injection 1_1 + 79727066 + 
			Default Constructor 2 + 2090486181 + 
			Setter 2 string 'Constant Name' + 2090486181 + 
			Default Constructor 2 + 1968779147 + 
			Setter 2 string 'Constant Name2' + 1968779147 + 
			Default Constructor 2 + 843090653 + 
			Setter 2 string '90' + 843090653 + 
			Constructor 1 + 1073067421 + 
			Constructor 1 + 186469824 + 
			Constructor 1 + 438957460 + 
			Constructor 2 string 'Constant Name' + 2132909556 + 
			Constructor 2 string 'Constant Name2' + 656405809 + 
			Constructor 2 string '90' + 515794745 + 
			Constructor 2 int 90 + 1918064652 + 
			before GetBean customerServiceProperty2_2
			Brian1 Default Constructor 1 + 677202538 + Setter Injection 1_1 + 677202538 + 			
			*/		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testPropertyName2_3() {
		try {
			ApplicationContext appContext = new ClassPathXmlApplicationContext("com/spring/injection/_02_xml/applicationContext.xml");
			System.out.println("before GetBean customerServiceProperty2_3");
			ICustomerService service = appContext.getBean("customerServiceProperty2_3", ICustomerService.class);
			System.out.println(service.findAll().get(0).getFirstname() + " " +  service.getDescription());
			/*
			Default Constructor 1 + 816519533 + 
			Setter Injection 1_1 + 816519533 + 
			Default Constructor 1 + 823286801 + 
			Setter Injection 1_1 + 823286801 + 
			Default Constructor 1 + 744126786 + 
			Setter Injection 1_1 + 744126786 + 
			Default Constructor 1 + 1741615821 + 
			Setter Injection 1_1 + 1741615821 + 
			Default Constructor 2 + 1134994937 + 
			Setter 2 string 'Constant Name' + 1134994937 + 
			Default Constructor 2 + 1910153505 + 
			Setter 2 string 'Constant Name2' + 1910153505 + 
			Default Constructor 2 + 1216919532 + 
			Setter 2 string '90' + 1216919532 + 
			Constructor 1 + 133764711 + 
			Constructor 1 + 465037281 + 
			Constructor 1 + 744859144 + 
			Constructor 2 string 'Constant Name' + 1056640661 + 
			Constructor 2 string 'Constant Name2' + 880625364 + 
			Constructor 2 string '90' + 1209743372 + 
			Constructor 2 int 90 + 802590979 + 
			before GetBean customerServiceProperty2_3
			Brian2 Default Constructor 1 + 1741615821 + Setter Injection 1_1 + 1741615821 + 			
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
			Default Constructor 1 + 1063034436 + 
			Setter Injection 1_1 + 1063034436 + 
			Default Constructor 1 + 554866228 + 
			Setter Injection 1_1 + 554866228 + 
			Default Constructor 1 + 1262698722 + 
			Setter Injection 1_1 + 1262698722 + 
			Default Constructor 1 + 744021000 + 
			Setter Injection 1_1 + 744021000 + 
			Default Constructor 2 + 2111154166 + 
			Setter 2 string 'Constant Name' + 2111154166 + 
			Default Constructor 2 + 1470643491 + 
			Setter 2 string 'Constant Name2' + 1470643491 + 
			Default Constructor 2 + 1715859914 + 
			Setter 2 string '90' + 1715859914 + 
			Constructor 1 + 742768189 + 
			Constructor 1 + 1469233713 + 
			Constructor 1 + 1875593993 + 
			Constructor 2 string 'Constant Name' + 241463462 + 
			Constructor 2 string 'Constant Name2' + 1522289895 + 
			Constructor 2 string '90' + 1505370540 + 
			Constructor 2 int 90 + 359668643 + 
			before GetBean customerServicePropertyWithConstant
			Brian1 Default Constructor 2 + 2111154166 + Setter 2 string 'Constant Name' + 2111154166 + 
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
			Default Constructor 1 + 644590864 + 
			Setter Injection 1_1 + 644590864 + 
			Default Constructor 1 + 1731135780 + 
			Setter Injection 1_1 + 1731135780 + 
			Default Constructor 1 + 1090604904 + 
			Setter Injection 1_1 + 1090604904 + 
			Default Constructor 1 + 1023694383 + 
			Setter Injection 1_1 + 1023694383 + 
			Default Constructor 2 + 1739998964 + 
			Setter 2 string 'Constant Name' + 1739998964 + 
			Default Constructor 2 + 1877766749 + 
			Setter 2 string 'Constant Name2' + 1877766749 + 
			Default Constructor 2 + 206074131 + 
			Setter 2 string '90' + 206074131 + 
			Constructor 1 + 322802193 + 
			Constructor 1 + 1020019215 + 
			Constructor 1 + 868933598 + 
			Constructor 2 string 'Constant Name' + 607479057 + 
			Constructor 2 string 'Constant Name2' + 1076053396 + 
			Constructor 2 string '90' + 1361037703 + 
			Constructor 2 int 90 + 68881864 + 
			before GetBean customerServicePropertyWithConstant2
			Brian1 Default Constructor 2 + 1877766749 + Setter 2 string 'Constant Name2' + 1877766749 + 			
			*/		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	@Test
	public void testCtor() {
		try {
			ApplicationContext appContext = new ClassPathXmlApplicationContext("com/spring/injection/_02_xml/applicationContext.xml");
			System.out.println("before GetBean customerServiceCtor");
			ICustomerService service = appContext.getBean("customerServiceCtor", ICustomerService.class);
			System.out.println(service.findAll().get(0).getFirstname() + " " +  service.getDescription());
			/*
			Default Constructor 1 + 158030246 + 
			Setter Injection 1_1 + 158030246 + 
			Default Constructor 1 + 1724556830 + 
			Setter Injection 1_1 + 1724556830 + 
			Default Constructor 1 + 39858251 + 
			Setter Injection 1_1 + 39858251 + 
			Default Constructor 1 + 2030210340 + 
			Setter Injection 1_1 + 2030210340 + 
			Default Constructor 2 + 587016440 + 
			Setter 2 string 'Constant Name' + 587016440 + 
			Default Constructor 2 + 1389923471 + 
			Setter 2 string 'Constant Name2' + 1389923471 + 
			Default Constructor 2 + 116665031 + 
			Setter 2 string '90' + 116665031 + 
			Constructor 1 + 559852072 + 
			Constructor 1 + 511635087 + 
			Constructor 1 + 1461183154 + 
			Constructor 2 string 'Constant Name' + 1022530210 + 
			Constructor 2 string 'Constant Name2' + 285545076 + 
			Constructor 2 string '90' + 1529464275 + 
			Constructor 2 int 90 + 1669649966 + 
			before GetBean customerServiceCtor
			Brian1 Constructor 1 + 559852072 + 			
			*/		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	@Test
	public void testCtor2() {
		try {
			ApplicationContext appContext = new ClassPathXmlApplicationContext("com/spring/injection/_02_xml/applicationContext.xml");
			System.out.println("before GetBean customerServiceCtor2_1");
			ICustomerService service = appContext.getBean("customerServiceCtor2_1", ICustomerService.class);
			System.out.println(service.findAll().get(0).getFirstname() + " " +  service.getDescription());
			/*
			Default Constructor 1 + 630871084 + 
			Setter Injection 1_1 + 630871084 + 
			Default Constructor 1 + 923543549 + 
			Setter Injection 1_1 + 923543549 + 
			Default Constructor 1 + 2132111174 + 
			Setter Injection 1_1 + 2132111174 + 
			Default Constructor 1 + 495124555 + 
			Setter Injection 1_1 + 495124555 + 
			Default Constructor 2 + 1007790716 + 
			Setter 2 string 'Constant Name' + 1007790716 + 
			Default Constructor 2 + 735039923 + 
			Setter 2 string 'Constant Name2' + 735039923 + 
			Default Constructor 2 + 1490048317 + 
			Setter 2 string '90' + 1490048317 + 
			Constructor 1 + 1402203755 + 
			Constructor 1 + 985141335 + 
			Constructor 1 + 460218551 + 
			Constructor 2 string 'Constant Name' + 1091966081 + 
			Constructor 2 string 'Constant Name2' + 47462628 + 
			Constructor 2 string '90' + 228882909 + 
			Constructor 2 int 90 + 1274818444 + 
			before GetBean customerServiceCtor2_1
			Brian1 Constructor 1 + 985141335 + 			
			*/		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCtor3() {
		try {
			ApplicationContext appContext = new ClassPathXmlApplicationContext("com/spring/injection/_02_xml/applicationContext.xml");
			System.out.println("before GetBean customerServiceCtor2_2");
			ICustomerService service = appContext.getBean("customerServiceCtor2_2", ICustomerService.class);
			System.out.println(service.findAll().get(0).getFirstname() + " " +  service.getDescription());
			/*
			Default Constructor 1 + 978276840 + 
			Setter Injection 1_1 + 978276840 + 
			Default Constructor 1 + 764048448 + 
			Setter Injection 1_1 + 764048448 + 
			Default Constructor 1 + 1557540123 + 
			Setter Injection 1_1 + 1557540123 + 
			Default Constructor 1 + 1898673978 + 
			Setter Injection 1_1 + 1898673978 + 
			Default Constructor 2 + 1554037473 + 
			Setter 2 string 'Constant Name' + 1554037473 + 
			Default Constructor 2 + 1011693897 + 
			Setter 2 string 'Constant Name2' + 1011693897 + 
			Default Constructor 2 + 1911293580 + 
			Setter 2 string '90' + 1911293580 + 
			Constructor 1 + 698358493 + 
			Constructor 1 + 1074203200 + 
			Constructor 1 + 2027892936 + 
			Constructor 2 string 'Constant Name' + 608407663 + 
			Constructor 2 string 'Constant Name2' + 602096181 + 
			Constructor 2 string '90' + 1928842916 + 
			Constructor 2 int 90 + 1817318774 + 
			before GetBean customerServiceCtor2_2
			Brian1 Constructor 1 + 2027892936 + 			
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
			Default Constructor 1 + 120661238 + 
			Setter Injection 1_1 + 120661238 + 
			Default Constructor 1 + 728864298 + 
			Setter Injection 1_1 + 728864298 + 
			Default Constructor 1 + 775533998 + 
			Setter Injection 1_1 + 775533998 + 
			Default Constructor 1 + 1321650743 + 
			Setter Injection 1_1 + 1321650743 + 
			Default Constructor 2 + 1560676680 + 
			Setter 2 string 'Constant Name' + 1560676680 + 
			Default Constructor 2 + 927696302 + 
			Setter 2 string 'Constant Name2' + 927696302 + 
			Default Constructor 2 + 1060470494 + 
			Setter 2 string '90' + 1060470494 + 
			Constructor 1 + 638223659 + 
			Constructor 1 + 956700475 + 
			Constructor 1 + 852586467 + 
			Constructor 2 string 'Constant Name' + 207575907 + 
			Constructor 2 string 'Constant Name2' + 1457264318 + 
			Constructor 2 string '90' + 278484907 + 
			Constructor 2 int 90 + 1209838312 + 
			before GetBean customerServiceCtorWithConstant
			Brian1 Constructor 2 string 'Constant Name' + 207575907 + 			
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
			Default Constructor 1 + 955592184 + 
			Setter Injection 1_1 + 955592184 + 
			Default Constructor 1 + 1755124222 + 
			Setter Injection 1_1 + 1755124222 + 
			Default Constructor 1 + 537423962 + 
			Setter Injection 1_1 + 537423962 + 
			Default Constructor 1 + 168310052 + 
			Setter Injection 1_1 + 168310052 + 
			Default Constructor 2 + 551080865 + 
			Setter 2 string 'Constant Name' + 551080865 + 
			Default Constructor 2 + 2066612191 + 
			Setter 2 string 'Constant Name2' + 2066612191 + 
			Default Constructor 2 + 150587559 + 
			Setter 2 string '90' + 150587559 + 
			Constructor 1 + 78938440 + 
			Constructor 1 + 1711699171 + 
			Constructor 1 + 1975322645 + 
			Constructor 2 string 'Constant Name' + 1319350044 + 
			Constructor 2 string 'Constant Name2' + 1233405214 + 
			Constructor 2 string '90' + 1575842015 + 
			Constructor 2 int 90 + 249473604 + 
			before GetBean customerServiceCtorWithConstant2
			Brian1 Constructor 2 string 'Constant Name2' + 1233405214 + 			
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
			Default Constructor 1 + 306839491 + 
			Setter Injection 1_1 + 306839491 + 
			Default Constructor 1 + 943088790 + 
			Setter Injection 1_1 + 943088790 + 
			Default Constructor 1 + 2063978670 + 
			Setter Injection 1_1 + 2063978670 + 
			Default Constructor 1 + 986156699 + 
			Setter Injection 1_1 + 986156699 + 
			Default Constructor 2 + 56852547 + 
			Setter 2 string 'Constant Name' + 56852547 + 
			Default Constructor 2 + 2038018161 + 
			Setter 2 string 'Constant Name2' + 2038018161 + 
			Default Constructor 2 + 607062277 + 
			Setter 2 string '90' + 607062277 + 
			Constructor 1 + 869807132 + 
			Constructor 1 + 546386486 + 
			Constructor 1 + 1803364571 + 
			Constructor 2 string 'Constant Name' + 1515184734 + 
			Constructor 2 string 'Constant Name2' + 1156745710 + 
			Constructor 2 string '90' + 295271306 + 
			Constructor 2 int 90 + 1059534096 + 
			before GetBean customerServiceCtorWithConstantString
			Brian1 Constructor 2 string '90' + 295271306 + 			
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
			Default Constructor 1 + 1782998558 + 
			Setter Injection 1_1 + 1782998558 + 
			Default Constructor 1 + 869954068 + 
			Setter Injection 1_1 + 869954068 + 
			Default Constructor 1 + 1249352100 + 
			Setter Injection 1_1 + 1249352100 + 
			Default Constructor 1 + 1913127981 + 
			Setter Injection 1_1 + 1913127981 + 
			Default Constructor 2 + 1816813783 + 
			Setter 2 string 'Constant Name' + 1816813783 + 
			Default Constructor 2 + 119274188 + 
			Setter 2 string 'Constant Name2' + 119274188 + 
			Default Constructor 2 + 1039035065 + 
			Setter 2 string '90' + 1039035065 + 
			Constructor 1 + 131559770 + 
			Constructor 1 + 331622323 + 
			Constructor 1 + 1860405125 + 
			Constructor 2 string 'Constant Name' + 1908932714 + 
			Constructor 2 string 'Constant Name2' + 1962137244 + 
			Constructor 2 string '90' + 234264885 + 
			Constructor 2 int 90 + 1744858817 + 
			before GetBean customerServiceCtorWithConstantInt
			Brian1 Constructor 2 int 90 + 1744858817 + 			
			*/		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	@Test
	public void testWithConstant() {
		try {
			ApplicationContext appContext = new GenericXmlApplicationContext("classpath:com/spring/injection/_02_xml/applicationContext.xml");
			System.out.println("before GetBean customerServiceCtorWithConstant");			
			ICustomerService service = appContext.getBean("customerServiceCtorWithConstant", ICustomerService.class);
			System.out.println(service.findAll().get(0).getFirstname() + " " +  service.getDescription());
			/*
			Default Constructor 1 + 337291476 + 
			Setter Injection 1_1 + 337291476 + 
			Default Constructor 1 + 1648492699 + 
			Setter Injection 1_1 + 1648492699 + 
			Default Constructor 1 + 1530262146 + 
			Setter Injection 1_1 + 1530262146 + 
			Default Constructor 1 + 851731350 + 
			Setter Injection 1_1 + 851731350 + 
			Default Constructor 2 + 2070292195 + 
			Setter 2 string 'Constant Name' + 2070292195 + 
			Default Constructor 2 + 1870872671 + 
			Setter 2 string 'Constant Name2' + 1870872671 + 
			Default Constructor 2 + 301422123 + 
			Setter 2 string '90' + 301422123 + 
			Constructor 1 + 786249459 + 
			Constructor 1 + 1644158733 + 
			Constructor 1 + 204205576 + 
			Constructor 2 string 'Constant Name' + 102010508 + 
			Constructor 2 string 'Constant Name2' + 1266329800 + 
			Constructor 2 string '90' + 2043927860 + 
			Constructor 2 int 90 + 1779394537 + 
			before GetBean customerServiceCtorWithConstant
			Brian1 Constructor 2 string 'Constant Name' + 102010508 + 			
			*/			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
