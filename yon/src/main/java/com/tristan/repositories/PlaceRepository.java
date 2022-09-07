package com.tristan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tristan.models.Place;

@Repository
@Transactional
public interface PlaceRepository extends JpaRepository<Place, Long> {

	boolean existsByCityAndStateAndCountry(String city, String state, String country);

	Place getByCityAndStateAndCountry(String city, String state, String country);

}
