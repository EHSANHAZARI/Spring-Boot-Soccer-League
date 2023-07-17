package com.example.topleagues.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.topleagues.models.ReactiveGameBet;
import com.example.topleagues.repository.ReactiveGameBetRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ReactiveGameBetService {

	@Autowired
	private ReactiveGameBetRepository reactiveGameBetRepository;

	public Flux<ReactiveGameBet> findAll() {
		return reactiveGameBetRepository.findAll();
	}

	public Mono<ReactiveGameBet> findById(String id) {
		return reactiveGameBetRepository.findById(id);
	}

	public Mono<ReactiveGameBet> save(ReactiveGameBet reactiveGameBet) {
		return reactiveGameBetRepository.save(reactiveGameBet);
	}

	public Mono<ReactiveGameBet> update(String id, ReactiveGameBet reactiveGameBet) {
		return reactiveGameBetRepository.findById(id).map(Optional::of).defaultIfEmpty(Optional.empty())
				.flatMap(gameBet -> {
					if (gameBet.isPresent()) {
						reactiveGameBet.setId(id);
						return reactiveGameBetRepository.save(reactiveGameBet);
					} else {
						return Mono.empty();
					}
				});

	}

	public Mono<Void> deleteById(String id) {
		return reactiveGameBetRepository.deleteById(id);
	}

	public Mono<Void> deleteAll() {
		return reactiveGameBetRepository.deleteAll();
	}
}
