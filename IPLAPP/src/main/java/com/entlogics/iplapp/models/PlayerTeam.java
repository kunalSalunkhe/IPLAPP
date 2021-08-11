package com.entlogics.iplapp.models;

public class PlayerTeam {

	private Player p;
	private Team t;
	private int noOfMatchesPlayed;
	private Season s;

	public PlayerTeam(Player p, Team t) {
		super();
		this.p = p;
		this.t = t;
	}

	public Player getP() {
		return p;
	}

	public void setP(Player p) {
		this.p = p;
	}

	public Team getT() {
		return t;
	}

	public void setT(Team t) {
		this.t = t;
	}

	public int getNoOfMatchesPlayed() {
		return noOfMatchesPlayed;
	}

	public void setNoOfMatchesPlayed(int noOfMatchesPlayed) {
		this.noOfMatchesPlayed = noOfMatchesPlayed;
	}

	public Season getS() {
		return s;
	}

	public void setS(Season s) {
		this.s = s;
	}

}
