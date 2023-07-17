package com.example.topleagues.repository.auth;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.topleagues.models.auth.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
	
}
