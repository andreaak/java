package com.database._02_hibernate.xml.test;

import org.hibernate.Session;
import org.junit.Test;

import com.database._02_hibernate.xml.HibernateUtils;
import com.database._02_hibernate.xml.dto.User;

public class Tests {

	@Test
	public void testSaveAndLoad() {
		
		try{
			Session session = HibernateUtils.getSessionFactory().openSession();
			session.beginTransaction();
			
			User user = new User();
			user.setName("Joe");
			user.setGoal(250);
			Integer id = (Integer)session.save(user);
			
			System.out.println("id = " + id);
			
			session.getTransaction().commit();
			
			session.beginTransaction();
			
			User loadedUser = (User) session.load(User.class, id);
			System.out.println(loadedUser.getName());
			System.out.println(loadedUser.getGoal());
			
			loadedUser.setTotal(loadedUser.getTotal() + 50);
			
			session.getTransaction().commit();
			
			session.close();
			HibernateUtils.getSessionFactory().close();
			/*
			Hibernate: drop table if exists test_schema.USERS_BASE
			Hibernate: create table test_schema.USERS_BASE (ID integer not null auto_increment, NAME varchar(255), TOTAL integer, GOAL integer, primary key (ID))

			Hibernate: insert into test_schema.USERS_BASE (NAME, TOTAL, GOAL) values (?, ?, ?)
			Joe
			250
			Hibernate: update test_schema.USERS_BASE set NAME=?, TOTAL=?, GOAL=? where ID=?
			*/
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
