package com.example.topleagues.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "game_bet")
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class GameBet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "home_team_scores")
	private long homeTeamScores;

	@Column(name = "guest_team_scores")
	private long guestTeamScores;

	@ManyToOne
	@JoinColumn(name = "host_team_id")
	private Team hostTeam;

	@ManyToOne
	@JoinColumn(name = "guest_team_id")
	private Team guestTeam;

	@ManyToOne
	@JoinColumn(name = "gamester_id")
	private Gamester gamester;
}
