package com.hibernate.annotation.test.inheritance;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import com.hibernate.annotation.HibernateUtils;
import com.hibernate.annotation.dto.inheritance.FourWheeler21TablePerClass;
import com.hibernate.annotation.dto.inheritance.TwoWheeler21TablePerClass;
import com.hibernate.annotation.dto.inheritance.Vehicle21TablePerClass;

public class Test_21TablePerClass {

	//TEST ANNOTATION
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Test_21TablePerClass().test();
	}
	
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
