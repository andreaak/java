package com.hibernate.annotation.test.inheritance;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import com.hibernate.annotation.HibernateUtils;
import com.hibernate.annotation.dto.inheritance.FourWheeler20Discriminator;
import com.hibernate.annotation.dto.inheritance.TwoWheeler20Discriminator;
import com.hibernate.annotation.dto.inheritance.Vehicle20Discriminator;

public class Test_20Discriminator {

	//TEST ANNOTATION
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Test_20Discriminator().test();
	}
	
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
