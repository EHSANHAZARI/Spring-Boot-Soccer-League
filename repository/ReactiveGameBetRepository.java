package com.example.topleagues.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.example.topleagues.models.ReactiveGameBet;
@Repository
public interface ReactiveGameBetRepository extends ReactiveMongoRepository<ReactiveGameBet, String> {

	

}
