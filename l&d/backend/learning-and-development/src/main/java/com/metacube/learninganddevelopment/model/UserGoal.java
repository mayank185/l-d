package com.metacube.learninganddevelopment.model;

import javax.persistence.GenerationType;

import java.util.UUID;

import javax.persistence.GeneratedValue;

import com.metacube.learninganddevelopment.model.UserGoalStatusEnum;

import javax.persistence.EnumType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;

import java.util.Date;

import javax.persistence.Id;

import com.metacube.learninganddevelopment.model.UserGoalClaim;

import com.metacube.learninganddevelopment.model.GoalQuarter;

import javax.persistence.Enumerated;

import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;

import javax.persistence.OneToOne;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class UserGoal extends Auditable<Long> {

	private Long userId;

	private Long approvedBy;

	private Boolean isDeleted;

	private UUID uuid = UUID.randomUUID();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	@Type(type = "com.metacube.learninganddevelopment.model.SQLEnumType")
	private UserGoalStatusEnum status;

	@OneToOne(mappedBy = "userGoal")
	@Enumerated(EnumType.STRING)
	@Type(type = "com.metacube.learninganddevelopment.model.SQLEnumType")
	private UserGoalClaim userGoalClaim;

	@ManyToOne
	@JoinColumn(name = "quarter_id")
	@Enumerated(EnumType.STRING)
	@Type(type = "com.metacube.learninganddevelopment.model.SQLEnumType")
	private GoalQuarter goalQuarter;

	public void setStatus(UserGoalStatusEnum status) {
		this.status = status;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public void setUserGoalClaim(UserGoalClaim userGoalClaim) {
		this.userGoalClaim = userGoalClaim;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setApprovedBy(Long approvedBy) {
		this.approvedBy = approvedBy;
	}

	public void setGoalQuarter(GoalQuarter goalQuarter) {
		this.goalQuarter = goalQuarter;
	}

	public UserGoalStatusEnum getStatus() {
		return status;
	}

	public UUID getUuid() {
		return uuid;
	}

	public UserGoalClaim getUserGoalClaim() {
		return userGoalClaim;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public Long getUserId() {
		return userId;
	}

	public Long getId() {
		return id;
	}

	public Long getApprovedBy() {
		return approvedBy;
	}

	public GoalQuarter getGoalQuarter() {
		return goalQuarter;
	}
}
