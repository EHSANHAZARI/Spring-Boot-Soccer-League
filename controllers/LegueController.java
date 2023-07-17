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
import com.example.topleagues.models.League;
import com.example.topleagues.repository.LeagueRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class LegueController {

	@Autowired
	private LeagueRepository leagueRepository;

	@GetMapping("leagues")
	public List<League> findAllLegues() {
		return leagueRepository.findAll();
	}

	@GetMapping("leagues/{id}")
	private ResponseEntity<League> findLeagueById(@PathVariable(value = "id") long leagueId)
			throws ResourceNotFoundException {
		League league = leagueRepository.findById(leagueId)
				.orElseThrow(() -> new ResourceNotFoundException("Not such a League"));

		return ResponseEntity.ok().body(league);

	}

	@PostMapping("/leagues")
	private League createLeague(@RequestBody League league) {
		return leagueRepository.save(league);
	}

	@PutMapping("leagues/{id}")
	private ResponseEntity<League> updateLeagueById(@PathVariable(value = "id") long id,
			@RequestBody @Valid League newleague) throws ResourceNotFoundException {

		League league = leagueRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not such a league existe"));

		league.setLeagueName(newleague.getLeagueName());
		league.setNumberOfTeams(newleague.getNumberOfTeams());
		league.setTeams(newleague.getTeams());
		league.setTopScorers(newleague.getTopScorers());

		return ResponseEntity.ok().body(leagueRepository.save(league));
	}

	@DeleteMapping("leagues/{id}")
	private Map<String, Boolean> deleteLeagueById(@PathVariable(value = "id") long id)
			throws ResourceNotFoundException {
		League league = leagueRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not such a league exist"));

		leagueRepository.delete(league);
		Map<String, Boolean> respond = new HashMap<>();

		respond.put("The leagues is deleted", true);

		return respond;
	}
}
