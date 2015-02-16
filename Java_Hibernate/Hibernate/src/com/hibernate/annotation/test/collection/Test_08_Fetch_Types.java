package com.hibernate.annotation.test.collection;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import com.hibernate.annotation.HibernateUtils;
import com.hibernate.annotation.dto.collection.Address07;
import com.hibernate.annotation.dto.collection.UserDetails08FetchTypes;

public class Test_08_Fetch_Types {

	public static void main(String[] args) {
		new Test_08_Fetch_Types().test();
	}
	
	@Test
	public void test() {
		UserDetails08FetchTypes user = new UserDetails08FetchTypes();
		user.setUserName("User Name08");
		
		Address07 address =  new Address07();
		address.setStreet("Home Street User08");
		address.setCity("Home City User08");		
		address.setState("Pens");			

		
		Address07 address2 =  new Address07();
		address2.setStreet("Street User08");
		address2.setCity("City User08");	
		
		user.getListOfAdresses().add(address);
		user.getListOfAdresses().add(address2);	
		
		
		SessionFactory  sessionFactory = HibernateUtils.getSessionFactory2();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
		session = sessionFactory.openSession();
		user = (UserDetails08FetchTypes) session.get(UserDetails08FetchTypes.class, 1);
		Collection<Address07> addresses = user.getListOfAdresses();
		//session.close(); //Close session for EAGER - cause exception when lazy load 
		for(Address07 address_ : addresses) {
			System.out.println(address_.getCity() + " " + address_.getStreet());
		}
		
		session.close(); //Close session for LazyLoad
    }
}
