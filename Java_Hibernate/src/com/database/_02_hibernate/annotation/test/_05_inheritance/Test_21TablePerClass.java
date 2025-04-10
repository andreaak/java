package com.database._02_hibernate.annotation.test._05_inheritance;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.database._02_hibernate.annotation.HibernateUtils;
import com.database._02_hibernate.annotation.dto._05_inheritance._02_tablePerClass.FourWheeler21TablePerClass;
import com.database._02_hibernate.annotation.dto._05_inheritance._02_tablePerClass.TwoWheeler21TablePerClass;
import com.database._02_hibernate.annotation.dto._05_inheritance._02_tablePerClass.Vehicle21TablePerClass;

@RunWith(JUnit4.class)
public class Test_21TablePerClass {

	@Test
	public void test() {

		
		Vehicle21TablePerClass vehicle =  new Vehicle21TablePerClass();
		vehicle.setVehicleName("Car");
		
		TwoWheeler21TablePerClass bike = new TwoWheeler21TablePerClass();
		bike.setVehicleName("Bike");
		bike.setSteeringHandle("Bike Steering Handle");

		FourWheeler21TablePerClass car = new FourWheeler21TablePerClass("Porsche", "Porsche Steering Wheel");
		//car.setVehicleName("Porsche");
		//car.steeringWheel = "Porsche Steering Wheel";
		
		SessionFactory  sessionFactory = HibernateUtils.getSessionFactory2();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(vehicle);
		session.save(bike);
		session.save(car);
		session.getTransaction().commit();
		session.close();
		
		session = sessionFactory.openSession();
		vehicle = (Vehicle21TablePerClass) session.get(Vehicle21TablePerClass.class, 3);
		
		//session.close(); //Close session for EAGER - cause exception when lazy load 
		System.out.println(vehicle.getVehicleName());
		session.close(); //Close session for LazyLoad
	}
}
