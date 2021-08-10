package com.entlogics.iplapp.models;

import java.util.List;

public class Team {

	private int teamId;
	private String teamName;
	private String ownerName;

	private List<TeamSeason> teamSeasons;

	private List<PlayerTeam> teamPlayers;

	private List<TeamMatch> teamMatches;

	public Team(int teamId, String teamName, String ownerName) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
		this.ownerName = ownerName;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public List<TeamSeason> getTeamSeasons() {
		return teamSeasons;
	}

	public void setTeamSeasons(List<TeamSeason> teamSeasons) {
		this.teamSeasons = teamSeasons;
	}

	public List<PlayerTeam> getTeamPlayers() {
		return teamPlayers;
	}

	public void setTeamPlayers(List<PlayerTeam> teamPlayers) {
		this.teamPlayers = teamPlayers;
	}

	public List<TeamMatch> getTeamMatches() {
		return teamMatches;
	}

	public void setTeamMatches(List<TeamMatch> teamMatches) {
		this.teamMatches = teamMatches;
	}

	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", teamName=" + teamName + ", ownerName=" + ownerName + "]";
	}

}
