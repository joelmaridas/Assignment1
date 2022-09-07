package com.tristan.bodies;

import com.tristan.models.Company;
import com.tristan.models.Place;

public class NewCompanyRequest {
	private Company company;
	private Place place;
	public Company getCompany() { return this.company; }
	public Place getPlace() { return this.place; }
}
