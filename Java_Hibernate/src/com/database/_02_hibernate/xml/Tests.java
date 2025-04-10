package com.database._02_hibernate.xml;

import org.hibernate.Session;
import org.junit.Test;

public class Tests {

	@Test
	public void testSession() {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.close();
	}
}
