package com.entlogics.iplapp.models;

import java.util.List;

import javax.validation.constraints.NotNull;

public class Season {

	private int seasonId;
	private String seasonName;

	private Integer yearOfSeason;

	private List<PlayerSeason> seasonPlayers;

	private List<Match> matches;

	private List<TeamSeason> seasonTeams;

	public Season(int seasonId, String seasonName, Integer yearOfSeason) {
		super();
		this.seasonId = seasonId;
		this.seasonName = seasonName;
		this.yearOfSeason = yearOfSeason;
	}

	public Season() {
		super();
	}

	public int getSeasonId() {
		return seasonId;
	}

	public void setSeasonId(int seasonId) {
		this.seasonId = seasonId;
	}

	public String getSeasonName() {
		return seasonName;
	}

	public void setSeasonName(String seasonName) {
		this.seasonName = seasonName;
	}

	public List<Match> getMatches() {
		return matches;
	}

	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}

	public Integer getYearOfSeason() {
		return yearOfSeason;
	}

	public void setYearOfSeason(Integer yearOfSeason) {
		this.yearOfSeason = yearOfSeason;
	}

	public List<PlayerSeason> getSeasonPlayers() {
		return seasonPlayers;
	}

	public void setSeasonPlayers(List<PlayerSeason> seasonPlayers) {
		this.seasonPlayers = seasonPlayers;
	}

	public List<TeamSeason> getSeasonTeams() {
		return seasonTeams;
	}

	public void setSeasonTeams(List<TeamSeason> seasonTeams) {
		this.seasonTeams = seasonTeams;
	}

	@Override
	public String toString() {
		return "Season [seasonId=" + seasonId + ", seasonName=" + seasonName + ", yearOfSeason=" + yearOfSeason
				+ ", seasonPlayers=" + seasonPlayers + ", matches=" + matches + ", seasonTeams=" + seasonTeams + "]";
	}

}