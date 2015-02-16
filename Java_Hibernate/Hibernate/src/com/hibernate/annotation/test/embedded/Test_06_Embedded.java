package com.hibernate.annotation.test.embedded;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import com.hibernate.annotation.HibernateUtils;
import com.hibernate.annotation.dto.embedded.Address06Embedded;
import com.hibernate.annotation.dto.embedded.Address06_2Embedded;
import com.hibernate.annotation.dto.embedded.UserDetails06Embedded;

public class Test_06_Embedded {

	public static void main(String[] args) {
		new Test_06_Embedded().test();
	}
	
	@Test
	public void test() {
		UserDetails06Embedded user = new UserDetails06Embedded();
		user.setUserName("User Name");
		Address06Embedded address =  new Address06Embedded();
		address.setStreet("Home Street User");
		address.setCity("Home City User");		
		address.setState("");			
		user.setHomeAddress(address);
		
		Address06_2Embedded address2 =  new Address06_2Embedded();
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
