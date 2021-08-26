package com.entlogics.iplapp.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.entlogics.iplapp.models.Award;

@Repository
@Component
public class AwardRepository implements IAwardRepository {

	SessionFactory factory;

	public AwardRepository() {
		super();
	}

	// Injecting SessionFactory by setter injection
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	// Adding a new award in database
	@Override
	public void addAward(Award award) {

		System.out.println("Inside AwardRepository addAwards()");

		Session session = factory.openSession();

		session.beginTransaction();

		// getting list of awards
		List<Award> awards = session.createQuery("from Award a").getResultList();

		// set award id greater than the last entry of award
		award.setAwardId(awards.size() + 1);

		session.save(award);

		session.getTransaction().commit();
	}

}
