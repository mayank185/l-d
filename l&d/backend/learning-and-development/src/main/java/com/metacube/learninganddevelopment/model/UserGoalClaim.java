package com.metacube.learninganddevelopment.model;

import javax.persistence.GenerationType;

import com.metacube.learninganddevelopment.model.UserGoal;

import java.util.UUID;

import javax.persistence.GeneratedValue;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.metacube.learninganddevelopment.model.AssignmentQuality;

import javax.persistence.EnumType;

import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;

import java.util.Date;

import javax.persistence.Enumerated;

import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;

import javax.persistence.Id;

import com.metacube.learninganddevelopment.model.UserGoalEvaluation;

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
	@Enumerated(EnumType.STRING)
	@Type(type = "com.metacube.learninganddevelopment.model.SQLEnumType")
	private UserGoal userGoal;

	@OneToOne(mappedBy = "userGoalClaim")
	@Enumerated(EnumType.STRING)
	@Type(type = "com.metacube.learninganddevelopment.model.SQLEnumType")
	private UserGoalEvaluation userGoalEvaluation;

	@ManyToOne
	@JoinColumn(name = "assignment_quality_id")
	@Enumerated(EnumType.STRING)
	@Type(type = "com.metacube.learninganddevelopment.model.SQLEnumType")
	private AssignmentQuality assignmentQuality;

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public void setTimeSpentMins(Double timeSpentMins) {
		this.timeSpentMins = timeSpentMins;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUserGoal(UserGoal userGoal) {
		this.userGoal = userGoal;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public void setClaimedCredits(Double claimedCredits) {
		this.claimedCredits = claimedCredits;
	}

	public void setAssignmentLink(String assignmentLink) {
		this.assignmentLink = assignmentLink;
	}

	public void setChaptersCompleted(String chaptersCompleted) {
		this.chaptersCompleted = chaptersCompleted;
	}

	public void setUserGoalEvaluation(UserGoalEvaluation userGoalEvaluation) {
		this.userGoalEvaluation = userGoalEvaluation;
	}

	public void setAssignmentQuality(AssignmentQuality assignmentQuality) {
		this.assignmentQuality = assignmentQuality;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public String getComment() {
		return comment;
	}

	public UUID getUuid() {
		return uuid;
	}

	public Double getTimeSpentMins() {
		return timeSpentMins;
	}

	public Long getId() {
		return id;
	}

	public UserGoal getUserGoal() {
		return userGoal;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public Double getClaimedCredits() {
		return claimedCredits;
	}

	public String getAssignmentLink() {
		return assignmentLink;
	}

	public String getChaptersCompleted() {
		return chaptersCompleted;
	}

	public UserGoalEvaluation getUserGoalEvaluation() {
		return userGoalEvaluation;
	}

	public AssignmentQuality getAssignmentQuality() {
		return assignmentQuality;
	}

	public String getFeedback() {
		return feedback;
	}
}
