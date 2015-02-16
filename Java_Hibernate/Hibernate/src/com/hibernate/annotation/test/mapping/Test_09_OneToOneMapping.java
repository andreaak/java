package com.hibernate.annotation.test.mapping;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import com.hibernate.annotation.HibernateUtils;
import com.hibernate.annotation.dto.mapping.UserDetails09OneToOneMapping;
import com.hibernate.annotation.dto.mapping.Vehicle09;

public class Test_09_OneToOneMapping {

	//TEST ANNOTATION
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Test_09_OneToOneMapping().test();
	}
	
	@Test
	public void test() {
		UserDetails09OneToOneMapping user = new UserDetails09OneToOneMapping();
		user.setUserName("User Name");
		
		Vehicle09 vehicle =  new Vehicle09();
		vehicle.setVehicleName("Car");
		
		user.setVehicle(vehicle);
		
		SessionFactory  sessionFactory = HibernateUtils.getSessionFactory2();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(vehicle);
		session.getTransaction().commit();
		session.close();
		
		session = sessionFactory.openSession();
		user = (UserDetails09OneToOneMapping) session.get(UserDetails09OneToOneMapping.class, 1);
		Vehicle09 vehicle09 = user.getVehicle();
		//session.close(); //Close session for EAGER - cause exception when lazy load 
		System.out.println(vehicle09.getVehicleName());
		session.close(); //Close session for LazyLoad
	}
}
