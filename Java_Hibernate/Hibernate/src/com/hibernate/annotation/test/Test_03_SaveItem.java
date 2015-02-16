package com.hibernate.annotation.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import com.hibernate.annotation.HibernateUtils;
import com.hibernate.annotation.dto.UserDetails02Annotation;

@RunWith(JUnit4.class)
public class Test_03_SaveItem {

	@Test
	public void test() {
		UserDetails02Annotation user = new UserDetails02Annotation();
		user.setUserId(4);
		user.setUserName("First User");
		user.setAddress("First User's address");
		user.setJoinedDate(new Date());
		user.setDescription("First User's description");	
		user.setSureName("First User's SureName");
		
		SessionFactory  sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();    // if don't do that - object doesn't save
		session.close();
	}
}
