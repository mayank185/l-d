package com.metacube.learninganddevelopment.model;

import javax.persistence.GenerationType;

import javax.persistence.GeneratedValue;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.EnumType;

import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;

import com.metacube.learninganddevelopment.model.UserGoalClaim;

import javax.persistence.Enumerated;

import javax.persistence.JoinColumn;

import org.hibernate.annotations.Type;

import javax.persistence.Id;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class UserGoalEvaluation extends Auditable<Long> {

	private String feedback;

	private Long evaluatedBy;

	private Boolean isActive;

	private Double approvedCredit;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	@JoinColumn(name = "user_goal_claimed_id")
	@JsonIgnore
	@Enumerated(EnumType.STRING)
	@Type(type = "com.metacube.learninganddevelopment.model.SQLEnumType")
	private UserGoalClaim userGoalClaim;

	public void setId(Long id) {
		this.id = id;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public void setApprovedCredit(Double approvedCredit) {
		this.approvedCredit = approvedCredit;
	}

	public void setEvaluatedBy(Long evaluatedBy) {
		this.evaluatedBy = evaluatedBy;
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

	public String getFeedback() {
		return feedback;
	}

	public Double getApprovedCredit() {
		return approvedCredit;
	}

	public Long getEvaluatedBy() {
		return evaluatedBy;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public UserGoalClaim getUserGoalClaim() {
		return userGoalClaim;
	}
}
