package com.database._02_hibernate.annotation.test._07_criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.database._02_hibernate.annotation.HibernateUtils;
import com.database._02_hibernate.annotation.dto._07_criteria.UserDetailsCriteria;

@RunWith(JUnit4.class)
public class Test_41_Projections {

	@SuppressWarnings("unchecked")
	@Test
	public void test() {

		createUsers() ;
		
		SessionFactory  sessionFactory = HibernateUtils.getSessionFactory();
		Session session = null;
		{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(UserDetailsCriteria.class)
					.setProjection(Projections.property("userId"));
			List<Integer> users = (List<Integer>)criteria.list();
			printUsersData_(users);
			session.close();
			System.out.println("------------");
		}
		
		{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(UserDetailsCriteria.class)
					.setProjection(Projections.max("userId"));
			List<Integer> users = (List<Integer>)criteria.list();
			printUsersData_(users);
			session.close();
			System.out.println("------------");
		}
		
		{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(UserDetailsCriteria.class);
			criteria.addOrder(Order.desc("userId"));
			List<UserDetailsCriteria> users = (List<UserDetailsCriteria>)criteria.list();
			printUsersData(users);
			session.close();
			System.out.println("------------");
		}
		
		{
			session = sessionFactory.openSession();
			UserDetailsCriteria user = new UserDetailsCriteria();
			//user.setUserId(2); //ignore primary key and null values
			user.setUserName("Second Usr Name");
			Example example = Example.create(user);
			Criteria criteria = session.createCriteria(UserDetailsCriteria.class)
					.add(example);
			List<UserDetailsCriteria> users = (List<UserDetailsCriteria>)criteria.list();
			printUsersData(users);
			session.close();
			System.out.println("------------");
		}
		{
			session = sessionFactory.openSession();
			UserDetailsCriteria user = new UserDetailsCriteria();
			//user.setUserId(2); //ignore primary key and null values
			user.setUserName("Second Usr Name");
			Example example = Example.create(user).excludeProperty("userName");
			Criteria criteria = session.createCriteria(UserDetailsCriteria.class)
					.add(example);
			List<UserDetailsCriteria> users = (List<UserDetailsCriteria>)criteria.list();
			printUsersData(users);
			session.close();
			System.out.println("------------");
		}
		
	}
	
	private void createUsers() 
	{
		UserDetailsCriteria user = new UserDetailsCriteria();
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
		
		user = new UserDetailsCriteria();
		user.setUserId(2);
		user.setUserName("Second Usr Name");
		user.setAddress("Second User's address");
		//user.setJoinedDate(new Date());
		user.setDescription("Second User's description");	
		user.setSureName("Second User's SureName");
		session.save(user);
		
		user = new UserDetailsCriteria();
		user.setUserId(3);
		user.setUserName("Third User Name");
		user.setAddress("Third User's address");
		//user.setJoinedDate(new Date());
		user.setDescription("Third User's description");	
		user.setSureName("Third User's SureName");
		session.save(user);
		
		user = new UserDetailsCriteria();
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
	
	private void printUsersData(List<UserDetailsCriteria> users) 
	{
		for(UserDetailsCriteria user : users)
		{
			printUserData(user) ;
		}
	}
	
	private void printUserData(UserDetailsCriteria user) 
	{
		System.out.println("===================");
		System.out.println(user.getUserName());
		System.out.println(user.getDescription());
		System.out.println(user.getAddress());
	}
	
	private void printUsersData_(List<Integer> ids) 
	{
		System.out.println("===================");
		for(Integer id : ids)
		{
			
			System.out.println(id);
		}
	}
}
