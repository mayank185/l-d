package com.metacube.learninganddevelopment.model;

import javax.persistence.Id;

import java.sql.Timestamp;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;

import java.util.UUID;

import com.metacube.learninganddevelopment.model.UserGoal;

import java.util.List;

import javax.persistence.OneToMany;

import javax.persistence.Entity;

@Entity
public class GoalQuarter {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private UUID uuid;

	private Long year;

	private String quarter;

	private Long lastModifiedBy;

	private Timestamp lastModifiedDate;

	private Boolean isActive;

	private String constraint;

	@OneToMany
	private List<UserGoal> userGoalList;

	public void setId(Long id) {
		this.id = id;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public void setYear(Long year) {
		this.year = year;
	}

	public void setQuarter(String quarter) {
		this.quarter = quarter;
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

	public void setConstraint(String constraint) {
		this.constraint = constraint;
	}

	public void setUserGoalList(List<UserGoal> userGoalList) {
		this.userGoalList = userGoalList;
	}

	public Long getId() {
		return id;
	}

	public UUID getUuid() {
		return uuid;
	}

	public Long getYear() {
		return year;
	}

	public String getQuarter() {
		return quarter;
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

	public String getConstraint() {
		return constraint;
	}

	public List<UserGoal> getUserGoalList() {
		return userGoalList;
	}
}
