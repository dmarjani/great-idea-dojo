package com.marjani.greatidea.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.marjani.greatidea.model.Like;

public interface LikeRepository extends JpaRepository<Like, Long> {
	
	@Query("SELECT l FROM Like l WHERE l.idea.id = ?1")
	List<Like> getByIdeaId(Long ideaId);
	
	@Query("SELECT l FROM Like l WHERE l.idea.id = ?1 and l.user.id = ?2")
	Like getByIdeaIdAndUserId(Long ideaId, Long userId);
	
}
