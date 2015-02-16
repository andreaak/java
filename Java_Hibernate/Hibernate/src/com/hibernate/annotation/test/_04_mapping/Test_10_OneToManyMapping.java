package com.hibernate.annotation.test._04_mapping;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.hibernate.annotation.HibernateUtils;
import com.hibernate.annotation.dto._04_mapping._02_oneToMany.UserDetails10OneToManyMapping;
import com.hibernate.annotation.dto._04_mapping._02_oneToMany.Vehicle10;

@RunWith(JUnit4.class)
public class Test_10_OneToManyMapping {

	@Test
	public void test() {
		UserDetails10OneToManyMapping user = new UserDetails10OneToManyMapping();
		user.setUserName("User Name");
		
		Vehicle10 vehicle =  new Vehicle10();
		vehicle.setVehicleName("Car");
		
		Vehicle10 vehicle2 =  new Vehicle10();
		vehicle2.setVehicleName("Jeep");		
		
		user.getVehicle().add(vehicle);
		user.getVehicle().add(vehicle2);		
		
		SessionFactory  sessionFactory = HibernateUtils.getSessionFactory2();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(vehicle);
		session.save(vehicle2);		
		session.getTransaction().commit();
		session.close();
		
		session = sessionFactory.openSession();
		user = (UserDetails10OneToManyMapping) session.get(UserDetails10OneToManyMapping.class, 1);
		Collection<Vehicle10> vehicles = user.getVehicle();
		//session.close(); //Close session for EAGER - cause exception when lazy load 
		for(Vehicle10 vehicle_ : vehicles) {
			System.out.println(vehicle_.getVehicleName());
		}
		session.close(); //Close session for LazyLoad
	}
}
