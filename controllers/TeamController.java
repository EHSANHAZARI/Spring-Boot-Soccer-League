package com.example.topleagues.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.topleagues.exceptions.ResourceNotFoundException;
import com.example.topleagues.models.Team;
import com.example.topleagues.repository.TeamRepository;

@RestController
@RequestMapping("api")
public class TeamController {

	@Autowired
	private TeamRepository teamRepository;

	@GetMapping("teams")
	public List<Team> getAllPlayers() {
		return teamRepository.findAll();
	}

	@GetMapping("teams/{id}")
	public ResponseEntity<Team> findTeamById(@PathVariable(value = "id") long teamId) throws ResourceNotFoundException {
		Team team = teamRepository.findById(teamId).orElseThrow(() -> new ResourceNotFoundException("Team not found"));

		return ResponseEntity.ok().body(team);

	}

	@PostMapping("teams")
	public Team createTeam(@RequestBody Team team) {
		return teamRepository.save(team);
	}

	@PutMapping("teams/{id}")
	public ResponseEntity<Team> changeTeamById(@PathVariable(value = "id") long teamId, @RequestBody Team newTeam)
			throws ResourceNotFoundException {
		Team team = teamRepository.findById(teamId)
				.orElseThrow(() -> new ResourceNotFoundException("Team is not exist"));

		team.setClubName(newTeam.getClubName());
		team.setDraws(newTeam.getDraws());
		team.setGoalDifference(newTeam.getGoalDifference());
		team.setGoals_against(newTeam.getGoals_against());
		team.setGoalsFor(newTeam.getGoalsFor());
		team.setLeague(newTeam.getLeague());
		team.setLost(newTeam.getLost());
		team.setPlayedGames(newTeam.getPlayedGames());
		team.setPoints(newTeam.getPoints());
		team.setPosition(newTeam.getPosition());
		team.setWonsGame(newTeam.getWonsGame());
		return ResponseEntity.ok(teamRepository.save(team));

	}

	@DeleteMapping("teams/{id}")
	public Map<String, Boolean> deleteTeamById(@PathVariable(value = "id") long teamId)
			throws ResourceNotFoundException {
		Team team = teamRepository.findById(teamId)
				.orElseThrow(() -> new ResourceNotFoundException("No Team with this Id"));

		teamRepository.delete(team);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deleted", true);

		return response;

	}
}
