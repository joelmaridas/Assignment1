package com.tristan.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
@Table(name="users", uniqueConstraints = {@UniqueConstraint(columnNames = {"email", "username"})})
public class User {
	
	@Column(name="user_id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="username" , nullable=false)
	private String username;
	
	@Column(name="firstname", nullable=false)
	private String firstname;
	
	@Column(name="lastname" , nullable=false)
	private String lastname;
	
	@Column(name="email"    , nullable = false)
	private String email;
	
	@Column(name="password" , nullable = false)
	private String password;
	
	@JoinColumn(name="user_role_id", referencedColumnName="user_role_id", nullable=false)
	@ManyToOne
	private UserRole role;
	
	@JoinColumn(name="company_id", referencedColumnName="company_id", nullable=true)
	@ManyToOne
	private Company company;
	
	public User() {}

	public User(String username, String firstname, String lastname, String email, String password, Company company, UserRole role) {
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.role = role;
		this.company = company;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
	
}
