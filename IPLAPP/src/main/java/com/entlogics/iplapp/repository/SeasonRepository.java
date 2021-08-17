package com.entlogics.iplapp.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.transaction.Transactional;

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

	/*
	 * Find all seasons of IPL from database
	 */
	@Override
	public List<Season> findAllSeasons() {

		System.out.println("Inside SeasonRepository findAllSeasons()");

		// get session from factory
		Session session = factory.getCurrentSession();

		// initialize session, opening portal to connect with database
		session.beginTransaction();

		// getting season list from database
		List<Season> seasons = session.createQuery("from Season s").getResultList();

		// closing session
		session.close();

		// returning this list
		return seasons;
	}

	/*
	 * Test method for checking findAllSeasons method working or not
	 */
	public void testFindAllSeasons() {

		System.out.println("Inside testFindAllSeasons()");

		// calling findAllSeasons
		List<Season> seasons = findAllSeasons();

		// Iterating over each session to print it on console
		ListIterator litr = seasons.listIterator();

		while (litr.hasNext()) {

			Season season = (Season) litr.next();

			System.out.println("season : " + season);
		}
	}

	/*
	 * TODO Kunal add comment for each method, explaining what the method does Find
	 * Season Object by id from database
	 */
	@Override
	public Season findSeason(int seasonId) {
		System.out.println("Inside SeasonRepository findSeason()");

		Session session = factory.getCurrentSession();

		session.beginTransaction();
		Season s = session.get(Season.class, seasonId);

		session.close();
		return s;
	}

	/*
	 * Test method for checking findSeason method working or not
	 */
	public void testFindSeason() {
		System.out.println("Inside testFindSeason()");
		Season s = findSeason(1);

		System.out.println("Season Object : " + s);
	}

	/*
	 * find all team of Season by Id from database
	 */

	@Override
	public List<Team> findAllTeamsOfSeason(int seasonId) {
		System.out.println("Inside SeasonRepository findAllTeamsOfSeason()");

		// get session from factory
		Session session = factory.getCurrentSession();

		// initialize session, opening portal to connect with database
		session.beginTransaction();

		Season season = session.get(Season.class, seasonId);

		// Creating list of TeamSeason
		// getting list of TeamSeason from database by seasonId
		List<TeamSeason> teamSeasons = season.getSeasonTeams();

		// Creating list of teams
		List<Team> teams = new ArrayList<Team>();

		// Iterate over TeamSeason
		ListIterator litr = teamSeasons.listIterator();

		while (litr.hasNext()) {

			TeamSeason tseason = (TeamSeason) litr.next();

			Team team = tseason.getTeam();

			teams.add(team);
		}

		session.close();

		return teams;
	}

	/*
	 * Test method for checking findAllTeamsOfSeason method working or not
	 */
	public void testFindAllTeamsOfSeason() {
		System.out.println("Inside SeasonRepository testFindAllTeamsOfSeason()");

		List<Team> teams = findAllTeamsOfSeason(1);

		ListIterator litr = teams.listIterator();

		while (litr.hasNext()) {

			Team team = (Team) litr.next();

			System.out.println("Team Object : " + team);
		}

	}

	/*
	 * find all players of Season by Id from database
	 */
	@Override
	public List<Player> findAllPlayersOfSeason(int seasonId) {
		System.out.println("Inside SeasonRepository findAllPlayersOfSeason()");

		// get session from factory
		Session session = factory.getCurrentSession();

		// initialize session, opening portal to connect with database
		session.beginTransaction();

		Season season = session.get(Season.class, seasonId);

		// Creating list of PlayerSeason
		// getting list of PlayerSeason from database by seasonId
		List<PlayerSeason> playerSeasons = season.getSeasonPlayers();

		// Creating list of players
		List<Player> players = new ArrayList<Player>();

		// Iterate over TeamSeason
		ListIterator litr = playerSeasons.listIterator();

		while (litr.hasNext()) {

			PlayerSeason pseason = (PlayerSeason) litr.next();

			Player player = pseason.getPlayer();

			players.add(player);
		}

		session.close();

		return players;
	}

	/*
	 * Test method for checking findAllPlayersOfSeason method working or not
	 */
	public void testFindAllPlayersOfSeason() {
		System.out.println("Inside SeasonRepository testFindAllPlayersOfSeason()");

		List<Player> players = findAllPlayersOfSeason(1);

		ListIterator litr = players.listIterator();

		while (litr.hasNext()) {

			Player player = (Player) litr.next();

			System.out.println("Player Object : " + player);
		}

	}

	/*
	 * find all matches of Season by Id from database
	 */
	@Override
	public List<Match> findAllMatchesOfSeason(int seasonId) {
		System.out.println("Inside SeasonRepository findAllMatchesOfSeason()");

		// get session from factory
		Session session = factory.getCurrentSession();

		// initialize session, opening portal to connect with database
		session.beginTransaction();

		Season season = session.get(Season.class, seasonId);

		// Creating list of Matches
		// getting list of matches from database by seasonId
		List<Match> matches = season.getMatches();

		// session.close();

		return matches;
	}

	/*
	 * Test method for checking findAllMatchesOfSeason method working or not
	 */
	public void testFindAllMatchesOfSeason() {
		System.out.println("Inside SeasonRepository testFindAllMatchesOfSeason()");

		List<Match> matches = findAllMatchesOfSeason(1);

		ListIterator litr = matches.listIterator();

		while (litr.hasNext()) {

			Match match = (Match) litr.next();

			System.out.println("Match Object : " + match);
		}
	}

	/*
	 * find all matches of Season by Id from database iterate over a match to get it
	 * award hence return this award list
	 */

	@Override
	public List<Award> findAllAwardsOfSeason(int seasonId) {
		System.out.println("Inside SeasonRepository findAllAwardsSeason()");

		// get session from factory
		Session session = factory.getCurrentSession();

		// initialize session, opening portal to connect with database
		// session.beginTransaction();

		Season season = session.get(Season.class, seasonId);

		// Creating list of Matches
		// getting list of matches from database by seasonId
		List<Match> matches = season.getMatches();

		// Creating award list
		List<Award> totalAwards = new ArrayList<Award>();

		// Iterating over matches to get awards of each match
		ListIterator litr = matches.listIterator();

		while (litr.hasNext()) {

			Match match = (Match) litr.next();

			List<Award> awardsOfMatch = match.getAwards();

			// iterate over awardOfMatch and add award one by one in totalAwards

			ListIterator alitr = awardsOfMatch.listIterator();

			while (alitr.hasNext()) {

				Award award = (Award) alitr.next();

				totalAwards.add(award);

			}

		}

		// session.close();
		return totalAwards;
	}

	/*
	 * Test method for checking findAllMatchesOfSeason method working or not
	 */
	public void testFindAllAwardsOfSeason() {
		System.out.println("Inside SeasonRepository testFindAllMatchesOfSeason()");

		Session session = factory.getCurrentSession();

		List<Award> awards = findAllAwardsOfSeason(1);

		ListIterator litr = awards.listIterator();

		while (litr.hasNext()) {

			Award award = (Award) litr.next();

			System.out.println("Match Object : " + award);
		}
		session.close();
	}

	/*
	 * get a new season object and save it in session
	 */
	@Override
	public void createSeason(Season season) {
		System.out.println("Inside SeasonRepository createSeason()");

		Session session = factory.getCurrentSession();

		session.beginTransaction();

		session.save(season);

		session.close();

	}

	/*
	 * Creating a new season object and pass it to createSeason
	 */
	public void testCreateSeason() {

		Season season = new Season("season5", 2022);

		createSeason(season);
	}

	/*
	 * get Season by seasonId and then edit it and save again
	 */
	@Override
	public void editSeason(int seasonId) {
		System.out.println("Inside SeasonRepository editSeason()");

	}
	
	/*
	 * Test method for editing a season
	 */
	public void testEditSeason() {
	
	}

	@Override
	public void deleteSeason(int seasonId) {
		System.out.println("Inside SeasonRepository deleteSeason()");

	}

	/*
	 * main method calling all test methods
	 */
	public static void main(String[] args) {
		System.out.println("Inside main method");

		// Creating object of SeasonRepository for calling non-static methods
		SeasonRepository sr = new SeasonRepository();

		sr.testFindAllSeasons();
		sr.testFindSeason();
		sr.testFindAllTeamsOfSeason();
		sr.testFindAllPlayersOfSeason();
		sr.testFindAllMatchesOfSeason();
		sr.testFindAllAwardsOfSeason();
		sr.testCreateSeason();
	}

}
