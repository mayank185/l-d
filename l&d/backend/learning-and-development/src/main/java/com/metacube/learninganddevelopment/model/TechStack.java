package com.metacube.learninganddevelopment.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

	@OneToMany(cascade = { CascadeType.ALL }, orphanRemoval = true)
	@JoinColumn(name = "tech_stack_id")
	private List<Goal> goalList;

	@Enumerated(EnumType.STRING)
	@Type(type = "com.metacube.learninganddevelopment.model.SQLEnumType")
	private TechStackStatus status;

	public void setStatus(TechStackStatus status) {
		this.status = status;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public void setGoalList(List<Goal> goalList) {
		this.goalList = goalList;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TechStackStatus getStatus() {
		return status;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public String getDescription() {
		return description;
	}

	public String getName() {
		return name;
	}

	public Long getOrgId() {
		return orgId;
	}

	public List<Goal> getGoalList() {
		return goalList;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public UUID getUuid() {
		return uuid;
	}

	public Long getId() {
		return id;
	}
}
