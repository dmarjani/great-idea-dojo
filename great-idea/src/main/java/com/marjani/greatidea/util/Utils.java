package com.marjani.greatidea.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.marjani.greatidea.model.Idea;
import com.marjani.greatidea.model.Like;
import com.marjani.greatidea.model.User;

@Component
public class Utils {

	public Map<String, Object> mergeIdeaLikes(Idea idea, List<Like> likes, User currentUser) {		
		Map<String, Object> ideaMap = new HashMap<>();
		ideaMap.put("id", idea.getId());
		ideaMap.put("name", idea.getName());
		ideaMap.put("user", this.userMap(idea.getUser()));
		List<Map<String, Object>> likeList = new ArrayList<Map<String,Object>>();
		String userLikes = "Like";
		for(Like like: likes) {
			if(like.getIdea().getId() == idea.getId()) {
				likeList.add(this.likeMap(like));
			}
			if(like.getUser().getId() == currentUser.getId()) {
				userLikes = "Unlike";
			}
		}
		ideaMap.put("likes", likeList);
		ideaMap.put("likeNumber", likeList.size());
		ideaMap.put("userLikes", userLikes);
		
		return ideaMap;
	}
	
	public Map<String, Object> getIdeaMap(Idea idea) {		
		Map<String, Object> ideaMap = new HashMap<>();
		ideaMap.put("id", idea.getId());
		ideaMap.put("name", idea.getName());
		ideaMap.put("user", this.userMap(idea.getUser()));
		return ideaMap;
	}
	
	private Map<String, Object> userMap(User user){
		Map<String, Object> userMap = new HashMap<>();
		userMap.put("id", user.getId());
		userMap.put("username", user.getUsername()); 
		return userMap;
	}
	
	private Map<String, Object> likeMap(Like like){
		Map<String, Object> likeMap = new HashMap<>();
		likeMap.put("id", like.getId());
		likeMap.put("user", this.userMap(like.getUser()));
		likeMap.put("idea", this.ideaMap(like.getIdea())); 
		return likeMap;
	}
	
	private Map<String, Object> ideaMap(Idea idea){
		Map<String, Object> ideaMap = new HashMap<>();
		ideaMap.put("id", idea.getId());
		ideaMap.put("name", idea.getName());
		ideaMap.put("user", this.userMap(idea.getUser())); 
		return ideaMap;
	}
	
}
