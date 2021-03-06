package com.marjani.greatidea.service;

import com.marjani.greatidea.model.User;

public interface UserService {
	
    void save(User user);

    User findByUsername(String username);
    
    User findById(Long id);
    
}
