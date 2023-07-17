package com.example.topleagues.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ReactiveGameBet {

	@Id
	private String id;

	private long homeTeamScores;

	private long guestTeamScores;

	private String hostTeamName;

	private String guestTeamName;

	public ReactiveGameBet(long homeTeamScores, long guestTeamScores, String hostTeamName, String guestTeamName) {
		this.homeTeamScores = homeTeamScores;
		this.guestTeamScores = guestTeamScores;
		this.hostTeamName = hostTeamName;
		this.guestTeamName = guestTeamName;
	}

	public ReactiveGameBet() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getHomeTeamScores() {
		return homeTeamScores;
	}

	public void setHomeTeamScores(long homeTeamScores) {
		this.homeTeamScores = homeTeamScores;
	}

	public long getGuestTeamScores() {
		return guestTeamScores;
	}

	public void setGuestTeamScores(long guestTeamScores) {
		this.guestTeamScores = guestTeamScores;
	}

	public String getHostTeamName() {
		return hostTeamName;
	}

	public void setHostTeamName(String hostTeamName) {
		this.hostTeamName = hostTeamName;
	}

	public String getGuestTeamName() {
		return guestTeamName;
	}

	public void setGuestTeamName(String guestTeamName) {
		this.guestTeamName = guestTeamName;
	}

}
