package com.entlogics.iplapp.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.entlogics.iplapp.models.Award;
import com.entlogics.iplapp.models.Match;
import com.entlogics.iplapp.models.Player;
import com.entlogics.iplapp.models.PlayerMatch;
import com.entlogics.iplapp.models.PlayerSeason;
import com.entlogics.iplapp.models.PlayerTeam;
import com.entlogics.iplapp.models.Season;
import com.entlogics.iplapp.models.Team;
import com.entlogics.iplapp.models.TeamMatch;
import com.entlogics.iplapp.models.TeamSeason;

/*
 * TODO Kunal, please add comment explaining what this class does
 */
public class SeasonRepository implements ISeasonRepository {

	static SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Season.class)
			.addAnnotatedClass(TeamSeason.class).addAnnotatedClass(Team.class).addAnnotatedClass(Player.class)
			.addAnnotatedClass(PlayerSeason.class).addAnnotatedClass(PlayerTeam.class).addAnnotatedClass(Match.class)
			.addAnnotatedClass(TeamMatch.class).addAnnotatedClass(PlayerMatch.class).addAnnotatedClass(Award.class)
			.buildSessionFactory();

	@Override
	public List<Season> findAllSeasons() {

		System.out.println("Inside SeasonRepository findAllSeasons()");

		Session session = factory.getCurrentSession();

		session.beginTransaction();
		Season s = session.get(Season.class, 1);
		
		System.out.println("Season id : "+ s.getSeasonId());
		System.out.println("Season Name : "+ s.getSeasonName());
		System.out.println("Players of Season: " + s.getSeasonPlayers());
		
		session.close();
		return null;
	}

	public static void main(String[] args) {

		SeasonRepository s = new SeasonRepository();

		System.out.println(s.findAllSeasons());
	}

	/*
	 * TODO Kunal add comment for each method, explaining what the method does
	 * Find Season Object by id from database
	 */
	@Override
	public Season findSeason(int seasonId) {
		System.out.println("Inside SeasonRepository findSeason");
		return null;
	}

	@Override
	public List<Team> findAllTeamsOfSeason(int seasonId) {
		System.out.println("Inside SeasonRepository findAllTeamsOfSeason");
		return null;
	}

	@Override
	public List<Player> findAllPlayersOfSeason(int seasonId) {
		System.out.println("Inside SeasonRepository findAllPlayersOfSeason");
		return null;
	}

	@Override
	public List<Match> findAllMatchesOfSeason(int seasonId) {
		System.out.println("Inside SeasonRepository findAllMatchesOfSeason");
		return null;
	}

	@Override
	public List<Award> findAllAwardsOfSeason(int seasonId) {
		System.out.println("Inside SeasonRepository findAllAwardsSeason");
		return null;
	}

	@Override
	public int createSeason(Season season) {
		System.out.println("Inside SeasonRepository createSeason");
		return 0;
	}

	@Override
	public void editSeason(Season season, int seasonId) {
		System.out.println("Inside SeasonRepository editSeason");

	}

	@Override
	public void deleteSeason(int seasonId) {
		System.out.println("Inside SeasonRepository deleteSeason");

	}

}
