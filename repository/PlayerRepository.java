package com.example.topleagues.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.topleagues.models.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long>{

}
