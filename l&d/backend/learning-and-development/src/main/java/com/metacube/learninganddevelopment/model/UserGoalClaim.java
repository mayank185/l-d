package com.metacube.learninganddevelopment.model;

import com.metacube.learninganddevelopment.model.UserGoalEvaluation;

import javax.persistence.ManyToOne;

import com.metacube.learninganddevelopment.model.AssignmentQuality;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Id;

import com.metacube.learninganddevelopment.model.UserGoal;

import java.sql.Timestamp;

import java.util.UUID;

import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;

import javax.persistence.Entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class UserGoalClaim {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private UUID uuid;

	private Double claimedCredits;

	private String chaptersCompleted;

	private String assignmentLink;

	private Double timeSpentMins;

	private String comment;

	private String feedback;

	private Long createdBy;

	private Timestamp creationDate;

	private Long lastModifiedBy;

	private Timestamp lastModifiedDate;

	private Boolean isActive;

	@OneToOne
	@JoinColumn(name = "user_goal_id")
	private UserGoal userGoal;

	@ManyToOne
	@JoinColumn(name = "assignment_quality_id")
	private AssignmentQuality assignmentQuality;

	@OneToOne(mappedBy = "userGoalClaim")
	@JsonIgnore
	private UserGoalEvaluation userGoalEvaluation;

	public void setId(Long id) {
		this.id = id;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public void setClaimedCredits(Double claimedCredits) {
		this.claimedCredits = claimedCredits;
	}

	public void setChaptersCompleted(String chaptersCompleted) {
		this.chaptersCompleted = chaptersCompleted;
	}

	public void setAssignmentLink(String assignmentLink) {
		this.assignmentLink = assignmentLink;
	}

	public void setTimeSpentMins(Double timeSpentMins) {
		this.timeSpentMins = timeSpentMins;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
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

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public void setUserGoal(UserGoal userGoal) {
		this.userGoal = userGoal;
	}

	public void setAssignmentQuality(AssignmentQuality assignmentQuality) {
		this.assignmentQuality = assignmentQuality;
	}

	public void setUserGoalEvaluation(UserGoalEvaluation userGoalEvaluation) {
		this.userGoalEvaluation = userGoalEvaluation;
	}

	public Long getId() {
		return id;
	}

	public UUID getUuid() {
		return uuid;
	}

	public Double getClaimedCredits() {
		return claimedCredits;
	}

	public String getChaptersCompleted() {
		return chaptersCompleted;
	}

	public String getAssignmentLink() {
		return assignmentLink;
	}

	public Double getTimeSpentMins() {
		return timeSpentMins;
	}

	public String getComment() {
		return comment;
	}

	public String getFeedback() {
		return feedback;
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

	public Boolean getIsActive() {
		return isActive;
	}

	public UserGoal getUserGoal() {
		return userGoal;
	}

	public AssignmentQuality getAssignmentQuality() {
		return assignmentQuality;
	}

	public UserGoalEvaluation getUserGoalEvaluation() {
		return userGoalEvaluation;
	}
}
