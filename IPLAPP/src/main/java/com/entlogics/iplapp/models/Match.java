package com.entlogics.iplapp.models;

import java.util.List;

public class Match {

	private int matchId;
	private String matchDate;
	private String venue;
	private TeamMatch teamsPlayingInThisMatch;
	private List<PlayerMatch> players;
	private List<Award> awards;
	private Season season;

	public Match(int matchId, String matchDate, Season season, String venue) {
		super();
		this.matchId = matchId;
		this.matchDate = matchDate;
		this.season = season;
		this.venue = venue;

	}

	public int getMatchId() {
		return matchId;
	}

	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}

	public String getMatchDate() {
		return matchDate;
	}

	public void setMatchDate(String matchDate) {
		this.matchDate = matchDate;
	}

	public TeamMatch getTeamsPlayingInThisMatch() {
		return teamsPlayingInThisMatch;
	}

	public void setTeamsPlayingInThisMatch(TeamMatch teamsPlayingInThisMatch) {
		this.teamsPlayingInThisMatch = teamsPlayingInThisMatch;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public List<PlayerMatch> getPlayers() {
		return players;
	}

	public void setPlayers(List<PlayerMatch> players) {
		this.players = players;
	}

	public List<Award> getAwards() {
		return awards;
	}

	public void setAwards(List<Award> awards) {
		this.awards = awards;
	}

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}

	@Override
	public String toString() {
		return "Match [matchId=" + matchId + ", matchDate=" + matchDate + ", venue=" + venue
				+ ", teamsPlayingInThisMatch=" + teamsPlayingInThisMatch + ", awards=" + awards + "]";
	}

}
