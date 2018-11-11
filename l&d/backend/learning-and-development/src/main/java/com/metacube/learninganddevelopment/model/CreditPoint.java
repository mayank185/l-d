package com.metacube.learninganddevelopment.model;

import javax.persistence.GenerationType;

import java.util.UUID;

import javax.persistence.GeneratedValue;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;

import com.metacube.learninganddevelopment.model.Goal;

import javax.persistence.JoinColumn;

import javax.persistence.Id;

import javax.persistence.OneToMany;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class CreditPoint extends Auditable<Long> {

	private Float points;

	private Boolean isActive;

	private UUID uuid = UUID.randomUUID();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany
	@JoinColumn(name = "credit_point_id")
	@JsonIgnore
	private List<Goal> goalList;

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setGoalList(List<Goal> goalList) {
		this.goalList = goalList;
	}

	public void setPoints(Float points) {
		this.points = points;
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

	public List<Goal> getGoalList() {
		return goalList;
	}

	public Float getPoints() {
		return points;
	}

	public Boolean getIsActive() {
		return isActive;
	}
}
