package com.gourav.repo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.gourav.entity.Profile;

@Repository
public class ProfileRepository {

	public void save(Profile profile) {
		
		//DataBaseUtils.save(profile);
		
		SessionFactory sessionFactory =  new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(profile);
		session.getTransaction().commit();
		session.close();
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		Profile profileR = new Profile();
		profileR = session.get(Profile.class, "test14@gmail.com");
		System.out.println("***********************"+profileR.getName());
		
	}
}
