package com.tristan.services;

import com.tristan.models.UserRole;

public interface UserRoleService {
	int createRole(UserRole role);
	boolean deleteRole(UserRole role);
}
