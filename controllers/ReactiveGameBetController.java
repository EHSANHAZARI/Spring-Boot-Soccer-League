package com.example.topleagues.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.topleagues.models.ReactiveGameBet;
import com.example.topleagues.service.ReactiveGameBetService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class ReactiveGameBetController {

	@Autowired
	private ReactiveGameBetService reactiveGameBetService;

	@GetMapping("/gamebets")
	@ResponseStatus(HttpStatus.OK)
	public Flux<ReactiveGameBet> getAllBets() {
		return reactiveGameBetService.findAll();
	}

	@GetMapping("/gamebets/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Mono<ReactiveGameBet> getBetById(@PathVariable(value = "id") String id) {
		return reactiveGameBetService.findById(id);
	}
	
	@PostMapping("/gamebets")
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<ReactiveGameBet> createBet(@RequestBody ReactiveGameBet reactiveGameBet )
	{
		return reactiveGameBetService.save(new ReactiveGameBet(reactiveGameBet.getHomeTeamScores(),reactiveGameBet.getGuestTeamScores(),reactiveGameBet.getHostTeamName(),reactiveGameBet.getGuestTeamName()));
	}
	
	@DeleteMapping("/gamebets")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Mono<Void> removeAllBets()
	{
		return reactiveGameBetService.deleteAll();
	}
	
	@DeleteMapping("/gamebets/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Mono<Void> removeBetWithId(@PathVariable(value = "id") String id)
	{
		return reactiveGameBetService.deleteById(id);
	}
	
	@PutMapping("/gamebets/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Mono<ReactiveGameBet> update (@PathVariable(value = "id") String id, @RequestBody ReactiveGameBet reactiveGameBet){
		return reactiveGameBetService.update(id,reactiveGameBet );
	}
}
