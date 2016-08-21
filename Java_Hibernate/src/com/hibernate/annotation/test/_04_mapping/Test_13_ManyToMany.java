package com.hibernate.annotation.test._04_mapping;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.hibernate.annotation.HibernateUtils;
import com.hibernate.annotation.dto._04_mapping._04_manyToMany.UserDetails13ManyToMany;
import com.hibernate.annotation.dto._04_mapping._04_manyToMany.Vehicle13ManyToMany;

@RunWith(JUnit4.class)
public class Test_13_ManyToMany {

	public static void main(String[] args) {
		new Test_13_ManyToMany().test();
	}
	
	@Test
	public void test() {
		UserDetails13ManyToMany user = new UserDetails13ManyToMany();
		user.setUserName("User Name 1");
		
		UserDetails13ManyToMany user2 = new UserDetails13ManyToMany();
		user2.setUserName("User Name 2");
		
		Vehicle13ManyToMany vehicle =  new Vehicle13ManyToMany();
		vehicle.setVehicleName("Car");
		vehicle.getUsers().add(user);
		vehicle.getUsers().add(user2);
		
		Vehicle13ManyToMany vehicle2 =  new Vehicle13ManyToMany();
		vehicle2.setVehicleName("Jeep");		
		vehicle2.getUsers().add(user);	
		vehicle2.getUsers().add(user2);	
		
		user.getVehicles().add(vehicle);
		user.getVehicles().add(vehicle2);	

		user2.getVehicles().add(vehicle);
		user2.getVehicles().add(vehicle2);		
		
		SessionFactory  sessionFactory = HibernateUtils.getSessionFactory2();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(user2);
		session.save(vehicle);
		session.save(vehicle2);		
		session.getTransaction().commit();
		session.close();
		
		session = sessionFactory.openSession();
		
		user = (UserDetails13ManyToMany) session.get(UserDetails13ManyToMany.class, 1);
		Collection<Vehicle13ManyToMany> vehicles = user.getVehicles();
		System.out.println("User:" + user.getUserName());
		System.out.println("Vehicles: ");
		for(Vehicle13ManyToMany vehicle_ : vehicles) {
			System.out.println(vehicle_.getVehicleName());
		}
		System.out.println("-------------------------------");
		vehicle = (Vehicle13ManyToMany) session.get(Vehicle13ManyToMany.class, 1);
		//session.close(); //Close session for EAGER - cause exception when lazy load 
		System.out.println("Vehicle: " + vehicle.getVehicleName());
		System.out.println("Users:");
		for(UserDetails13ManyToMany user_ : vehicle.getUsers()) {
			System.out.println(user_.getUserName());
		}
		
		session.close(); //Close session for LazyLoad
    }
}
