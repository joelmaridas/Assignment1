package com.tristan.services;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tristan.models.UserRole;
import com.tristan.repositories.UserRoleRepository;

@Service
@Transactional
public class UserRoleServiceImpl implements UserRoleService {
	
	@Autowired
	private UserRoleRepository urrepo;
	
	public UserRoleServiceImpl(UserRoleRepository dao) {
		this.urrepo = dao;
	}

	@Override
	public int createRole(UserRole role) {
		if (urrepo.existsByRole(role.getRole())) {
			return -1;
		}
		
		// return 1 if creation is successful else 0
		long roleKey = urrepo.save(role).getId();
		return (roleKey > 0) ? 1 : 0;
	}
	
	@Override
	public boolean deleteRole(UserRole role) {
		urrepo.deleteByRole(role.getRole());
		return true;
	}
}