package com.hibernate.annotation;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtils {
	
	private static SessionFactory sessionFactory;
	public static SessionFactory getSessionFactory(){
		if(sessionFactory == null) {
			Configuration configuration = new Configuration().configure("com/hibernate/annotation/config/hibernate.cfg.xml");
	
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}
		return sessionFactory;	
	}	
	
	
	public static SessionFactory getSessionFactory2(){
		if(sessionFactory == null) {
			Configuration configuration = new Configuration().configure("com/hibernate/annotation/config/hibernate2.cfg.xml");
			
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}
		return sessionFactory;	
	}
}
