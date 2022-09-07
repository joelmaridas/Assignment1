package com.tristan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tristan.models.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

	User getByUsernameAndPassword(String username, String password);

	boolean existsByEmail(String email);

	boolean existsByUsername(String username);

}
