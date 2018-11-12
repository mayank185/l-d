package com.metacube.learninganddevelopment.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class UserGoalEvaluation extends Auditable<Long> {

	private String feedback;

	private Boolean isActive;

	private Long evaluatedBy;

	private Double approvedCredit;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	@JoinColumn(name = "user_goal_claimed_id")
	@JsonIgnore
	private UserGoalClaim userGoalClaim;

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public void setUserGoalClaim(UserGoalClaim userGoalClaim) {
		this.userGoalClaim = userGoalClaim;
	}

	public void setApprovedCredit(Double approvedCredit) {
		this.approvedCredit = approvedCredit;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public void setEvaluatedBy(Long evaluatedBy) {
		this.evaluatedBy = evaluatedBy;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFeedback() {
		return feedback;
	}

	public UserGoalClaim getUserGoalClaim() {
		return userGoalClaim;
	}

	public Double getApprovedCredit() {
		return approvedCredit;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public Long getEvaluatedBy() {
		return evaluatedBy;
	}

	public Long getId() {
		return id;
	}
}
