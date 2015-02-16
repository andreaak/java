package com.hibernate.annotation.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import com.hibernate.annotation.HibernateUtils;
import com.hibernate.annotation.dto.UserDetails02Annotation;

public class Test_05_DeleteItem {

	public static void main(String[] args) {
		new Test_05_DeleteItem().test();
	}
	
	@Test
	public void test() {
		UserDetails02Annotation user = new UserDetails02Annotation();
		user.setUserId(6);
		user.setUserName("Fifth User");
		user.setAddress("Fifth User's address");
		user.setJoinedDate(new Date());
		user.setDescription("Fifth User's description");	
		user.setSureName("First User's SureName");
		
		SessionFactory  sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
		sessionFactory = HibernateUtils.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		user = (UserDetails02Annotation)session.get(UserDetails02Annotation.class, 6);
		System.out.println("User Name " + user.getUserName());
		System.out.println("User Adress " + user.getAddress());
		System.out.println("User SureName " + user.getSureName());
		session.delete(user);
		session.getTransaction().commit();
		session.close();
		
		sessionFactory = HibernateUtils.getSessionFactory();
		session = sessionFactory.openSession();
		user = (UserDetails02Annotation)session.get(UserDetails02Annotation.class, 6);
		System.out.println("User: " + user);
		session.close();
	}
}
