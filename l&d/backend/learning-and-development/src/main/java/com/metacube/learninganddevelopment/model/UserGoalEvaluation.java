package com.metacube.learninganddevelopment.model;

import javax.persistence.Id;

import com.metacube.learninganddevelopment.model.UserGoalClaim;

import java.sql.Timestamp;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;

import javax.persistence.OneToOne;

import javax.persistence.Entity;

@Entity
public class UserGoalEvaluation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Double approvedCredit;

	private String feedback;

	private Long evaluatedBy;

	private Long createdBy;

	private Timestamp createdDate;

	private Long lastModifiedBy;

	private Timestamp lastModifiedDate;

	private Boolean isActive;

	@OneToOne
	private UserGoalClaim userGoalClaim;

	public void setId(Long id) {
		this.id = id;
	}

	public void setApprovedCredit(Double approvedCredit) {
		this.approvedCredit = approvedCredit;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public void setEvaluatedBy(Long evaluatedBy) {
		this.evaluatedBy = evaluatedBy;
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

	public void setUserGoalClaim(UserGoalClaim userGoalClaim) {
		this.userGoalClaim = userGoalClaim;
	}

	public Long getId() {
		return id;
	}

	public Double getApprovedCredit() {
		return approvedCredit;
	}

	public String getFeedback() {
		return feedback;
	}

	public Long getEvaluatedBy() {
		return evaluatedBy;
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

	public UserGoalClaim getUserGoalClaim() {
		return userGoalClaim;
	}
}
