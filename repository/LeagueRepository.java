package com.example.topleagues.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.topleagues.models.League;

@Repository
public interface LeagueRepository extends JpaRepository<League, Long> {

}
