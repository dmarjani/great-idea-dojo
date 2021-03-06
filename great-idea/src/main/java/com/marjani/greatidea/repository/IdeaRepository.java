package com.marjani.greatidea.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.marjani.greatidea.model.Idea;

public interface IdeaRepository extends JpaRepository<Idea, Long>  {

	Idea findByName(String name);
	
}
