package com.metacube.learninganddevelopment.model;

import javax.persistence.Id;

import java.sql.Timestamp;

import javax.persistence.GeneratedValue;

import javax.persistence.ManyToOne;

import javax.persistence.GenerationType;

import com.metacube.learninganddevelopment.model.Goal;

import javax.persistence.Entity;

@Entity
public class GoalChapter {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	private Float credits;

	private String contentLink;

	private Integer chapterSequence;

	private String additionalLink;

	private Long createdBy;

	private Timestamp createdDate;

	private Long lastModifiedBy;

	private Timestamp lastModifiedDate;

	private Boolean isActive;

	@ManyToOne
	private Goal goal;

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCredits(Float credits) {
		this.credits = credits;
	}

	public void setContentLink(String contentLink) {
		this.contentLink = contentLink;
	}

	public void setChapterSequence(Integer chapterSequence) {
		this.chapterSequence = chapterSequence;
	}

	public void setAdditionalLink(String additionalLink) {
		this.additionalLink = additionalLink;
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

	public void setGoal(Goal goal) {
		this.goal = goal;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Float getCredits() {
		return credits;
	}

	public String getContentLink() {
		return contentLink;
	}

	public Integer getChapterSequence() {
		return chapterSequence;
	}

	public String getAdditionalLink() {
		return additionalLink;
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

	public Goal getGoal() {
		return goal;
	}
}
