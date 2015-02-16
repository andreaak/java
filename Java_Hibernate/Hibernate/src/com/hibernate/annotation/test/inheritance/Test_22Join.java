package com.hibernate.annotation.test.inheritance;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import com.hibernate.annotation.HibernateUtils;
import com.hibernate.annotation.dto.inheritance.FourWheeler22Join;
import com.hibernate.annotation.dto.inheritance.TwoWheeler22Join;
import com.hibernate.annotation.dto.inheritance.Vehicle22Join;


public class Test_22Join {

	//TEST ANNOTATION
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Test_22Join().test();
	}
	
	@Test
	public void test() {

		
		Vehicle22Join vehicle =  new Vehicle22Join();
		vehicle.setVehicleName("Car");
		
		TwoWheeler22Join bike = new TwoWheeler22Join();
		bike.setVehicleName("Bike");
		bike.setSteeringHandle("Bike Steering Handle");

		FourWheeler22Join car = new FourWheeler22Join("Porsche", "Porsche Steering Wheel");
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
		vehicle = (Vehicle22Join) session.get(Vehicle22Join.class, 3);
		
		//session.close(); //Close session for EAGER - cause exception when lazy load 
		System.out.println(vehicle.getVehicleName());
		session.close(); //Close session for LazyLoad
	}
}
