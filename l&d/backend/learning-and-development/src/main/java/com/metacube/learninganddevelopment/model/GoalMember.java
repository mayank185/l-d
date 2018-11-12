package com.metacube.learninganddevelopment.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

	public void setRole(GoalRole role) {
		this.role = role;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public GoalRole getRole() {
		return role;
	}

	public Long getUserId() {
		return userId;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public Long getId() {
		return id;
	}
}
