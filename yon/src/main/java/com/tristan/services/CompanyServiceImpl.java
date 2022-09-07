package com.tristan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tristan.models.Company;
import com.tristan.models.Place;
import com.tristan.repositories.CompanyRepository;
import com.tristan.repositories.PlaceRepository;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository crepo;

	@Autowired
	private PlaceRepository prepo;

	public CompanyServiceImpl(CompanyRepository dao) {
		this.crepo = dao;
	}

	@Override
	public int createCompany(Company company, Place place) {
		if (crepo.existsByName(company.getName())) {
			return -1;
		}

		if (place != null) {
			// If the given place does not exist, add it to the places table, else read it
			// from the table.
			if (!prepo.existsByCityAndStateAndCountry(place.getCity(), place.getState(), place.getCountry())) {
				long placeKey = prepo.save(place).getId();
				if (placeKey < 1) {
					return 0;
				}
			} else {
				place = prepo.getByCityAndStateAndCountry(place.getCity(), place.getState(), place.getCountry());
			}

			// Companies place has to be assigned or it will be null.
			company.setPlace(place);
		}

		// return 1 if creation successful else 0
		long companyKey = crepo.save(company).getId();
		return companyKey > 0 ? 1 : 0;
	}

	@Override
	public boolean deleteCompany(Company company) {
		crepo.deleteById(company.getId());
		return true;
	}
}
