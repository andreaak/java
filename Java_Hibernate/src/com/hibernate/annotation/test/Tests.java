package com.hibernate.annotation.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hibernate.annotation.HibernateUtils;
import com.hibernate.annotation.dto.UserDetails01;
import com.hibernate.annotation.dto.UserDetailsAnnotation;


@RunWith(JUnit4.class)
public class Tests {

	private static Logger logger = LoggerFactory.getLogger(Tests.class);

	@Test
	public void testSave() {
		
		try
		{
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
			logger.info("Hello World");
			session.beginTransaction();
			Integer id = (Integer)session.save(user);
			System.out.println("id = " + id);;
			session.getTransaction().commit();
			session.close();		
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		/*
		id = 3 
		Hibernate: insert into UserDetails01 (userName, userId) values (?, ?)
		*/
    }
	
	@Test
	public void testSaveAnnotation() {
		try
		{
			UserDetailsAnnotation user = new UserDetailsAnnotation();
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
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		/*
		Hibernate: insert into USER_DETAILS_ANNOTATED (Address, Description, joinedDate, USER_NAME, userId) values (?, ?, ?, ?, ?)
		*/
	}
	
	@Test
	public void testRetrieve() {
		UserDetailsAnnotation user = new UserDetailsAnnotation();
		user.setUserId(6);
		user.setUserName("Fifth User");
		user.setAddress("Fifth User's address");
		//user.setJoinedDate(new Date());
		user.setDescription("Fifth User's description");	
		user.setSureName("First User's SureName");
		
		SessionFactory  sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
		//Retrieve
		sessionFactory = HibernateUtils.getSessionFactory();
		session = sessionFactory.openSession();
		user = (UserDetailsAnnotation)session.get(UserDetailsAnnotation.class, 6);
		System.out.println("User Name " + user.getUserName());
		System.out.println("User Adress " + user.getAddress());
		System.out.println("User SureName " + user.getSureName());
		session.beginTransaction();
		user.setUserName("User Name Updated");
		session.getTransaction().commit();
		session.close();
		
		sessionFactory = HibernateUtils.getSessionFactory();
		session = sessionFactory.openSession();
		user = (UserDetailsAnnotation)session.get(UserDetailsAnnotation.class, 6);
		System.out.println("User Name " + user.getUserName());
		System.out.println("User Adress " + user.getAddress());
		System.out.println("User SureName " + user.getSureName());
		session.close();
	}
	
	@Test
	public void testDelete() {
		UserDetailsAnnotation user = new UserDetailsAnnotation();
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
		//Delete
		sessionFactory = HibernateUtils.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		user = (UserDetailsAnnotation)session.get(UserDetailsAnnotation.class, 6);
		System.out.println("User Name " + user.getUserName());
		System.out.println("User Adress " + user.getAddress());
		System.out.println("User SureName " + user.getSureName());
		session.delete(user);
		session.getTransaction().commit();
		session.close();
		
		sessionFactory = HibernateUtils.getSessionFactory();
		session = sessionFactory.openSession();
		user = (UserDetailsAnnotation)session.get(UserDetailsAnnotation.class, 6);
		System.out.println("User: " + user);
		session.close();
	}
	
	@Test
	public void testUpdate() {
		UserDetailsAnnotation user = new UserDetailsAnnotation();
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
		
		//Update
		sessionFactory = HibernateUtils.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		user = (UserDetailsAnnotation)session.get(UserDetailsAnnotation.class, 6);
		System.out.println("User Name " + user.getUserName());
		System.out.println("User Adress " + user.getAddress());
		System.out.println("User SureName " + user.getSureName());
		user.setAddress("Updated Fifth User's address");
		user.setUserName("Updated Fifth User Name");
		session.update(user);
		session.getTransaction().commit();
		session.close();
		
		sessionFactory = HibernateUtils.getSessionFactory();
		session = sessionFactory.openSession();
		user = (UserDetailsAnnotation)session.get(UserDetailsAnnotation.class, 6);
		System.out.println("User Name " + user.getUserName());
		System.out.println("User Adress " + user.getAddress());
		System.out.println("User SureName " + user.getSureName());
		session.close();
	}
	
	@Test
	public void testUpdateAfterSave() {
		UserDetailsAnnotation user = new UserDetailsAnnotation();
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
		
		user.setUserName("Fifth User Updated2");
		
		session.getTransaction().commit();// if don't do that - object doesn't save
		session.close();

		
		sessionFactory = HibernateUtils.getSessionFactory();
		session = sessionFactory.openSession();
		user = (UserDetailsAnnotation)session.get(UserDetailsAnnotation.class, 6);
		System.out.println("User Name: " + user.getUserName());
		System.out.println("User Adress: " + user.getAddress());
		System.out.println("User SureName: " + user.getSureName());
		session.close();
	}
}
