package com.hibernate.annotation.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hibernate.annotation.HibernateUtils;
import com.hibernate.annotation.dto.UserDetails01;

public class Test_01 {

	private static Logger logger = LoggerFactory.getLogger(Test_01.class);

	public static void main(String[] args) {
		new Test_01().test();
	}
	
	@Test
	public void test() {
		UserDetails01 user1 = new UserDetails01();
		user1.setUserId(1);
		user1.setUserName("First User");
		
		UserDetails01 user2 = new UserDetails01();
		user2.setUserId(2);
		user2.setUserName("Second User");		
		
		UserDetails01 user = new UserDetails01();
		user.setUserId(3);
		user.setUserName("Third User");
		
		
		
		SessionFactory  sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		logger.debug("Hello World");
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
    }
}
