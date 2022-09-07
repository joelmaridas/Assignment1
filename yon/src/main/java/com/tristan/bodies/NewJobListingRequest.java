package com.tristan.bodies;

import com.tristan.models.JobListing;
import com.tristan.models.Place;

public class NewJobListingRequest {
	private JobListing listing;
	private Place place;
	public JobListing getListing() { return listing; }
	public Place getPlace() { return place; }
}