package com.tristan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tristan.repositories.ApplicationRepository;

@Service
@Transactional
public class ApplicationServiceImpl implements ApplicationService {
	
	@Autowired
	private ApplicationRepository arrepo;
	
	public ApplicationServiceImpl(ApplicationRepository dao) {
		this.arrepo = dao;
	}
	
	@Override
	public boolean createApplication() {
		// TODO Auto-generated method stub
		return false;
	}

}
