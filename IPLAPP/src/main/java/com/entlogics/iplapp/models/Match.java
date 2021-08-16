package com.entlogics.iplapp.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "dt_match")
public class Match {

	@Id
	@Column(name = "matchID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int matchId;

	private String matchDate;

	@Column(name = "venue")
	private String venue;

	@OneToOne(mappedBy = "m")
	private TeamMatch teamsPlayingInThisMatch;

	@OneToMany(mappedBy = "match", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<PlayerMatch> players;

	@OneToMany(mappedBy = "match", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Award> awards;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "seasonID")
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
