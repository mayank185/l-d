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
public class AssignmentQuality extends Auditable<Long> {

	private String quality;

	private Boolean isActive;

	private UUID uuid = UUID.randomUUID();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany(cascade = { CascadeType.ALL }, orphanRemoval = true)
	@JoinColumn(name = "assignment_quality_id")
	private List<UserGoalClaim> userGoalClaimList;

	public void setId(Long id) {
		this.id = id;
	}

	public void setUserGoalClaimList(List<UserGoalClaim> userGoalClaimList) {
		this.userGoalClaimList = userGoalClaimList;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	public Long getId() {
		return id;
	}

	public List<UserGoalClaim> getUserGoalClaimList() {
		return userGoalClaimList;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public UUID getUuid() {
		return uuid;
	}

	public String getQuality() {
		return quality;
	}
}
