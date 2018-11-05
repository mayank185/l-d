package com.metacube.learninganddevelopment.model;

import javax.persistence.GenerationType;

import java.sql.Timestamp;

import javax.persistence.Id;

import javax.persistence.GeneratedValue;

import javax.persistence.Entity;

@Entity
public class GoalMember {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Long userId;

	private String role;

	private Long createdBy;

	private Long lastModifiedBy;

	private Timestamp createdDate;

	private Timestamp lastModifiedDate;

	private Boolean isActive;

	private String unique;

	public void setId(Long id) {
		this.id = id;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public void setLastModifiedBy(Long lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
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

	public Long getUserId() {
		return userId;
	}

	public String getRole() {
		return role;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public Long getLastModifiedBy() {
		return lastModifiedBy;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
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
