package com.tristan.services;

import com.tristan.models.Place;

public interface PlaceService {
	int createPlace(Place place);

	boolean deletePlace(Place place);
}
