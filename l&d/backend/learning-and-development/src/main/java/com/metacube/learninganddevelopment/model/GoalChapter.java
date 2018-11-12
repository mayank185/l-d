package com.metacube.learninganddevelopment.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

	public void setAdditionalLink(String additionalLink) {
		this.additionalLink = additionalLink;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setContentLink(String contentLink) {
		this.contentLink = contentLink;
	}

	public void setCredits(Float credits) {
		this.credits = credits;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setChapterSequence(Integer chapterSequence) {
		this.chapterSequence = chapterSequence;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getAdditionalLink() {
		return additionalLink;
	}

	public String getName() {
		return name;
	}

	public String getContentLink() {
		return contentLink;
	}

	public Float getCredits() {
		return credits;
	}

	public Long getId() {
		return id;
	}

	public Integer getChapterSequence() {
		return chapterSequence;
	}

	public Boolean getIsActive() {
		return isActive;
	}
}
