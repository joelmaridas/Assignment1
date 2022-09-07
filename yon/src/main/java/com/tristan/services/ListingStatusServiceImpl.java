package com.tristan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tristan.models.ListingStatus;
import com.tristan.repositories.ListingStatusRepository;

@Service
@Transactional
public class ListingStatusServiceImpl implements ListingStatusService {
	
	@Autowired
	private ListingStatusRepository lsrepo;
	
	public ListingStatusServiceImpl(ListingStatusRepository dao) {
		this.lsrepo = dao;
	}

	@Override
	public int createStatus(ListingStatus status) {
		if (lsrepo.existsByStatus(status.getStatus())) {
			return -1;
		}
		
		// If creation is successful return 1 else 0
		long statusKey = lsrepo.save(status).getId();
		return (statusKey > 0) ? 1 : 0;
	}

	@Override
	public boolean deleteStatus(ListingStatus status) {
		lsrepo.deleteByStatus(status.getStatus());
		return true;
	}
}
