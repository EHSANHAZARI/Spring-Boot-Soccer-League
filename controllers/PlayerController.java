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
import com.example.topleagues.models.Player;
import com.example.topleagues.repository.PlayerRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/")
public class PlayerController {

	@Autowired
	private PlayerRepository playerRepository;

	@GetMapping("players")
	public List<Player> getAllPlayers() {
		return playerRepository.findAll();
	}

	@GetMapping("players/{id}")
	public ResponseEntity<Player> findPlayerById(@PathVariable(value = "id") long playerId)
			throws ResourceNotFoundException {
		Player player = playerRepository.findById(playerId)
				.orElseThrow(() -> new ResourceNotFoundException("this player not exist"));

		return ResponseEntity.ok().body(player);

	}

	@PutMapping("players/{id}")
	public ResponseEntity<Player> updatePlayerById(@PathVariable(value = "id") long playerId,
			@Valid @RequestBody Player newPlayer) throws ResourceNotFoundException {
		Player player = playerRepository.findById(playerId)
				.orElseThrow(() -> new ResourceNotFoundException("No Player with this id "));

		player.setFirstName(newPlayer.getFirstName());
		player.setAssists(newPlayer.getAssists());
		player.setGoals(newPlayer.getGoals());
		player.setLastName(newPlayer.getLastName());
		player.setPlays(newPlayer.getPlays());
		player.setTeam(newPlayer.getTeam());

		return ResponseEntity.ok().body(playerRepository.save(player));

	}

	@PostMapping("players")
	public Player createNewPlayer(@RequestBody Player player) {
		return playerRepository.save(player);
	}

	@DeleteMapping("players/{id}")
	public Map<String, Boolean> deletePlayerById(@PathVariable(value = "id") long playerId)
			throws ResourceNotFoundException {
		Player player = playerRepository.findById(playerId)
				.orElseThrow(() -> new ResourceNotFoundException("No player with this id"));

		playerRepository.delete(player);

		Map<String, Boolean> response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);

		return response;
	}

}
