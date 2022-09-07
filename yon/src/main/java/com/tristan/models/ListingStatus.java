package com.tristan.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Id;

@Entity
@Table(name="listing_status", uniqueConstraints = {@UniqueConstraint(columnNames = {"status"})})
public class ListingStatus {
	
	@Column(name="status_id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="status", nullable = false)
	private String status;
	
	public ListingStatus() {}
	
	public ListingStatus(String status) {
		this.status = status;
	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
