package com.marjani.greatidea.service;

import java.util.List;

import com.marjani.greatidea.model.Idea;

public interface IdeaService {

	Idea findByName(String name);
	
	Idea findById(Long id);
	
	Idea save(Idea idea);
	
	Idea update(Idea idea);
	
	void delete(Idea idea);
	
	List<Idea> findAll();
	
}
