package com.database._02_hibernate.annotation.test._06_queries;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.database._02_hibernate.annotation.HibernateUtils;
import com.database._02_hibernate.annotation.dto._06_queries.UserDetails;

@RunWith(JUnit4.class)
public class Test_31_QueriesWithParams {

	@SuppressWarnings("unchecked")
	@Test
	public void test() {

		createUsers() ;
		
		SessionFactory  sessionFactory = HibernateUtils.getSessionFactory();
		Session session = null;
		{
			session = sessionFactory.openSession();
			int minUserId = 2;
			Query query = session.createQuery("from UserDetails where userId > ? and userName like ?");
			query.setInteger(0, minUserId);
			query.setString(1, "Third%");
			List<UserDetails> users = (List<UserDetails>)query.list();
			printUsersData(users);
			session.close();
			System.out.println("------------");
		}
		
		{
			session = sessionFactory.openSession();
			int minUserId = 2;
			Query query = session.createQuery("from UserDetails where userId > :userId and userName like :userName");
			query.setInteger("userId", minUserId);
			query.setString("userName", "Third%");
			List<UserDetails> users = (List<UserDetails>)query.list();
			printUsersData(users);
			session.close();
			System.out.println("------------");
		}
		
	}
	
	private void createUsers() 
	{
		UserDetails user = new UserDetails();
		user.setUserId(1);
		user.setUserName("First User Name");
		user.setAddress("First User's address");
		//user.setJoinedDate(new Date());
		user.setDescription("First User's description");	
		user.setSureName("First User's SureName");
		
		SessionFactory  sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		
		user = new UserDetails();
		user.setUserId(2);
		user.setUserName("Second User Name");
		user.setAddress("Second User's address");
		//user.setJoinedDate(new Date());
		user.setDescription("Second User's description");	
		user.setSureName("Second User's SureName");
		session.save(user);
		
		user = new UserDetails();
		user.setUserId(3);
		user.setUserName("Third User Name");
		user.setAddress("Third User's address");
		//user.setJoinedDate(new Date());
		user.setDescription("Third User's description");	
		user.setSureName("Third User's SureName");
		session.save(user);
		
		user = new UserDetails();
		user.setUserId(4);
		user.setUserName("Fourth User Name");
		user.setAddress("Fourth User's address");
		//user.setJoinedDate(new Date());
		user.setDescription("Fourth User's description");	
		user.setSureName("Fourth User's SureName");
		session.save(user);
		
		session.getTransaction().commit();
		session.close();
	}
	
	private void printUsersData(List<UserDetails> users) 
	{
		for(UserDetails user : users)
		{
			printUserData(user) ;
		}
	}
	
	private void printUserData(UserDetails user) 
	{
		System.out.println("===================");
		System.out.println(user.getUserName());
		System.out.println(user.getDescription());
		System.out.println(user.getAddress());
	}

}
