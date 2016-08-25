package com.hibernate.annotation.test._03_collection;

import java.util.Collection;
import java.util.Map.Entry;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import com.hibernate.annotation.HibernateUtils;
import com.hibernate.annotation.dto._03_collection.Address;
import com.hibernate.annotation.dto._03_collection.UserDetailsCollection;

public class Test_Collections {
	
	@Test
	public void testCollection() {
		try	
		{
			UserDetailsCollection user = new UserDetailsCollection();
			user.setUserName("User Name_Collection");
			
			Address address =  new Address();
			address.setStreet("Street User_Collection");
			address.setCity("City User_Collection");		
			address.setState("Pensilvania");			
	
			
			Address address2 =  new Address();
			address2.setStreet("Street User_Collection_2");
			address2.setCity("City User_Collection_2");	
			
			user.getCollectionOfAdresses().add(address);
			user.getCollectionOfAdresses().add(address2);	
			
			SessionFactory  sessionFactory = HibernateUtils.getSessionFactory2();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
			session.close();
			
			session = sessionFactory.openSession();
			user = (UserDetailsCollection) session.get(UserDetailsCollection.class, 1);
			Collection<Address> addresses = user.getCollectionOfAdresses();
			//session.close(); //Close session for EAGER - cause exception when lazy load 
			System.out.println("Collection:");
			for(Address address_ : addresses) {
				System.out.println(address_.getCity() + " , " + address_.getStreet());
			}
						
			session.close(); //Close session for LazyLoad
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		/*
		Hibernate: insert into USER_DETAILS_COLLECTION (USER_NAME) values (?)
		Hibernate: select last_insert_rowid()
		Hibernate: select max(ADDRESS_ID) from USER_ADDRESS_COLLECTION
		Hibernate: insert into USER_ADDRESS_COLLECTION (USER_ID, ADDRESS_ID, CITY_NAME, PIN_CODE, STATE_NAME, STREET_NAME) values (?, ?, ?, ?, ?, ?)
		Hibernate: insert into USER_ADDRESS_COLLECTION (USER_ID, ADDRESS_ID, CITY_NAME, PIN_CODE, STATE_NAME, STREET_NAME) values (?, ?, ?, ?, ?, ?)
		Hibernate: select userdetail0_.USER_ID as USER1_18_0_, userdetail0_.USER_NAME as USER2_18_0_ from USER_DETAILS_COLLECTION userdetail0_ where userdetail0_.USER_ID=?
		Collection:
		Hibernate: select collection0_.USER_ID as USER1_18_0_, collection0_.CITY_NAME as CITY2_7_0_, collection0_.PIN_CODE as PIN3_7_0_, collection0_.STATE_NAME as STATE4_7_0_, collection0_.STREET_NAME as STREET5_7_0_, collection0_.ADDRESS_ID as ADDRESS6_0_ from USER_ADDRESS_COLLECTION collection0_ where collection0_.USER_ID=?
		City User_Collection , Street User_Collection
		City User_Collection_2 , Street User_Collection_2
		*/
	}
	
	@Test
	public void testSet() {
		try	
		{
			UserDetailsCollection user = new UserDetailsCollection();
			user.setUserName("User Name_Set");
			
			Address address =  new Address();
			address.setStreet("Street User_Set");
			address.setCity("City User_Set");		
			address.setState("Pensilvania");			
	
			
			Address address2 =  new Address();
			address2.setStreet("Street User_Set_2");
			address2.setCity("City User_Set_2");	
			
			user.getSetOfAdresses().add(address);
			user.getSetOfAdresses().add(address2);	
			
			SessionFactory  sessionFactory = HibernateUtils.getSessionFactory2();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
			session.close();
			
			session = sessionFactory.openSession();
			user = (UserDetailsCollection) session.get(UserDetailsCollection.class, 1);
			//session.close(); //Close session for EAGER - cause exception when lazy load 
			
			System.out.println("Set:");
			for(Address address_ : user.getSetOfAdresses()) {
				System.out.println(address_.getCity() + " , " + address_.getStreet());
			}
			session.close(); //Close session for LazyLoad
			/*
			Hibernate: insert into USER_DETAILS_COLLECTION (USER_NAME) values (?)
			Hibernate: select last_insert_rowid()
			Hibernate: insert into USER_ADDRESS_SET (USER_ID, CITY_NAME, PIN_CODE, STATE_NAME, STREET_NAME) values (?, ?, ?, ?, ?)
			Hibernate: insert into USER_ADDRESS_SET (USER_ID, CITY_NAME, PIN_CODE, STATE_NAME, STREET_NAME) values (?, ?, ?, ?, ?)
			Hibernate: select userdetail0_.USER_ID as USER1_18_0_, userdetail0_.USER_NAME as USER2_18_0_ from USER_DETAILS_COLLECTION userdetail0_ where userdetail0_.USER_ID=?
			Set:
			Hibernate: select setofadres0_.USER_ID as USER1_18_0_, setofadres0_.CITY_NAME as CITY2_10_0_, setofadres0_.PIN_CODE as PIN3_10_0_, setofadres0_.STATE_NAME as STATE4_10_0_, setofadres0_.STREET_NAME as STREET5_10_0_ from USER_ADDRESS_SET setofadres0_ where setofadres0_.USER_ID=?
			City User_Set , Street User_Set
			City User_Set_2 , Street User_Set_2		
			*/
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	@Test
	public void testList() {
		try	
		{
			UserDetailsCollection user = new UserDetailsCollection();
			user.setUserName("User Name_List");
			
			Address address =  new Address();
			address.setStreet("Street User_List");
			address.setCity("City User_List");		
			address.setState("Pensilvania");			
	
			
			Address address2 =  new Address();
			address2.setStreet("Street User_List_2");
			address2.setCity("City User_List_2");	
			
			user.getListOfAdresses().add(address);
			user.getListOfAdresses().add(address2);	
			
			SessionFactory  sessionFactory = HibernateUtils.getSessionFactory2();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
			session.close();
			
			session = sessionFactory.openSession();
			user = (UserDetailsCollection) session.get(UserDetailsCollection.class, 1);
			//session.close(); //Close session for EAGER - cause exception when lazy load 
			
			System.out.println("List:");
			for(Address address_ : user.getListOfAdresses()) {
				System.out.println(address_.getCity() + " , " + address_.getStreet());
			}
			
			session.close(); //Close session for LazyLoad
			/*
			Hibernate: insert into USER_DETAILS_COLLECTION (USER_NAME) values (?)
			Hibernate: select last_insert_rowid()
			Hibernate: insert into USER_ADDRESS_LIST (USER_ID, POSITION, CITY_NAME, PIN_CODE, STATE_NAME, STREET_NAME) values (?, ?, ?, ?, ?, ?)
			Hibernate: insert into USER_ADDRESS_LIST (USER_ID, POSITION, CITY_NAME, PIN_CODE, STATE_NAME, STREET_NAME) values (?, ?, ?, ?, ?, ?)
			Hibernate: select userdetail0_.USER_ID as USER1_18_0_, userdetail0_.USER_NAME as USER2_18_0_ from USER_DETAILS_COLLECTION userdetail0_ where userdetail0_.USER_ID=?
			List:
			Hibernate: select listofadre0_.USER_ID as USER1_18_0_, listofadre0_.CITY_NAME as CITY2_8_0_, listofadre0_.PIN_CODE as PIN3_8_0_, listofadre0_.STATE_NAME as STATE4_8_0_, listofadre0_.STREET_NAME as STREET5_8_0_, listofadre0_.POSITION as POSITION6_0_ from USER_ADDRESS_LIST listofadre0_ where listofadre0_.USER_ID=?
			City User_List , Street User_List
			City User_List_2 , Street User_List_2
			*/
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	@Test
	public void testMap() {
		try	
		{
			UserDetailsCollection user = new UserDetailsCollection();
			user.setUserName("User Name_Map");
			
			Address address =  new Address();
			address.setStreet("Street User_Map");
			address.setCity("City User_Map");		
			address.setState("Pensilvania");			
	
			
			Address address2 =  new Address();
			address2.setStreet("Street User_Map_2");
			address2.setCity("City User_Map_2");	
			
			user.getMapOfAdresses().put(10, address);
			user.getMapOfAdresses().put(11, address2);
			
			SessionFactory  sessionFactory = HibernateUtils.getSessionFactory2();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
			session.close();
			
			session = sessionFactory.openSession();
			user = (UserDetailsCollection) session.get(UserDetailsCollection.class, 1);

			//session.close(); //Close session for EAGER - cause exception when lazy load 
			System.out.println("Map:");
			for(Entry<Integer, Address> address_ : user.getMapOfAdresses().entrySet()) {
				System.out.println("Key:" + address_.getKey());
				System.out.println("Value:" + address_.getValue().getStreet());
			}
			
			session.close(); //Close session for LazyLoad
			/*
			Hibernate: insert into USER_DETAILS_COLLECTION (USER_NAME) values (?)
			Hibernate: select last_insert_rowid()
			Hibernate: insert into USER_ADDRESS_MAP (USER_ID, KEY_VALUE, CITY_NAME, PIN_CODE, STATE_NAME, STREET_NAME) values (?, ?, ?, ?, ?, ?)
			Hibernate: insert into USER_ADDRESS_MAP (USER_ID, KEY_VALUE, CITY_NAME, PIN_CODE, STATE_NAME, STREET_NAME) values (?, ?, ?, ?, ?, ?)
			Hibernate: select userdetail0_.USER_ID as USER1_18_0_, userdetail0_.USER_NAME as USER2_18_0_ from USER_DETAILS_COLLECTION userdetail0_ where userdetail0_.USER_ID=?
			Map:
			Hibernate: select mapofadres0_.USER_ID as USER1_18_0_, mapofadres0_.CITY_NAME as CITY2_9_0_, mapofadres0_.PIN_CODE as PIN3_9_0_, mapofadres0_.STATE_NAME as STATE4_9_0_, mapofadres0_.STREET_NAME as STREET5_9_0_, mapofadres0_.KEY_VALUE as KEY6_0_ from USER_ADDRESS_MAP mapofadres0_ where mapofadres0_.USER_ID=?
			Key:10
			Value:Street User_Map
			Key:11
			Value:Street User_Map_2
			*/
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
