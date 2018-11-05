package com.metacube.learninganddevelopment.model;

import com.metacube.learninganddevelopment.model.GoalLevel;

import com.metacube.learninganddevelopment.model.GoalClassification;

import com.metacube.learninganddevelopment.model.GoalChapter;

import javax.persistence.Id;

import java.sql.Timestamp;

import javax.persistence.GeneratedValue;

import com.metacube.learninganddevelopment.model.CreditPoint;

import com.metacube.learninganddevelopment.model.Goal;

import javax.persistence.ManyToOne;

import javax.persistence.GenerationType;

import javax.persistence.ManyToMany;

import java.util.UUID;

import com.metacube.learninganddevelopment.model.OrgUser;

import java.util.List;

import javax.persistence.OneToMany;

import com.metacube.learninganddevelopment.model.TechStack;

import javax.persistence.Entity;

@Entity
public class Goal {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private UUID uuid;

	private Long orgId;

	private String goalId;

	private String version;

	private String name;

	private String description;

	private String status;

	private Boolean isDeleted;

	private String tags;

	private Timestamp activationDate;

	private Timestamp inactivationDate;

	private String otherPrerequisite;

	private Float esimatedEffort;

	private Long createdBy;

	private Timestamp createdDate;

	private Long lastModifiedBy;

	private Timestamp lastModifiedDate;

	private Boolean isActive;

	private Double courseCost;

	private String courseLink;

	@ManyToOne
	private TechStack techStack;

	@ManyToOne
	private GoalLevel goalLevel;

	@ManyToOne
	private CreditPoint creditPoint;

	@ManyToOne
	private GoalClassification goalClassification;

	@ManyToMany
	private List<OrgUser> goalMemberList;

	@ManyToMany
	private List<Goal> goalPrerequisiteList;

	@OneToMany
	private List<GoalChapter> goalChapterList;

	public void setId(Long id) {
		this.id = id;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public void setGoalId(String goalId) {
		this.goalId = goalId;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public void setActivationDate(Timestamp activationDate) {
		this.activationDate = activationDate;
	}

	public void setInactivationDate(Timestamp inactivationDate) {
		this.inactivationDate = inactivationDate;
	}

	public void setOtherPrerequisite(String otherPrerequisite) {
		this.otherPrerequisite = otherPrerequisite;
	}

	public void setEsimatedEffort(Float esimatedEffort) {
		this.esimatedEffort = esimatedEffort;
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

	public void setCourseCost(Double courseCost) {
		this.courseCost = courseCost;
	}

	public void setCourseLink(String courseLink) {
		this.courseLink = courseLink;
	}

	public void setTechStack(TechStack techStack) {
		this.techStack = techStack;
	}

	public void setGoalLevel(GoalLevel goalLevel) {
		this.goalLevel = goalLevel;
	}

	public void setCreditPoint(CreditPoint creditPoint) {
		this.creditPoint = creditPoint;
	}

	public void setGoalClassification(GoalClassification goalClassification) {
		this.goalClassification = goalClassification;
	}

	public void setGoalMemberList(List<OrgUser> goalMemberList) {
		this.goalMemberList = goalMemberList;
	}

	public void setGoalPrerequisiteList(List<Goal> goalPrerequisiteList) {
		this.goalPrerequisiteList = goalPrerequisiteList;
	}

	public void setGoalChapterList(List<GoalChapter> goalChapterList) {
		this.goalChapterList = goalChapterList;
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

	public String getGoalId() {
		return goalId;
	}

	public String getVersion() {
		return version;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getStatus() {
		return status;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public String getTags() {
		return tags;
	}

	public Timestamp getActivationDate() {
		return activationDate;
	}

	public Timestamp getInactivationDate() {
		return inactivationDate;
	}

	public String getOtherPrerequisite() {
		return otherPrerequisite;
	}

	public Float getEsimatedEffort() {
		return esimatedEffort;
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

	public Double getCourseCost() {
		return courseCost;
	}

	public String getCourseLink() {
		return courseLink;
	}

	public TechStack getTechStack() {
		return techStack;
	}

	public GoalLevel getGoalLevel() {
		return goalLevel;
	}

	public CreditPoint getCreditPoint() {
		return creditPoint;
	}

	public GoalClassification getGoalClassification() {
		return goalClassification;
	}

	public List<OrgUser> getGoalMemberList() {
		return goalMemberList;
	}

	public List<Goal> getGoalPrerequisiteList() {
		return goalPrerequisiteList;
	}

	public List<GoalChapter> getGoalChapterList() {
		return goalChapterList;
	}
}
