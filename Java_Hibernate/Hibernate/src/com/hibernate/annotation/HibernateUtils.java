package com.hibernate.annotation;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	
	private static SessionFactory sessionFactory;
	public static SessionFactory getSessionFactory(){
		if(sessionFactory == null) {
			sessionFactory = new Configuration().configure("com/hibernate/annotation/config/hibernate.cfg.xml").buildSessionFactory();
		}
		return sessionFactory;	
	}	
	
	
	public static SessionFactory getSessionFactory2(){
		if(sessionFactory == null) {
			sessionFactory = new Configuration().configure("com/hibernate/annotation/config/hibernate2.cfg.xml").buildSessionFactory();
		}
		return sessionFactory;	
	}
}
