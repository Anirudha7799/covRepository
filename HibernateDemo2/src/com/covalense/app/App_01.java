package com.covalense.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.covalense.beans.Employee;

public class App_01 {

	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		org.hibernate.metamodel.Metadata meta = new org.hibernate.metamodel.MetadataSources(ssr).getMetadataBuilder()
				.build();
		SessionFactory sessionFactory = meta.getSessionFactoryBuilder().build();
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();

		Employee emp = new Employee();
		emp.setId(11);
		emp.setFirstName("priyanka");
		emp.setLastName("warrior");
		System.out.println("Hii");

		session.save(emp);
		t.commit();
		session.close();
		sessionFactory.close();

	}

}