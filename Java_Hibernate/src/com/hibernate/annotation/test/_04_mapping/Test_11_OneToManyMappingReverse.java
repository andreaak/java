package com.hibernate.annotation.test._04_mapping;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.hibernate.annotation.HibernateUtils;
import com.hibernate.annotation.dto._04_mapping._02_oneToMany.UserDetails11OneToManyMappingReverse;
import com.hibernate.annotation.dto._04_mapping._02_oneToMany.Vehicle11ReverseMapping;

@RunWith(JUnit4.class)
public class Test_11_OneToManyMappingReverse {

	public static void main(String[] args) {
		new Test_11_OneToManyMappingReverse().test();
	}
	
	@Test
	public void test() {
		UserDetails11OneToManyMappingReverse user = new UserDetails11OneToManyMappingReverse();
		user.setUserName("User Name");
		
		Vehicle11ReverseMapping vehicle =  new Vehicle11ReverseMapping();
		vehicle.setVehicleName("Car");
		
		Vehicle11ReverseMapping vehicle2 =  new Vehicle11ReverseMapping();
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
		session.getTransaction().commit();
		session.close();
		
		session = sessionFactory.openSession();
		user = (UserDetails11OneToManyMappingReverse) session.get(UserDetails11OneToManyMappingReverse.class, 1);
		Collection<Vehicle11ReverseMapping> vehicles = user.getVehicle();
		//session.close(); //Close session for EAGER - cause exception when lazy load 
		System.out.println("User: " + user.getUserName());
		System.out.println("Vehicles:");
		for(Vehicle11ReverseMapping vehicle_ : vehicles) {
			System.out.println(vehicle_.getVehicleName());
		}
		
		vehicle = (Vehicle11ReverseMapping) session.get(Vehicle11ReverseMapping.class, 1);

		System.out.println("Vehicle: " + vehicle.getVehicleName());
		System.out.println("User: " + vehicle.getUser().getUserName());
		session.close(); //Close session for LazyLoad
   }
}
