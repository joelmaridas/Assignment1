package com.tristan.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
@Table(name="job_listing")
public class JobListing {
	
	@Column(name="listing_id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="job_description", nullable = false)
	private String description;
	
	@JoinColumn(name="place_id", referencedColumnName="place_id", nullable = false)
	@ManyToOne
	private Place place;
	
	@JoinColumn(name="company_id", referencedColumnName="company_id", nullable = false)
	@ManyToOne
	private Company company;
	
	@JoinColumn(name="status_id", referencedColumnName="status_id", nullable = false)
	@ManyToOne
	private ListingStatus status;
	
	public JobListing() {}
	
	public JobListing(String description, Place place, Company company) {
		this.description = description;
		this.place = place;
		this.company = company;
	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}
