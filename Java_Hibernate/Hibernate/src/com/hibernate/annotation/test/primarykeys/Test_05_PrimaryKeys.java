package com.hibernate.annotation.test.primarykeys;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import com.hibernate.annotation.HibernateUtils;
import com.hibernate.annotation.dto.primarykeys.UserDetails05PrimaryKeys;

public class Test_05_PrimaryKeys {

	public static void main(String[] args) {
		new Test_05_PrimaryKeys().test();
	}
	
	@Test
	public void test() {
		UserDetails05PrimaryKeys user = new UserDetails05PrimaryKeys();
		user.setUserName("Fifth User");
		
		UserDetails05PrimaryKeys user2 = new UserDetails05PrimaryKeys();
		user2.setUserName("Sixth User");
		
		SessionFactory  sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(user2);
		session.getTransaction().commit();
		session.close();
	}
}
