package com.tristan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tristan.models.JobListing;
import com.tristan.models.Place;
import com.tristan.repositories.JobListingRepository;
import com.tristan.repositories.PlaceRepository;

@Service
@Transactional
public class JobListingServiceImpl implements JobListingService {
	
	@Autowired
	private JobListingRepository jlrepo;
	
	@Autowired
	private PlaceRepository prepo;
	
	public JobListingServiceImpl(JobListingRepository dao) {
		this.jlrepo = dao;
	}
	
	@Override
	public boolean createListing(JobListing listing, Place place) {
		if (place != null) {
			// If the given place does not exist, add it to the places table, else read it
			// from the table.
			if (!prepo.existsByCityAndStateAndCountry(place.getCity(), place.getState(), place.getCountry())) {
				long placeKey = prepo.save(place).getId();
				if (placeKey < 1) {
					return false;
				}
			} else {
				place = prepo.getByCityAndStateAndCountry(place.getCity(), place.getState(), place.getCountry());
			}

			// The listings place has to be assigned or it will be null.
			listing.setPlace(place);
		}
		
		long listingKey = jlrepo.save(listing).getId();
		return (listingKey > 0);
	}

	@Override
	public boolean deleteListing(JobListing listing) {
		jlrepo.deleteById(listing.getId());
		return true;
	}
}
