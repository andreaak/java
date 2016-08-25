package com.hibernate.annotation.test._03_collection;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import com.hibernate.annotation.HibernateUtils;
import com.hibernate.annotation.dto._03_collection.Address;
import com.hibernate.annotation.dto._03_collection.UserDetailsFetchTypesEager;
import com.hibernate.annotation.dto._03_collection.UserDetailsFetchTypesLazy;

public class Test_Fetch_Types {

	@Test
	public void testLazy() {
		try{
			
			UserDetailsFetchTypesLazy user = new UserDetailsFetchTypesLazy();
			user.setUserName("User Name08");
			
			Address address =  new Address();
			address.setStreet("Home Street User08");
			address.setCity("Home City User08");		
			address.setState("Pens");			
	
			
			Address address2 =  new Address();
			address2.setStreet("Street User08");
			address2.setCity("City User08");	
			
			user.getCollectionOfAdresses().add(address);
			user.getCollectionOfAdresses().add(address2);	
			
			
			SessionFactory  sessionFactory = HibernateUtils.getSessionFactory2();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
			session.close();
			
			session = sessionFactory.openSession();
			user = (UserDetailsFetchTypesLazy) session.get(UserDetailsFetchTypesLazy.class, 1);
			Collection<Address> addresses = user.getCollectionOfAdresses();
			System.out.println("Collection:");
			//session.close(); //Close session for EAGER - cause exception when lazy load 
			for(Address address_ : addresses) {
				System.out.println(address_.getCity() + " " + address_.getStreet());
			}
			
			session.close(); //Close session for LazyLoad
			
			/*
			Hibernate: insert into USER_DETAILS_FETCH_TYPES_LAZY (USER_NAME) values (?)
			Hibernate: select last_insert_rowid()
			Hibernate: select max(ADDRESS_ID) from USER_ADDRESS_08_FETCH_TYPES
			Hibernate: insert into USER_ADDRESS_08_FETCH_TYPES (USER_ID, ADDRESS_ID, CITY_NAME, PIN_CODE, STATE_NAME, STREET_NAME) values (?, ?, ?, ?, ?, ?)
			Hibernate: insert into USER_ADDRESS_08_FETCH_TYPES (USER_ID, ADDRESS_ID, CITY_NAME, PIN_CODE, STATE_NAME, STREET_NAME) values (?, ?, ?, ?, ?, ?)
			Hibernate: select userdetail0_.USER_ID as USER1_19_0_, userdetail0_.USER_NAME as USER2_19_0_ from USER_DETAILS_FETCH_TYPES_LAZY userdetail0_ where userdetail0_.USER_ID=?
			Collection:
			Hibernate: select collection0_.USER_ID as USER1_19_0_, collection0_.CITY_NAME as CITY2_6_0_, collection0_.PIN_CODE as PIN3_6_0_, collection0_.STATE_NAME as STATE4_6_0_, collection0_.STREET_NAME as STREET5_6_0_, collection0_.ADDRESS_ID as ADDRESS6_0_ from USER_ADDRESS_08_FETCH_TYPES collection0_ where collection0_.USER_ID=?
			Home City User08 Home Street User08
			City User08 Street User08
			*/
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
    }
	
	@Test
	public void testEager() {
		try{
			
			UserDetailsFetchTypesEager user = new UserDetailsFetchTypesEager();
			user.setUserName("User Name08");
			
			Address address =  new Address();
			address.setStreet("Home Street User08");
			address.setCity("Home City User08");		
			address.setState("Pens");			
	
			
			Address address2 =  new Address();
			address2.setStreet("Street User08");
			address2.setCity("City User08");	
			
			user.getCollectionOfAdresses().add(address);
			user.getCollectionOfAdresses().add(address2);	
			
			
			SessionFactory  sessionFactory = HibernateUtils.getSessionFactory2();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
			session.close();
			
			session = sessionFactory.openSession();
			user = (UserDetailsFetchTypesEager) session.get(UserDetailsFetchTypesEager.class, 1);
			Collection<Address> addresses = user.getCollectionOfAdresses();
			System.out.println("Collection:");
			session.close(); //Close session for EAGER - cause exception when lazy load 
			for(Address address_ : addresses) {
				System.out.println(address_.getCity() + " " + address_.getStreet());
			}
			
			//session.close(); //Close session for LazyLoad
			
			/*
			Hibernate: insert into USER_DETAILS_FETCH_TYPES_EAGER (USER_NAME) values (?)
			Hibernate: select last_insert_rowid()
			Hibernate: select max(ADDRESS_ID) from USER_ADDRESS_08_FETCH_TYPES
			Hibernate: insert into USER_ADDRESS_08_FETCH_TYPES (USER_ID, ADDRESS_ID, CITY_NAME, PIN_CODE, STATE_NAME, STREET_NAME) values (?, ?, ?, ?, ?, ?)
			Hibernate: insert into USER_ADDRESS_08_FETCH_TYPES (USER_ID, ADDRESS_ID, CITY_NAME, PIN_CODE, STATE_NAME, STREET_NAME) values (?, ?, ?, ?, ?, ?)
			Hibernate: select userdetail0_.USER_ID as USER1_18_0_, userdetail0_.USER_NAME as USER2_18_0_, collection1_.USER_ID as USER1_18_2_, collection1_.CITY_NAME as CITY2_6_2_, collection1_.PIN_CODE as PIN3_6_2_, collection1_.STATE_NAME as STATE4_6_2_, collection1_.STREET_NAME as STREET5_6_2_, collection1_.ADDRESS_ID as ADDRESS6_2_ from USER_DETAILS_FETCH_TYPES_EAGER userdetail0_ left outer join USER_ADDRESS_08_FETCH_TYPES collection1_ on userdetail0_.USER_ID=collection1_.USER_ID where userdetail0_.USER_ID=?
			Collection:
			Home City User08 Home Street User08
			City User08 Street User08
			*/
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
    }
}
