package com.tristan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tristan.bodies.NewJobListingRequest;
import com.tristan.models.ClientMessage;
import com.tristan.models.JobListing;
import com.tristan.models.ListingStatus;
import com.tristan.models.Place;
import com.tristan.services.JobListingService;
import com.tristan.services.ListingStatusService;

import static com.tristan.util.ClientMessageUtil.*;

@RestController
public class JobListingController {

	@Autowired
	private JobListingService jlservice;
	
	@Autowired
	private ListingStatusService lsservice;
		
	@PostMapping("/Listing")
	public @ResponseBody ClientMessage createListing(@RequestBody NewJobListingRequest njlr) {
		return jlservice.createListing(njlr.getListing(), njlr.getPlace()) ? CREATION_SUCCESSFUL : CREATION_FAILED ;
	}
	
	@DeleteMapping("/Listing")
	public @ResponseBody ClientMessage deleteListing(@RequestBody JobListing listing) {
		return jlservice.deleteListing(listing) ? DELETION_SUCCESSFUL : DELETION_FAILED;
	}
	
	@PostMapping("/ListingStatus")
	public @ResponseBody ClientMessage createListingStatus(@RequestBody ListingStatus status) {
		int code = lsservice.createStatus(status);
		switch (code) {
		case 1: 
			return CREATION_SUCCESSFUL;
		case 0: 
			return CREATION_FAILED;
		case -1:
			return ENTITY_ALREADY_EXISTS;
		}
		return null;
	}
	
	@DeleteMapping("/ListingStatus")
	public @ResponseBody ClientMessage deleteListingStatus(@RequestBody ListingStatus status) {
		return lsservice.deleteStatus(status) ? DELETION_SUCCESSFUL : DELETION_FAILED ;
	}
}
