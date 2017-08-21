package com.hibernate.startup;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		Student student1 = new Student();
		student1.setStudentName("John");

		Address addr1 = new Address();
		addr1.setCity("NewYork");
		addr1.setState("NY");
		addr1.setStreet("Lexington Ave");
		addr1.setZipCode("10023");
		student1.setAddress(addr1);

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(student1);
		//session.save(student2);
		session.getTransaction().commit();
		session.close();
	}
}
