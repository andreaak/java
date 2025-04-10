package com.database._02_hibernate.annotation.test._02_embedded;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import com.database._02_hibernate.annotation.HibernateUtils;
import com.database._02_hibernate.annotation.dto._02_embedded.Address;
import com.database._02_hibernate.annotation.dto._02_embedded.Address2;
import com.database._02_hibernate.annotation.dto._02_embedded.UserDetailsEmbedded;

public class Test_Embedded {

	@Test
	public void test() {
		UserDetailsEmbedded user = new UserDetailsEmbedded();
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
		/*
		Hibernate: insert into USER_DETAILS_EMBEDDED (USER_NAME, HOME_CITY_NAME, HOME_PIN_CODE, HOME_STATE_NAME, HOME_STREET_NAME, CITY_NAME, PIN_CODE, STATE_NAME, STREET_NAME) values (?, ?, ?, ?, ?, ?, ?, ?, ?)
		Hibernate: select last_insert_rowid()
		*/
	}
}
