package com.hibernate.annotation.test.queries;

import java.util.HashMap;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import com.hibernate.annotation.HibernateUtils;
import com.hibernate.annotation.dto.queries.UserDetails;

public class Test_30_Queries {

	public static void main(String[] args) {
		new Test_30_Queries().test();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void test() {

		createUsers() ;
		
		SessionFactory  sessionFactory = HibernateUtils.getSessionFactory();
		Session session = null;
		{
			session = sessionFactory.openSession();
		
			Query query = session.createQuery("from UserDetails");
			List<UserDetails> users = (List<UserDetails>)query.list();
			printUsersData(users);
			session.close();
			System.out.println("------------");
		}
		{
			session = sessionFactory.openSession();
	
			Query query = session.createQuery("from UserDetails where userName like 'First%'");
			List<UserDetails> users = (List<UserDetails>)query.list();
			printUsersData(users);
			session.close();
			System.out.println("------------");
		}
		{
			session = sessionFactory.openSession();
		
			Query query = session.createQuery("from UserDetails");
			//get Second and Third users
			query.setFirstResult(1); //skip n records 
			query.setMaxResults(2); //get n records
			List<UserDetails> users = (List<UserDetails>)query.list();
			printUsersData(users);
			session.close();
			System.out.println("------------");
		}
		
		{
			session = sessionFactory.openSession();
			//select only userName
			Query query = session.createQuery("select userName from UserDetails");
			List<String> users = (List<String>)query.list();
			printUserNames(users);
			session.close();
			System.out.println("------------");
		}
		
		{
			session = sessionFactory.openSession();
			//select only userName
			Query query = session.createQuery("select new map(userId, userName) from UserDetails");
			@SuppressWarnings("unused")
			List<HashMap<Integer,String>> users = (List<HashMap<Integer,String>>)query.list();
			//printUserNames(users);
			session.close();
			System.out.println("------------");
		}
		
		{
			session = sessionFactory.openSession();
			
			Query query = session.createQuery("select max(userId) from UserDetails");
			Integer id = (Integer)query.uniqueResult();
			System.out.println("Max Id: " + id);
			session.close();
			System.out.println("------------");
		}
	}
	
	private void createUsers() 
	{
		UserDetails user = new UserDetails();
		user.setUserId(4);
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
		user.setUserId(9);
		user.setUserName("Second User Name");
		user.setAddress("Second User's address");
		//user.setJoinedDate(new Date());
		user.setDescription("Second User's description");	
		user.setSureName("Second User's SureName");
		session.save(user);
		
		user = new UserDetails();
		user.setUserId(12);
		user.setUserName("Third User Name");
		user.setAddress("Third User's address");
		//user.setJoinedDate(new Date());
		user.setDescription("Third User's description");	
		user.setSureName("Third User's SureName");
		session.save(user);
		
		user = new UserDetails();
		user.setUserId(13);
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
	
	private void printUserNames(List<String> users) 
	{
		for(String user : users)
		{
			System.out.println(user);
		}
	}
}
