package com.hibernate.annotation.test.mapping;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import com.hibernate.annotation.HibernateUtils;
import com.hibernate.annotation.dto.mapping.UserDetails14Cascade;
import com.hibernate.annotation.dto.mapping.Vehicle14Cascade;

public class Test_14_Cascade {

	public static void main(String[] args) {
		new Test_14_Cascade().test();
	}
	
	@Test
	public void test() {
		UserDetails14Cascade user = new UserDetails14Cascade();
		user.setUserName("User Name");
		
		Vehicle14Cascade vehicle =  new Vehicle14Cascade();
		vehicle.setVehicleName("Car");
		
		Vehicle14Cascade vehicle2 =  new Vehicle14Cascade();
		vehicle2.setVehicleName("Jeep");		
		
		user.getVehicle().add(vehicle);
		user.getVehicle().add(vehicle2);	
		vehicle.setUser(user);
		vehicle2.setUser(user);
		
		SessionFactory  sessionFactory = HibernateUtils.getSessionFactory2();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		
		session.persist(user);
		
		session.getTransaction().commit();
		session.close();
		
		session = sessionFactory.openSession();
		user = (UserDetails14Cascade) session.get(UserDetails14Cascade.class, 1);
		Collection<Vehicle14Cascade> vehicles = user.getVehicle();
		//session.close(); //Close session for EAGER - cause exception when lazy load 
		for(Vehicle14Cascade vehicle_ : vehicles) {
			System.out.println(vehicle_.getVehicleName());
		}
		
		vehicle = (Vehicle14Cascade) session.get(Vehicle14Cascade.class, 1);
		System.out.println(vehicle.getVehicleName() + " - User: " + vehicle.getUser().getUserName());
		session.close(); //Close session for LazyLoad
	}
}
