package com.tristan.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Id;

@Entity
@Table(name="user_roles", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_role"})})
public class UserRole {
	
	@Column(name="user_role_id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="user_role", nullable = false)
	private String role;

	public UserRole() {}
	
	public UserRole(String role) {
		this.role = role;
	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}
