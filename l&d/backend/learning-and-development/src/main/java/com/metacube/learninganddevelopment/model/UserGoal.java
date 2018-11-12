package com.metacube.learninganddevelopment.model;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

	@OneToOne(mappedBy = "userGoal", cascade = { CascadeType.ALL }, orphanRemoval = true)
	@JoinColumn(name = "user_goal_id")
	private UserGoalClaim userGoalClaim;

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setStatus(UserGoalStatusEnum status) {
		this.status = status;
	}

	public void setUserGoalClaim(UserGoalClaim userGoalClaim) {
		this.userGoalClaim = userGoalClaim;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public void setApprovedBy(Long approvedBy) {
		this.approvedBy = approvedBy;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UUID getUuid() {
		return uuid;
	}

	public Long getUserId() {
		return userId;
	}

	public UserGoalStatusEnum getStatus() {
		return status;
	}

	public UserGoalClaim getUserGoalClaim() {
		return userGoalClaim;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public Long getApprovedBy() {
		return approvedBy;
	}

	public Long getId() {
		return id;
	}
}
