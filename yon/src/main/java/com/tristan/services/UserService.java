package com.tristan.services;

import com.tristan.models.User;

public interface UserService {
	
	int createUser(User user);
	User login(String username, String password);
}
