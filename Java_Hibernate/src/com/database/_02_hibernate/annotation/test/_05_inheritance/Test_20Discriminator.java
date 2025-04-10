package com.database._02_hibernate.annotation.test._05_inheritance;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.database._02_hibernate.annotation.HibernateUtils;
import com.database._02_hibernate.annotation.dto._05_inheritance._01_discriminator.FourWheeler20Discriminator;
import com.database._02_hibernate.annotation.dto._05_inheritance._01_discriminator.TwoWheeler20Discriminator;
import com.database._02_hibernate.annotation.dto._05_inheritance._01_discriminator.Vehicle20Discriminator;

@RunWith(JUnit4.class)
public class Test_20Discriminator {


	@Test
	public void test() {

		
		Vehicle20Discriminator vehicle =  new Vehicle20Discriminator();
		vehicle.setVehicleName("Car");
		
		TwoWheeler20Discriminator bike = new TwoWheeler20Discriminator();
		bike.setVehicleName("Bike");
		bike.setSteeringHandle("Bike Steering Handle");

		FourWheeler20Discriminator car = new FourWheeler20Discriminator();
		car.setVehicleName("Porsche");
		car.setSteeringWheel("Porsche Steering Wheel");
		
		SessionFactory  sessionFactory = HibernateUtils.getSessionFactory2();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(vehicle);
		session.save(bike);
		session.save(car);
		session.getTransaction().commit();
		session.close();
		
		session = sessionFactory.openSession();
		vehicle = (Vehicle20Discriminator) session.get(Vehicle20Discriminator.class, 3);
		
		//session.close(); //Close session for EAGER - cause exception when lazy load 
		System.out.println(vehicle.getVehicleName());
		session.close(); //Close session for LazyLoad
	}
}
