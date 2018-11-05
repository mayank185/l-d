package com.metacube.learninganddevelopment.model;

import javax.persistence.GenerationType;

import java.sql.Timestamp;

import javax.persistence.Id;

import javax.persistence.GeneratedValue;

import javax.persistence.Entity;

@Entity
public class GoalPrerequisite {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Long createdBy;

	private Timestamp createdDate;

	private Long lastModifiedBy;

	private Timestamp lastModifiedDate;

	private Boolean isActive;

	private String unique;

	public void setId(Long id) {
		this.id = id;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public void setLastModifiedBy(Long lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public void setLastModifiedDate(Timestamp lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public void setUnique(String unique) {
		this.unique = unique;
	}

	public Long getId() {
		return id;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public Long getLastModifiedBy() {
		return lastModifiedBy;
	}

	public Timestamp getLastModifiedDate() {
		return lastModifiedDate;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public String getUnique() {
		return unique;
	}
}
