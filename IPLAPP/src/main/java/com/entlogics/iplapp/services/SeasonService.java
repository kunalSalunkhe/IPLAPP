package com.entlogics.iplapp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entlogics.iplapp.models.Award;
import com.entlogics.iplapp.models.Match;
import com.entlogics.iplapp.models.Player;
import com.entlogics.iplapp.models.PlayerSeason;
import com.entlogics.iplapp.models.Season;
import com.entlogics.iplapp.models.Team;
import com.entlogics.iplapp.models.TeamMatch;
import com.entlogics.iplapp.models.TeamSeason;

@Service
public class SeasonService implements ISeasonService {

	public static List<Season> listOfSeasons = new ArrayList<Season>();

	@Override
	public void createDatabase() {
		System.out.println("Creating Database....");

		// Creating Season Objects
		Season s1 = new Season(1, "season1", 2019);
		Season s2 = new Season(2, "season2", 2020);
		Season s3 = new Season(3, "season3", 2021);

		// adding Players in Season Objects for that Creating PlayerSeason Objects
		Player p1 = new Player(1, "Dhoni", "WicketKeepar");
		Player p2 = new Player(2, "Kohli", "Batsman");
		Player p3 = new Player(3, "Bumrah", "Bowler");

		PlayerSeason ps1 = new PlayerSeason(p1, s1);
		PlayerSeason ps2 = new PlayerSeason(p2, s1);

		// adding all properties of PlayerSeason
		ps1.setPlayerSeasonProperties(300, 0, 130.45f, 5);
		ps2.setPlayerSeasonProperties(400, 2, 135.45f, 6);

		// creating list of PlayerSeason
		List<PlayerSeason> psList = new ArrayList<PlayerSeason>();

		// Adding PlayerSeason objects in list
		psList.add(ps1);
		psList.add(ps2);

		// adding list of playerSeason in seasons
		s2.setSeasonPlayers(psList);
		s1.setSeasonPlayers(psList);

		System.out.println("Players are added in Season");

		//// adding Matches in Season Objects - for that Creating Match Objects
		Match match1 = new Match(1, s1, "Mumbai");
		Match match2 = new Match(2, s1, "Banglore");

		// Creating TeamMatch objects for adding teams which are playing in this matches
		Team team1 = new Team(1, "CSK", "India Cements");
		Team team2 = new Team(2, "MI", "Reliance");
		Team team3 = new Team(3, "RCB", "RRR");

		TeamMatch teamMatch1 = new TeamMatch(team1, team2, match1);
		TeamMatch teamMatch2 = new TeamMatch(team1, team3, match2);

		// add teams in Match
		match1.setTeamsPlayingInThisMatch(teamMatch1);
		match2.setTeamsPlayingInThisMatch(teamMatch2);

		// Adding Awards in Match - for the we need to add award objects list in the
		// match
		Award award1 = new Award(1, "Man Of The Match", match1);
		Award award2 = new Award(2, "SuperStriker", match1);
		Award award3 = new Award(3, "Man Of The Match", match2);
		Award award4 = new Award(4, "SuperStriker", match2);

		// Adding other Properties Of Award
		award1.setWinner(p1);
		award2.setWinner(p1);
		award3.setWinner(p2);
		award4.setWinner(p2);

		// Creating List of Awards for match 1
		List<Award> awardList1 = new ArrayList<Award>();

		// creating list for awards for match2
		List<Award> awardList2 = new ArrayList<Award>();

		// add awards in awardList 1
		awardList1.add(award1);
		awardList1.add(award2);

		// add awards in awardsList 2
		awardList2.add(award3);
		awardList2.add(award4);

		// adding awardList in match
		match1.setAwards(awardList1);
		match2.setAwards(awardList2);
		// Creating list of matches
		List<Match> matchList = new ArrayList<Match>();

		// adding matches in list
		matchList.add(match1);
		matchList.add(match2);

		// Adding Matches in season
		s1.setMatches(matchList);
		s2.setMatches(matchList);

		System.out.println("Matches are added in Season");

		// Adding Teams in season for that creating TeamSeason objects
		TeamSeason teamSeason1 = new TeamSeason(team1, s1);
		TeamSeason teamSeason2 = new TeamSeason(team2, s1);

		// Adding other properties of for TeamSeason object
		teamSeason1.setTeamSeasonProperties(p1, "Champion", p1, p1);
		teamSeason1.setTeamSeasonProperties(p2, "Runner up", p2, p3);

		// Creating TeamSeason list
		List<TeamSeason> teamSeasonList = new ArrayList<TeamSeason>();

		// Adding TeamSeason Objects in list
		teamSeasonList.add(teamSeason1);
		teamSeasonList.add(teamSeason2);

		// Adding teamSeason in Season Object
		s1.setSeasonTeams(teamSeasonList);
		s2.setSeasonTeams(teamSeasonList);

		System.out.println("Teams are added in Season");

		listOfSeasons.add(s1);
		listOfSeasons.add(s2);
		listOfSeasons.add(s3);

		System.out.println("Size of the Season Database is :" + listOfSeasons.size());
		System.out.println("Created Database Succesfully...");
	}

	@Override
	public List<Season> getAllSeasons() {

		return listOfSeasons;
	}

	@Override
	public Season getSeason(int seasonId) {
		System.out.println("Inside SeasonService getSeason() method");

		Season season = null;
		try {
			season = listOfSeasons.get(seasonId - 1);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return season;
	}

	@Override
	public List<Team> getAllTeamsOfSeason(int seasonId) {
		System.out.println("Inside SeasonService getAllTeamsOfSeason() method");

		// Find Season from database by seasonId
		Season season = null;
		try {
			season = listOfSeasons.get(seasonId - 1);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Getting List of TeamSeason for a founded season
		List<TeamSeason> seasonTeams = season.getSeasonTeams();

		// Creating list of team that has to return
		List<Team> teams = new ArrayList<Team>();

		// Getting Each team from TeamSeason and hence add that team in team list
		ListIterator litr = seasonTeams.listIterator();

		while (litr.hasNext()) {

			TeamSeason teamSeason = (TeamSeason) litr.next();

			teams.add(teamSeason.getTeam());
		}

		return teams;
	}

	@Override
	public List<Player> getAllPlayersOfSeason(int seasonId) {

		System.out.println("Inside SeasonService getAllPlayerOfSeason() method");

		// Findind Season from database by seasonId
		Season season = null;
		try {
			season = listOfSeasons.get(seasonId - 1);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Getting List of PlayerSeason for a founded season
		List<PlayerSeason> seasonPlayers = season.getSeasonPlayers();

		// Creating list of player that has to return
		List<Player> players = new ArrayList<Player>();

		// Getting Each player from PlayerSeason and hence add that player in player
		// list
		ListIterator litr = seasonPlayers.listIterator();

		while (litr.hasNext()) {

			PlayerSeason playerSeason = (PlayerSeason) litr.next();

			players.add(playerSeason.getPlayer());
		}

		return players;
	}

	@Override
	public List<Match> getAllMatchesOfSeason(int seasonId) {

		System.out.println("Inside SeasonService getAllMatchesOfSeason() method");

		// Findind Season from database by seasonId
		Season season = null;
		try {
			season = listOfSeasons.get(seasonId - 1);
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<Match> matches = new ArrayList<Match>();

		matches = season.getMatches();

		return matches;
	}

	@Override
	public List<Award> getAllAwardsOfSeason(int seasonId) {

		System.out.println("Inside SeasonService getAllAwardsSeason() method");

		// Findind Season from database by seasonId
		Season season = null;
		try {
			season = listOfSeasons.get(seasonId - 1);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Creating Award List
		List<Award> awardsOfSeason = new ArrayList<Award>();

		// getting list of all matches
		List<Match> matches = season.getMatches();

		// iterate over the match
		ListIterator mlitr = matches.listIterator();

		while (mlitr.hasNext()) {

			Match match = (Match) mlitr.next();

			// Creating list for awards for each match
			List<Award> awardsOfMatch = match.getAwards();

			// Iterate over awardsOfMatch to get each award
			ListIterator aitr = awardsOfMatch.listIterator();

			while (aitr.hasNext()) {

				Award award = (Award) aitr.next();

				// adding this award in awards of season
				awardsOfSeason.add(award);
			}

		}

		return awardsOfSeason;
	}

	@Override
	public int createSeason(Season season) {
		System.out.println("Inside SeasonService createSeason method");

		listOfSeasons.add(season);

		System.out.println("Size of the database id : " + listOfSeasons.size());

		return 0;
	}

	@Override
	public void editSeason(Season season, int seasonId) {

		System.out.println("Inside SeasonService editSeason() method");

		listOfSeasons.set(seasonId - 1, season);

		System.out.println("Season after editing : " + season);

	}

	@Override
	public void deleteSeason(int seasonId) {

		System.out.println("Inside SeasonService deleteSeason() method" + seasonId);

		listOfSeasons.remove(seasonId - 1);

		System.out.println("Size of the database id : " + listOfSeasons.size());

	}

}
