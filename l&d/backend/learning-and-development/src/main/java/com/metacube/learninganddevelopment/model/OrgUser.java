package com.metacube.learninganddevelopment.model;

import javax.persistence.GenerationType;

import javax.persistence.GeneratedValue;

import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class OrgUser extends Auditable<Long> {

	private String name;

	private String email;

	private Boolean isActive;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public void setName(String name) {
		this.name = name;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getName() {
		return name;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public Boolean getIsActive() {
		return isActive;
	}
}
