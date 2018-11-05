package com.metacube.learninganddevelopment.model;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.OneToMany;

import javax.persistence.Id;

import java.sql.Timestamp;

import com.metacube.learninganddevelopment.model.Goal;

import java.util.UUID;

import javax.persistence.JoinColumn;

import java.util.List;

import javax.persistence.Entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class CreditPoint {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private UUID uuid;

	private Float points;

	private Long lastModifiedBy;

	private Timestamp lastModifiedDate;

	private Boolean isActive;

	@OneToMany
	@JoinColumn(name = "credit_point_id")
	@JsonIgnore
	private List<Goal> goalList;

	public void setId(Long id) {
		this.id = id;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public void setPoints(Float points) {
		this.points = points;
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

	public void setGoalList(List<Goal> goalList) {
		this.goalList = goalList;
	}

	public Long getId() {
		return id;
	}

	public UUID getUuid() {
		return uuid;
	}

	public Float getPoints() {
		return points;
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

	public List<Goal> getGoalList() {
		return goalList;
	}
}
