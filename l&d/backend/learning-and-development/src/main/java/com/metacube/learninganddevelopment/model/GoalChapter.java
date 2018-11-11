package com.metacube.learninganddevelopment.model;

import javax.persistence.GenerationType;

import javax.persistence.GeneratedValue;

import javax.persistence.EnumType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;

import com.metacube.learninganddevelopment.model.Goal;

import javax.persistence.Enumerated;

import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;

import javax.persistence.Id;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class GoalChapter extends Auditable<Long> {

	private String name;

	private Float credits;

	private Boolean isActive;

	private String contentLink;

	private String additionalLink;

	private Integer chapterSequence;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "goal_id")
	@Enumerated(EnumType.STRING)
	@Type(type = "com.metacube.learninganddevelopment.model.SQLEnumType")
	private Goal goal;

	public void setContentLink(String contentLink) {
		this.contentLink = contentLink;
	}

	public void setCredits(Float credits) {
		this.credits = credits;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setGoal(Goal goal) {
		this.goal = goal;
	}

	public void setAdditionalLink(String additionalLink) {
		this.additionalLink = additionalLink;
	}

	public void setChapterSequence(Integer chapterSequence) {
		this.chapterSequence = chapterSequence;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getContentLink() {
		return contentLink;
	}

	public Float getCredits() {
		return credits;
	}

	public String getName() {
		return name;
	}

	public Long getId() {
		return id;
	}

	public Goal getGoal() {
		return goal;
	}

	public String getAdditionalLink() {
		return additionalLink;
	}

	public Integer getChapterSequence() {
		return chapterSequence;
	}

	public Boolean getIsActive() {
		return isActive;
	}
}
