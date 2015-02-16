package com.hibernate.annotation.test._04_mapping;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.hibernate.annotation.HibernateUtils;
import com.hibernate.annotation.dto._04_mapping._03_mappedBy.UserDetails12MappedBy;
import com.hibernate.annotation.dto._04_mapping._03_mappedBy.Vehicle12MappedBy;

@RunWith(JUnit4.class)
public class Test_12_MappedBy {

	public static void main(String[] args) {
		new Test_12_MappedBy().test();
	}
	
	@Test
	public void test() {
		UserDetails12MappedBy user = new UserDetails12MappedBy();
		user.setUserName("User Name");
		
		Vehicle12MappedBy vehicle =  new Vehicle12MappedBy();
		vehicle.setVehicleName("Car");
		
		Vehicle12MappedBy vehicle2 =  new Vehicle12MappedBy();
		vehicle2.setVehicleName("Jeep");		
		
		user.getVehicle().add(vehicle);
		user.getVehicle().add(vehicle2);	
		vehicle.setUser(user);
		vehicle2.setUser(user);
		
		SessionFactory  sessionFactory = HibernateUtils.getSessionFactory2();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(user);
		session.save(vehicle);
		session.save(vehicle2);
		//or
		//session.persist(user);
		
		session.getTransaction().commit();
		session.close();
		
		session = sessionFactory.openSession();
		user = (UserDetails12MappedBy) session.get(UserDetails12MappedBy.class, 1);
		Collection<Vehicle12MappedBy> vehicles = user.getVehicle();
		//session.close(); //Close session for EAGER - cause exception when lazy load 
		for(Vehicle12MappedBy vehicle_ : vehicles) {
			System.out.println(vehicle_.getVehicleName());
		}
		
		vehicle = (Vehicle12MappedBy) session.get(Vehicle12MappedBy.class, 1);
		System.out.println(vehicle.getVehicleName() + " - User: " + vehicle.getUser().getUserName());
		session.close(); //Close session for LazyLoad
	}
}
