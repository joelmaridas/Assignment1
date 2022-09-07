package com.tristan.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
@Table(name="applications")
public class Application {
	
	@Column(name="application_id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@JoinColumn(name="applicant_id", referencedColumnName="user_id", nullable = false)
	@ManyToOne
	private User applicant;
	
	@Column(name="resume", nullable = true)
	@Lob
	private byte[] resume;
	
	@JoinColumn(name="listing_id", referencedColumnName="listing_id", nullable = false)
	@ManyToOne
	private JobListing listing;
	
	public Application() {}
	
	public Application(User applicant, byte[] resume) {
		this.applicant = applicant;
		this.resume = resume;
	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getApplicant() {
		return applicant;
	}

	public void setApplicant(User applicant) {
		this.applicant = applicant;
	}

	public byte[] getResume() {
		return resume;
	}

	public void setResume(byte[] resume) {
		this.resume = resume;
	}

	public JobListing getListing() {
		return listing;
	}

	public void setListing(JobListing listing) {
		this.listing = listing;
	}

}
