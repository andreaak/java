package com.hibernate.annotation.test._05_inheritance;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.hibernate.annotation.HibernateUtils;
import com.hibernate.annotation.dto._05_inheritance._04_subclassTable.FourWheeler23SubclassTable;
import com.hibernate.annotation.dto._05_inheritance._04_subclassTable.TwoWheeler23SubclassTable;

@RunWith(JUnit4.class)
public class Test_23SubclassTable {

	@Test
	public void test() {

		TwoWheeler23SubclassTable bike = new TwoWheeler23SubclassTable();
		bike.setVehicleName("Bike");
		bike.setSteeringHandle("Bike Steering Handle");

		FourWheeler23SubclassTable car = new FourWheeler23SubclassTable();
		car.setVehicleName("Porsche");
		car.setSteeringWheel("Porsche Steering Wheel");
		
		FourWheeler23SubclassTable car2 = new FourWheeler23SubclassTable();
		car2.setVehicleName("Toyota");
		car2.setSteeringWheel("Toyota Steering Wheel");
		
		SessionFactory  sessionFactory = HibernateUtils.getSessionFactory2();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(bike);
		session.save(car);
		session.save(car2);
		session.getTransaction().commit();
		session.close();
		
		session = sessionFactory.openSession();
		bike = (TwoWheeler23SubclassTable) session.get(TwoWheeler23SubclassTable.class, 1);
		car = (FourWheeler23SubclassTable) session.get(FourWheeler23SubclassTable.class, 1);
		//session.close(); //Close session for EAGER - cause exception when lazy load 
		System.out.println(bike.getVehicleName());
		System.out.println(car.getVehicleName());		
		session.close(); //Close session for LazyLoad
	}
}
