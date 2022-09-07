package com.tristan.services;

import com.tristan.models.Company;
import com.tristan.models.Place;

public interface CompanyService {
	int createCompany(Company company, Place place);
	boolean deleteCompany(Company company);
}
