package com.entlogics.iplapp.models;

public class Award {

	private int awardId;
	private String awardName;
	private Player winner;
	private Match match;

	public Award(int awardId, String awardName, Match match) {
		super();
		this.awardId = awardId;
		this.awardName = awardName;
		this.match = match;
	}

	public int getAwardId() {
		return awardId;
	}

	public void setAwardId(int awardId) {
		this.awardId = awardId;
	}

	public String getAwardName() {
		return awardName;
	}

	public void setAwardName(String awardName) {
		this.awardName = awardName;
	}

	public Player getWinner() {
		return winner;
	}

	public void setWinner(Player winner) {
		this.winner = winner;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	@Override
	public String toString() {
		return "Award [awardId=" + awardId + ", awardName=" + awardName + "]";
	}
}