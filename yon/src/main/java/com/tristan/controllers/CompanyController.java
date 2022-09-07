package com.tristan.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.tristan.bodies.NewCompanyRequest;
import com.tristan.models.ClientMessage;
import com.tristan.models.Company;
import com.tristan.models.Place;
import com.tristan.services.CompanyService;

import static com.tristan.util.ClientMessageUtil.*;

@RestController
public class CompanyController {

	@Autowired
	private CompanyService cservice;
	
	// This class allows us to collect a company and a place in one request body
	static class CompanyAndPlace {
		private Company company;
		private Place place;
		public Company getCompany() { return this.company; }
		public Place getPlace() { return this.place; }
	}
	
	// Creates a company which references the provided place in its foreign key.
	// If the provided place does not exist it is added to the places table before
	// the company is created. If no place is provided the foreign key is left null.
	@PostMapping("/company")
	public @ResponseBody ClientMessage createCompany(@RequestBody NewCompanyRequest ncr) {
		int code = cservice.createCompany(ncr.getCompany(), ncr.getPlace());
		switch (code) {
		case 1:
			return CREATION_SUCCESSFUL;
		case 0:
			return CREATION_FAILED;
		case -1:
			return COMPANY_NAME_ALREADY_EXISTS;
		}
		return null;
	}
	
	@DeleteMapping("/company")
	public @ResponseBody ClientMessage deleteCompany(@RequestBody Company company) {
		return cservice.deleteCompany(company) ? DELETION_SUCCESSFUL : DELETION_FAILED ;
	}
}
