package com.marjani.greatidea.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marjani.greatidea.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
	User findByUsername(String username);
	
}
