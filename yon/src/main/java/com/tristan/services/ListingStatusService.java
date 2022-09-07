package com.tristan.services;

import com.tristan.models.ListingStatus;

public interface ListingStatusService {
	int createStatus(ListingStatus status);
	boolean deleteStatus(ListingStatus status);
}
