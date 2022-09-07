package com.tristan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tristan.models.Application;

@Repository
@Transactional
public interface ApplicationRepository extends JpaRepository<Application, Long> {
	@Query(value="SELECT * FROM applications where application_id=?1", nativeQuery = true)
	public Application findById(int id);
}
