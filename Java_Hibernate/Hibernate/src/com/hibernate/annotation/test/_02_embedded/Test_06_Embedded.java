package com.hibernate.annotation.test._02_embedded;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import com.hibernate.annotation.HibernateUtils;
import com.hibernate.annotation.dto._02_embedded.Address;
import com.hibernate.annotation.dto._02_embedded.Address2;
import com.hibernate.annotation.dto._02_embedded.UserDetailsEmb;

public class Test_06_Embedded {

	@Test
	public void test() {
		UserDetailsEmb user = new UserDetailsEmb();
		user.setUserName("User Name");
		Address address =  new Address();
		address.setStreet("Home Street User");
		address.setCity("Home City User");		
		address.setState("");			
		user.setHomeAddress(address);
		
		Address2 address2 =  new Address2();
		address2.setStreet("Street User");
		address2.setCity("City User");	
		user.setOfficeAddress(address2);
		
		SessionFactory  sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}
}
