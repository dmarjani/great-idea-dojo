package com.marjani.greatidea.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marjani.greatidea.model.Idea;
import com.marjani.greatidea.repository.IdeaRepository;

@Service
public class IdeaServiceImpl implements IdeaService {

	@Autowired
	private IdeaRepository ideaRepository;
	
	@Override
	public Idea findByName(String name) {
		return this.ideaRepository.findByName(name);
	}

	@Override
	public Idea save(Idea idea) {
		return this.ideaRepository.save(idea);
	}

	@Override
	public Idea update(Idea idea) {
		// idea id must me present
		return this.ideaRepository.save(idea);
	}

	@Override
	public void delete(Idea idea) {
		this.ideaRepository.delete(idea);
	}

	@Override
	public List<Idea> findAll() {
		return this.ideaRepository.findAll();
	}

	@Override
	public Idea findById(Long id) {
		return this.ideaRepository.getOne(id);
	}

}
