package com.metacube.learninganddevelopment.model;

import com.metacube.learninganddevelopment.model.GoalQuarter;

import javax.persistence.ManyToOne;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Id;

import java.sql.Timestamp;

import java.util.UUID;

import com.metacube.learninganddevelopment.model.UserGoalClaim;

import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;

import javax.persistence.Entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class UserGoal {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private UUID uuid;

	private Long userId;

	private String status;

	private Boolean isDeleted;

	private Long approvedBy;

	private Long createdBy;

	private Timestamp creationDate;

	private Long lastModifiedBy;

	private Timestamp lastModifiedDate;

	@ManyToOne
	@JoinColumn(name = "quarter_id")
	private GoalQuarter goalQuarter;

	@OneToOne(mappedBy = "userGoal")
	@JsonIgnore
	private UserGoalClaim userGoalClaim;

	public void setId(Long id) {
		this.id = id;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public void setApprovedBy(Long approvedBy) {
		this.approvedBy = approvedBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public void setLastModifiedBy(Long lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public void setLastModifiedDate(Timestamp lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public void setGoalQuarter(GoalQuarter goalQuarter) {
		this.goalQuarter = goalQuarter;
	}

	public void setUserGoalClaim(UserGoalClaim userGoalClaim) {
		this.userGoalClaim = userGoalClaim;
	}

	public Long getId() {
		return id;
	}

	public UUID getUuid() {
		return uuid;
	}

	public Long getUserId() {
		return userId;
	}

	public String getStatus() {
		return status;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public Long getApprovedBy() {
		return approvedBy;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public Long getLastModifiedBy() {
		return lastModifiedBy;
	}

	public Timestamp getLastModifiedDate() {
		return lastModifiedDate;
	}

	public GoalQuarter getGoalQuarter() {
		return goalQuarter;
	}

	public UserGoalClaim getUserGoalClaim() {
		return userGoalClaim;
	}
}
