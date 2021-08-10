package com.entlogics.iplapp.models;

public class TeamSeason {

	private Team team;
	private Season season;
	private Player captain;
	private int rank;
	private Player highestRunsScorer;
	private Player highestWicketTaker;

	public TeamSeason(Team team, Season season) {
		super();
		this.team = team;
		this.season = season;
	}

	public void setTeamSeasonProperties(Player cap, int rank, Player hrs, Player hwt) {

		this.setCaptain(cap);
		this.setRank(1);
		this.setHighestRunsScorer(hwt);
		this.setHighestWicketTaker(hwt);

	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}

	public Player getCaptain() {
		return captain;
	}

	public void setCaptain(Player captain) {
		this.captain = captain;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public Player getHighestRunsScorer() {
		return highestRunsScorer;
	}

	public void setHighestRunsScorer(Player highestRunsScorer) {
		this.highestRunsScorer = highestRunsScorer;
	}

	public Player getHighestWicketTaker() {
		return highestWicketTaker;
	}

	public void setHighestWicketTaker(Player highestWicketTaker) {
		this.highestWicketTaker = highestWicketTaker;
	}

	@Override
	public String toString() {
		return "TeamSeason [team=" + team + ", captain=" + captain + ", rank=" + rank + ", highestRunsScorer="
				+ highestRunsScorer + ", highestWicketTaker=" + highestWicketTaker + "]";
	}
}
