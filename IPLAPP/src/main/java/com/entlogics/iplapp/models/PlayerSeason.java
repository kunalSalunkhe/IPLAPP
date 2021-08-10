package com.entlogics.iplapp.models;

public class PlayerSeason {

	private Player player;
	private Season season;
	private int totalRuns;
	private int totalWickets;
	private int totalCatches;
	private float strikeRate;

	public PlayerSeason(Player player, Season season) {
		super();
		this.player = player;
		this.season = season;
	}

	public void setPlayerSeasonProperties(int runs, int wickets, float strikeRate, int catches) {

		this.setTotalRuns(runs);
		this.setTotalWickets(wickets);
		this.setStrikeRate(strikeRate);
		this.setTotalCatches(catches);
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}

	public int getTotalRuns() {
		return totalRuns;
	}

	public void setTotalRuns(int totalRuns) {
		this.totalRuns = totalRuns;
	}

	public int getTotalWickets() {
		return totalWickets;
	}

	public void setTotalWickets(int totalWickets) {
		this.totalWickets = totalWickets;
	}

	public int getTotalCatches() {
		return totalCatches;
	}

	public void setTotalCatches(int totalCatches) {
		this.totalCatches = totalCatches;
	}

	public float getStrikeRate() {
		return strikeRate;
	}

	public void setStrikeRate(float strikeRate) {
		this.strikeRate = strikeRate;
	}

	@Override
	public String toString() {
		return "PlayerSeason [totalRuns=" + totalRuns + ", totalWickets=" + totalWickets + "]";
	}

}
