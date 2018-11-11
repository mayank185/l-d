package com.metacube.learninganddevelopment.model;

import javax.persistence.GenerationType;

import com.metacube.learninganddevelopment.model.UserGoal;

import java.util.UUID;

import javax.persistence.GeneratedValue;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;

import javax.persistence.JoinColumn;

import javax.persistence.Id;

import javax.persistence.OneToMany;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class GoalQuarter extends Auditable<Long> {

	private Long year;

	private String quarter;

	private Boolean isActive;

	private UUID uuid = UUID.randomUUID();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany
	@JoinColumn(name = "quarter_id")
	@JsonIgnore
	private List<UserGoal> userGoalList;

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setYear(Long year) {
		this.year = year;
	}

	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}

	public void setUserGoalList(List<UserGoal> userGoalList) {
		this.userGoalList = userGoalList;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public UUID getUuid() {
		return uuid;
	}

	public Long getId() {
		return id;
	}

	public Long getYear() {
		return year;
	}

	public String getQuarter() {
		return quarter;
	}

	public List<UserGoal> getUserGoalList() {
		return userGoalList;
	}

	public Boolean getIsActive() {
		return isActive;
	}
}
