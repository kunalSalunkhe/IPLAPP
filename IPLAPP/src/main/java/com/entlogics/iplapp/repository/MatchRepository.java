package com.entlogics.iplapp.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.entlogics.iplapp.models.Match;

@Repository
@Component
public class MatchRepository implements IMatchRepository {

	SessionFactory factory;

	public MatchRepository() {
		super();

	}

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	// add a match in a season
	@Override
	public void addMatch(Match match) {

		Session session = factory.openSession();

		session.beginTransaction();

		// save match objetct
		session.save(match);

		session.getTransaction().commit();
	}

}
