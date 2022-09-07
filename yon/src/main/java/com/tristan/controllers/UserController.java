package com.tristan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tristan.models.ClientMessage;
import com.tristan.models.User;
import com.tristan.models.UserRole;
import com.tristan.services.UserRoleService;
import com.tristan.services.UserService;

import static com.tristan.util.ClientMessageUtil.*;

@RestController
public class UserController {

	@Autowired
	private UserService uservice;

	@Autowired
	private UserRoleService urservice;

	@PostMapping("/userRole")
	public @ResponseBody ClientMessage createUserRole(@RequestBody UserRole role) {
		int code = urservice.createRole(role);
		switch (code) {
		case 1:
			return CREATION_SUCCESSFUL;
		case 0:
			return CREATION_FAILED;
		case -1:
			return ENTITY_ALREADY_EXISTS;
		}
		
		return null;
	}

	@DeleteMapping("/userRole")
	public @ResponseBody ClientMessage deleteUserRole(@RequestBody UserRole role) {
		return urservice.deleteRole(role) ? DELETION_SUCCESSFUL : DELETION_FAILED;
	}

	@PostMapping("/account/register")
	public @ResponseBody ClientMessage createUser(@RequestBody User user) {
		int code = uservice.createUser(user);
		switch (code) {
		case 1:
			return CREATION_SUCCESSFUL;
		case 0:
			return CREATION_FAILED;
		case -2:
			return USERNAME_ALREADY_EXISTS;
		case -3:
			return EMAIL_ALREADY_EXISTS;
		}

		return null;
	}

	@PostMapping("/login")
	public @ResponseBody User authenticateLogin(@RequestBody String username, @RequestBody String password) {
		return uservice.login(username, password);
	}
}
