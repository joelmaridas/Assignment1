package com.tristan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tristan.models.User;
import com.tristan.repositories.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository urepo;
	
	public UserServiceImpl(UserRepository dao) {
		this.urepo = dao;
	}
	
	@Override
	public int createUser(User user) {
		if (urepo.existsByUsername(user.getUsername())) {
			return -1;
		}
		
		if (urepo.existsByEmail(user.getEmail())) {
			return -2;
		}
		
		// Return 1 if creation successful, 0 if not
		long userKey = urepo.save(user).getId();
		return (userKey > 0) ? 1 : 0;
	}

	@Override
	public User login(String username, String password) {
		return urepo.getByUsernameAndPassword(username, password);
	}

}
