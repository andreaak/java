package com.database._02_hibernate.annotation.test._07_criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.database._02_hibernate.annotation.HibernateUtils;
import com.database._02_hibernate.annotation.dto._07_criteria.UserDetailsCriteria;

@RunWith(JUnit4.class)
public class Test_40_Criteria {

	@SuppressWarnings("unchecked")
	@Test
	public void test() {

		createUsers() ;
		
		SessionFactory  sessionFactory = HibernateUtils.getSessionFactory();
		Session session = null;

		
		
		{
			session = sessionFactory.openSession();
			int userId = 2;
			Criteria criteria = session.createCriteria(UserDetailsCriteria.class);
			criteria.add(Restrictions.eq("userId", userId));
			List<UserDetailsCriteria> users = (List<UserDetailsCriteria>)criteria.list();
			printUsersData(users);
			session.close();
			System.out.println("------------");
		}
		
		{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(UserDetailsCriteria.class);
			criteria.add(Restrictions.ilike("userName", "Third%"));
			List<UserDetailsCriteria> users = (List<UserDetailsCriteria>)criteria.list();
			printUsersData(users);
			session.close();
			System.out.println("------------");
		}
		
		{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(UserDetailsCriteria.class);
			int userId = 2;
			criteria.add(Restrictions.ilike("userName", "%User%"))
					.add(Restrictions.gt("userId", userId));
			List<UserDetailsCriteria> users = (List<UserDetailsCriteria>)criteria.list();
			printUsersData(users);
			session.close();
			System.out.println("------------");
		}
		
		{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(UserDetailsCriteria.class);
			int userId = 3;
			criteria.add(Restrictions.or(Restrictions.ilike("userName", "First%"), Restrictions.gt("userId", userId)));
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
	


}
