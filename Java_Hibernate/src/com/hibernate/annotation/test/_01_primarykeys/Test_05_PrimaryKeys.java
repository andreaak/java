package com.hibernate.annotation.test._01_primarykeys;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import com.hibernate.annotation.HibernateUtils;
import com.hibernate.annotation.dto._01_primarykeys.UserDetailsPK;

public class Test_05_PrimaryKeys {

	@Test
	public void test() {
		UserDetailsPK user = new UserDetailsPK();
		user.setUserName("Fifth User");
		
		UserDetailsPK user2 = new UserDetailsPK();
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
