package com.metacube.learninganddevelopment.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

	@OneToMany(cascade = { CascadeType.ALL }, orphanRemoval = true)
	@JoinColumn(name = "quarter_id")
	private List<UserGoal> userGoalList;

	public void setId(Long id) {
		this.id = id;
	}

	public void setYear(Long year) {
		this.year = year;
	}

	public void setUserGoalList(List<UserGoal> userGoalList) {
		this.userGoalList = userGoalList;
	}

	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Long getId() {
		return id;
	}

	public Long getYear() {
		return year;
	}

	public List<UserGoal> getUserGoalList() {
		return userGoalList;
	}

	public String getQuarter() {
		return quarter;
	}

	public UUID getUuid() {
		return uuid;
	}

	public Boolean getIsActive() {
		return isActive;
	}
}
