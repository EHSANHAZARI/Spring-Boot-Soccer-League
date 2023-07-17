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
@Table(name = "team")
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "club_name")
	private String clubName;

	@ManyToOne
	@JoinColumn(name = "league_id")
	private League league;

	@Column(name = "position")
	private long position;

	@Column(name = "played_games")
	private long playedGames;

	@Column(name = "wons_game")
	private long wonsGame;

	@Column(name = "draws")
	private long draws;

	@Column(name = "lost")
	private long lost;

	@Column(name = "goals_for")
	private long goalsFor;

	@Column(name = "goals_against")
	private long goals_against;

	@Column(name = "goal_difference")
	private long goalDifference;

	@Column(name = "points")
	private long points;

}
