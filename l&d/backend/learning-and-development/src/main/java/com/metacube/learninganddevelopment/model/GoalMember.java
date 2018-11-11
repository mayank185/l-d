package com.metacube.learninganddevelopment.model;

import javax.persistence.GenerationType;

import javax.persistence.GeneratedValue;

import javax.persistence.EnumType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;

import javax.persistence.Enumerated;

import com.metacube.learninganddevelopment.model.GoalRole;

import org.hibernate.annotations.Type;

import javax.persistence.Id;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class GoalMember extends Auditable<Long> {

	private Long userId;

	private Boolean isActive;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	@Type(type = "com.metacube.learninganddevelopment.model.SQLEnumType")
	private GoalRole role;

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public void setRole(GoalRole role) {
		this.role = role;
	}

	public Long getUserId() {
		return userId;
	}

	public Long getId() {
		return id;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public GoalRole getRole() {
		return role;
	}
}
