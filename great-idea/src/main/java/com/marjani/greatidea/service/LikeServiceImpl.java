package com.marjani.greatidea.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marjani.greatidea.model.Like;
import com.marjani.greatidea.repository.LikeRepository;

@Service
public class LikeServiceImpl implements LikeService {

	@Autowired
	private LikeRepository likeRepository;
	
	@Override
	public Like save(Like like) {
		return this.likeRepository.save(like);
	}

	@Override
	public void delete(Like like) {
		this.likeRepository.delete(like);
	}

	@Override
	public List<Like> getByIdeaId(Long ideaId) {
		return this.likeRepository.getByIdeaId(ideaId);
	}

	@Override
	public Like getByIdeaIdAndUserId(Long ideaId, Long userId) {
		return this.likeRepository.getByIdeaIdAndUserId(ideaId, userId);
	}

}
