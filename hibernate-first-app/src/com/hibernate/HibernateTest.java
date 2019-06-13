package com.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.hibernate.model.Person;

public class HibernateTest {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		// select * from person
		Criteria criteria = session.createCriteria(Person.class);
		criteria.add(Restrictions.like("name", "%al")).
				add(Restrictions.eq("mobile", "526262"));
		
		List<Person> persons = (List<Person>) criteria.list();

		persons.forEach(p->System.out.println(p));
		// Person p = (Person) session.get(Person.class, 1);
		// System.out.println(p);

		session.close();

		sessionFactory.close();
	}

}
