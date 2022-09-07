package com.tristan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tristan.models.ListingStatus;

@Repository
@Transactional
public interface ListingStatusRepository extends JpaRepository<ListingStatus, Long> {
	boolean existsByStatus(String status);
	boolean deleteByStatus(String status);
}
