package com.tristan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tristan.models.UserRole;

@Repository
@Transactional
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
	boolean existsByRole(String role);
	void deleteByRole(String role);
}
