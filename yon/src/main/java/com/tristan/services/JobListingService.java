package com.tristan.services;

import com.tristan.models.JobListing;
import com.tristan.models.Place;

public interface JobListingService {
	boolean createListing(JobListing listing, Place place);

	boolean deleteListing(JobListing listing);
}
