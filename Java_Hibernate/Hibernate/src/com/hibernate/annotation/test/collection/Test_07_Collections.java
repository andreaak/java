package com.hibernate.annotation.test.collection;

import java.util.Collection;
import java.util.Map.Entry;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import com.hibernate.annotation.HibernateUtils;
import com.hibernate.annotation.dto.collection.Address07;
import com.hibernate.annotation.dto.collection.UserDetails07Collection;

public class Test_07_Collections {

	public static void main(String[] args) {
		new Test_07_Collections().test();
	}
	
	@Test
	public void test() {
		UserDetails07Collection user = new UserDetails07Collection();
		user.setUserName("User Name07");
		
		Address07 address =  new Address07();
		address.setStreet("Street User07_1");
		address.setCity("City User07_1");		
		address.setState("Pensilvania");			

		
		Address07 address2 =  new Address07();
		address2.setStreet("Street User07_2");
		address2.setCity("City User07_2");	
		
		user.getListOfAdresses().add(address);
		user.getListOfAdresses().add(address2);	
		
		address =  new Address07();
		address.setStreet("Home Street User07_1");
		address.setCity("Home City User07_1");		
		address.setState("Pensilvania");			

		
		address2 =  new Address07();
		address2.setStreet("Home Street User07_2");
		address2.setCity("Home City User07_2");	
		
		user.getListOfHomeAdresses().add(address);
		user.getListOfHomeAdresses().add(address2);	
		
		address =  new Address07();
		address.setStreet("Work Street User07_1");
		address.setCity("Work City User07_1");		
		address.setState("Pensilvania");			

		
		address2 =  new Address07();
		address2.setStreet("Work Street User07_2");
		address2.setCity("Work City User07_2");	
		
		user.getListOfWorkAdresses().add(address);
		user.getListOfWorkAdresses().add(address2);	
		
		address =  new Address07();
		address.setStreet("Map Street User07_1");
		address.setCity("Map City User07_1");		
		address.setState("Pensilvania");			

		
		address2 =  new Address07();
		address2.setStreet("Map Street User07_2");
		address2.setCity("Map City User07_2");	
		
		user.getMapOfWorkAdresses().put(10, address);
		user.getMapOfWorkAdresses().put(11, address2);
		
		SessionFactory  sessionFactory = HibernateUtils.getSessionFactory2();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
		session = sessionFactory.openSession();
		user = (UserDetails07Collection) session.get(UserDetails07Collection.class, 1);
		Collection<Address07> addresses = user.getListOfAdresses();
		//session.close(); //Close session for EAGER - cause exception when lazy load 
		System.out.println("Collection:");
		for(Address07 address_ : addresses) {
			System.out.println(address_.getCity() + " , " + address_.getStreet());
		}
		System.out.println("Set:");
		for(Address07 address_ : user.getListOfHomeAdresses()) {
			System.out.println(address_.getCity() + " , " + address_.getStreet());
		}
		System.out.println("List:");
		for(Address07 address_ : user.getListOfWorkAdresses()) {
			System.out.println(address_.getCity() + " , " + address_.getStreet());
		}
		
		System.out.println("Map:");
		for(Entry<Integer, Address07> address_ : user.getMapOfWorkAdresses().entrySet()) {
			System.out.println("Key:" + address_.getKey());
			System.out.println("Value:" + address_.getValue().getStreet());
		}
		
		session.close(); //Close session for LazyLoad
	}
}
