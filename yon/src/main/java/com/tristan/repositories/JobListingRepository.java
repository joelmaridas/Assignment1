package com.tristan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tristan.models.JobListing;

@Repository
@Transactional
public interface JobListingRepository extends JpaRepository<JobListing, Long> {

}
