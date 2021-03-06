package com.marjani.greatidea.service;

import java.util.List;

import com.marjani.greatidea.model.Like;

public interface LikeService {

	Like save(Like like);
	
	void delete(Like like);
	
	List<Like> getByIdeaId(Long ideaId);
	
	Like getByIdeaIdAndUserId(Long ideaId, Long userId);
	
}
