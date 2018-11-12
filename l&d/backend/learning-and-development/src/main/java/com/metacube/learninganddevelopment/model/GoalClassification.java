package com.metacube.learninganddevelopment.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class GoalClassification extends Auditable<Long> {

	private Boolean isActive;

	private String classification;

	private UUID uuid = UUID.randomUUID();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany(cascade = { CascadeType.ALL }, orphanRemoval = true)
	@JoinColumn(name = "goal_classification_id")
	private List<Goal> goalList;

	public void setGoalList(List<Goal> goalList) {
		this.goalList = goalList;
	}

	public void setClassification(String classification) {
		this.classification = classification;
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

	public List<Goal> getGoalList() {
		return goalList;
	}

	public String getClassification() {
		return classification;
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
