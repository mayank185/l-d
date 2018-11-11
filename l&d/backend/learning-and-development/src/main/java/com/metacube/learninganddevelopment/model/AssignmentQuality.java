package com.metacube.learninganddevelopment.model;

import javax.persistence.GenerationType;

import java.util.UUID;

import javax.persistence.GeneratedValue;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;

import com.metacube.learninganddevelopment.model.UserGoalClaim;

import javax.persistence.JoinColumn;

import javax.persistence.Id;

import javax.persistence.OneToMany;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class AssignmentQuality extends Auditable<Long> {

	private String quality;

	private Boolean isActive;

	private UUID uuid = UUID.randomUUID();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany
	@JoinColumn(name = "assignment_quality_id")
	@JsonIgnore
	private List<UserGoalClaim> userGoalClaimList;

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	public void setUserGoalClaimList(List<UserGoalClaim> userGoalClaimList) {
		this.userGoalClaimList = userGoalClaimList;
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

	public String getQuality() {
		return quality;
	}

	public List<UserGoalClaim> getUserGoalClaimList() {
		return userGoalClaimList;
	}

	public Boolean getIsActive() {
		return isActive;
	}
}
