package com.entlogics.iplapp.models;

public class TeamMatch {

	private Team t1, t2, winnerTeam;
	private Match m;
	private String matchStatus;
	private int team1Score, team2Score;

	public TeamMatch(Team t1, Team t2, Match m) {
		super();
		this.t1 = t1;
		this.t2 = t2;
		this.m = m;
	}

	public Team getT1() {
		return t1;
	}

	public void setT1(Team t1) {
		this.t1 = t1;
	}

	public Team getT2() {
		return t2;
	}

	public void setT2(Team t2) {
		this.t2 = t2;
	}

	public Team getWinnerTeam() {
		return winnerTeam;
	}

	public void setWinnerTeam(Team winnerTeam) {
		this.winnerTeam = winnerTeam;
	}

	public Match getM() {
		return m;
	}

	public void setM(Match m) {
		this.m = m;
	}

	public String getMatchStatus() {
		return matchStatus;
	}

	public void setMatchStatus(String matchStatus) {
		this.matchStatus = matchStatus;
	}

	public int getTeam1Score() {
		return team1Score;
	}

	public void setTeam1Score(int team1Score) {
		this.team1Score = team1Score;
	}

	public int getTeam2Score() {
		return team2Score;
	}

	public void setTeam2Score(int team2Score) {
		this.team2Score = team2Score;
	}

	@Override
	public String toString() {
		return "TeamMatch [t1=" + t1 + ", t2=" + t2 + "]";
	}

}
