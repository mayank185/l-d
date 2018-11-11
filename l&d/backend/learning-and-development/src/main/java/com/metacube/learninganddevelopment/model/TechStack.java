package com.metacube.learninganddevelopment.model;

import javax.persistence.GenerationType;

import java.util.UUID;

import javax.persistence.GeneratedValue;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.EnumType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;

import com.metacube.learninganddevelopment.model.Goal;

import javax.persistence.Enumerated;

import javax.persistence.JoinColumn;

import com.metacube.learninganddevelopment.model.TechStackStatus;

import org.hibernate.annotations.Type;

import javax.persistence.Id;

import javax.persistence.OneToMany;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class TechStack extends Auditable<Long> {

	private Long orgId;

	private String name;

	private Long ownerId;

	private Boolean isActive;

	private String description;

	private UUID uuid = UUID.randomUUID();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany
	@JoinColumn(name = "tech_stack_id")
	@JsonIgnore
	private List<Goal> goalList;

	@Enumerated(EnumType.STRING)
	@Type(type = "com.metacube.learninganddevelopment.model.SQLEnumType")
	private TechStackStatus status;

	public void setStatus(TechStackStatus status) {
		this.status = status;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public void setGoalList(List<Goal> goalList) {
		this.goalList = goalList;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public TechStackStatus getStatus() {
		return status;
	}

	public UUID getUuid() {
		return uuid;
	}

	public String getName() {
		return name;
	}

	public Long getId() {
		return id;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public String getDescription() {
		return description;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public List<Goal> getGoalList() {
		return goalList;
	}

	public Long getOrgId() {
		return orgId;
	}
}
