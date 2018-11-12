package com.metacube.learninganddevelopment.model;

import java.util.UUID;

import javax.persistence.CascadeType;
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
public class UserGoalClaim extends Auditable<Long> {

	private String comment;

	private String feedback;

	private Boolean isActive;

	private Double timeSpentMins;

	private Double claimedCredits;

	private String assignmentLink;

	private String chaptersCompleted;

	private UUID uuid = UUID.randomUUID();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	@JoinColumn(name = "user_goal_id")
	@JsonIgnore
	private UserGoal userGoal;

	@OneToOne(mappedBy = "userGoalClaim", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private UserGoalEvaluation userGoalEvaluation;

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public void setClaimedCredits(Double claimedCredits) {
		this.claimedCredits = claimedCredits;
	}

	public void setUserGoal(UserGoal userGoal) {
		this.userGoal = userGoal;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setChaptersCompleted(String chaptersCompleted) {
		this.chaptersCompleted = chaptersCompleted;
	}

	public void setAssignmentLink(String assignmentLink) {
		this.assignmentLink = assignmentLink;
	}

	public void setUserGoalEvaluation(UserGoalEvaluation userGoalEvaluation) {
		this.userGoalEvaluation = userGoalEvaluation;
	}

	public void setTimeSpentMins(Double timeSpentMins) {
		this.timeSpentMins = timeSpentMins;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getFeedback() {
		return feedback;
	}

	public Double getClaimedCredits() {
		return claimedCredits;
	}

	public UserGoal getUserGoal() {
		return userGoal;
	}

	public String getComment() {
		return comment;
	}

	public String getChaptersCompleted() {
		return chaptersCompleted;
	}

	public String getAssignmentLink() {
		return assignmentLink;
	}

	public UserGoalEvaluation getUserGoalEvaluation() {
		return userGoalEvaluation;
	}

	public Double getTimeSpentMins() {
		return timeSpentMins;
	}

	public Long getId() {
		return id;
	}

	public UUID getUuid() {
		return uuid;
	}

	public Boolean getIsActive() {
		return isActive;
	}
}
