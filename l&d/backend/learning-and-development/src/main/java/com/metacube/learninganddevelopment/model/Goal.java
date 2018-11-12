package com.metacube.learninganddevelopment.model;

import java.util.Date;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Goal extends Auditable<Long> {

	private Long orgId;

	private String name;

	private String tags;

	private String goalId;

	private String version;

	private Boolean isActive;

	private Double courseCost;

	private Boolean isDeleted;

	private String courseLink;

	private String description;

	private Date activationDate;

	private Float esimatedEffort;

	private Date inactivationDate;

	private String otherPrerequisite;

	private UUID uuid = UUID.randomUUID();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	@Type(type = "com.metacube.learninganddevelopment.model.SQLEnumType")
	private GoalStatus status;

	@OneToMany(cascade = { CascadeType.ALL }, orphanRemoval = true)
	@JoinColumn(name = "goal_id")
	private List<GoalMember> goalMemberList;

	@OneToMany(cascade = { CascadeType.ALL }, orphanRemoval = true)
	@JoinColumn(name = "goal_id")
	private List<GoalChapter> goalChapterList;

	@ManyToMany
	@JoinTable(name = "goal_prerequisite", joinColumns = @JoinColumn(name = "prerequisiteGoalId"), inverseJoinColumns = @JoinColumn(name = "goalId"))
	private List<Goal> goalPrerequisiteList;

	public void setGoalChapterList(List<GoalChapter> goalChapterList) {
		this.goalChapterList = goalChapterList;
	}

	public void setInactivationDate(Date inactivationDate) {
		this.inactivationDate = inactivationDate;
	}

	public void setEsimatedEffort(Float esimatedEffort) {
		this.esimatedEffort = esimatedEffort;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setGoalPrerequisiteList(List<Goal> goalPrerequisiteList) {
		this.goalPrerequisiteList = goalPrerequisiteList;
	}

	public void setOtherPrerequisite(String otherPrerequisite) {
		this.otherPrerequisite = otherPrerequisite;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setActivationDate(Date activationDate) {
		this.activationDate = activationDate;
	}

	public void setCourseCost(Double courseCost) {
		this.courseCost = courseCost;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public void setStatus(GoalStatus status) {
		this.status = status;
	}

	public void setGoalId(String goalId) {
		this.goalId = goalId;
	}

	public void setCourseLink(String courseLink) {
		this.courseLink = courseLink;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public void setGoalMemberList(List<GoalMember> goalMemberList) {
		this.goalMemberList = goalMemberList;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public List<GoalChapter> getGoalChapterList() {
		return goalChapterList;
	}

	public Date getInactivationDate() {
		return inactivationDate;
	}

	public Float getEsimatedEffort() {
		return esimatedEffort;
	}

	public String getDescription() {
		return description;
	}

	public List<Goal> getGoalPrerequisiteList() {
		return goalPrerequisiteList;
	}

	public String getOtherPrerequisite() {
		return otherPrerequisite;
	}

	public String getName() {
		return name;
	}

	public Date getActivationDate() {
		return activationDate;
	}

	public Double getCourseCost() {
		return courseCost;
	}

	public String getVersion() {
		return version;
	}

	public Long getId() {
		return id;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public GoalStatus getStatus() {
		return status;
	}

	public String getGoalId() {
		return goalId;
	}

	public String getCourseLink() {
		return courseLink;
	}

	public String getTags() {
		return tags;
	}

	public List<GoalMember> getGoalMemberList() {
		return goalMemberList;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public UUID getUuid() {
		return uuid;
	}

	public Long getOrgId() {
		return orgId;
	}
}
