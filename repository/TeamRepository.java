package com.example.topleagues.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.topleagues.models.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

}
