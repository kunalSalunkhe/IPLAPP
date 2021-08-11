package com.entlogics.iplapp.models;

import java.util.List;

public class Player {

	private int playerId;
	private String playerName;
	private String type;
	private int age;
	private List<PlayerSeason> playerSeasons;
	private List<PlayerTeam> playerTeams;
	private List<PlayerMatch> playerMatches;
	private List<Award> awardsWon;

	public Player(int playerId, String playerName, String type) {
		super();
		this.playerId = playerId;
		this.playerName = playerName;
		this.type = type;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<PlayerSeason> getPlayerSeasons() {
		return playerSeasons;
	}

	public void setPlayerSeasons(List<PlayerSeason> playerSeasons) {
		this.playerSeasons = playerSeasons;
	}

	public List<PlayerTeam> getPlayerTeams() {
		return playerTeams;
	}

	public void setPlayerTeams(List<PlayerTeam> playerTeams) {
		this.playerTeams = playerTeams;
	}

	public List<PlayerMatch> getPlayerMatches() {
		return playerMatches;
	}

	public void setPlayerMatches(List<PlayerMatch> playerMatches) {
		this.playerMatches = playerMatches;
	}

	public List<Award> getAwardsWon() {
		return awardsWon;
	}

	public void setAwardsWon(List<Award> awardsWon) {
		this.awardsWon = awardsWon;
	}

	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", playerName=" + playerName + ", type=" + type + ", playerSeasons="
				+ playerSeasons + "]";
	}

	

}
