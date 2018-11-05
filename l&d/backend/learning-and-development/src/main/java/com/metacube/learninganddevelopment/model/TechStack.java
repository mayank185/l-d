package com.metacube.learninganddevelopment.model;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.OneToMany;

import javax.persistence.Id;

import java.sql.Timestamp;

import com.metacube.learninganddevelopment.model.Goal;

import java.util.UUID;

import javax.persistence.JoinColumn;

import java.util.List;

import javax.persistence.Entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class TechStack {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private UUID uuid;

	private Long orgId;

	private String name;

	private String description;

	private Long ownerId;

	private String status;

	private Long createdBy;

	private Timestamp createdDate;

	private Long lastModifiedBy;

	private Timestamp lastModifiedDate;

	private Boolean isActive;

	@OneToMany
	@JoinColumn(name = "tech_stack_id")
	@JsonIgnore
	private List<Goal> goalList;

	public void setId(Long id) {
		this.id = id;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
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

	public void setGoalList(List<Goal> goalList) {
		this.goalList = goalList;
	}

	public Long getId() {
		return id;
	}

	public UUID getUuid() {
		return uuid;
	}

	public Long getOrgId() {
		return orgId;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public String getStatus() {
		return status;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
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

	public List<Goal> getGoalList() {
		return goalList;
	}
}
