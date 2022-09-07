package com.tristan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tristan.models.Company;

@Repository
@Transactional
public interface CompanyRepository extends JpaRepository<Company, Long> {

	boolean existsByName(String name);

}
