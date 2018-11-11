package com.metacube.learninganddevelopment.model;

import javax.persistence.GenerationType;

import javax.persistence.GeneratedValue;

import javax.persistence.EnumType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.metacube.learninganddevelopment.model.RoleEnum;

import javax.persistence.Entity;

import javax.persistence.Enumerated;

import org.hibernate.annotations.Type;

import javax.persistence.Id;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class UserRole extends Auditable<Long> {

	private Boolean isActive;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	@Type(type = "com.metacube.learninganddevelopment.model.SQLEnumType")
	private RoleEnum role;

	public void setRole(RoleEnum role) {
		this.role = role;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public RoleEnum getRole() {
		return role;
	}

	public Long getId() {
		return id;
	}

	public Boolean getIsActive() {
		return isActive;
	}
}
