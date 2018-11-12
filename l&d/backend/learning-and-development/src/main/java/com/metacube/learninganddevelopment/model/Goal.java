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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Goal extends Auditable<Long> {

	private Long orgId;

	private String tags;

	private String name;

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

	@OneToMany(cascade = {CascadeType.ALL}, orphanRemoval=true)
	@JoinColumn(name = "goal_id")
	@JsonProperty(access = Access.WRITE_ONLY)
	private List<GoalChapter> goalChapterList;

	@Enumerated(EnumType.STRING)
	@Type(type = "com.metacube.learninganddevelopment.model.SQLEnumType")
	private GoalStatus status;

	@ManyToOne
	@JoinColumn(name = "level_id")
	private GoalLevel goalLevel;

	@ManyToOne
	@JoinColumn(name = "tech_stack_id")
	private TechStack techStack;

	@ManyToOne
	@JoinColumn(name = "credit_point_id")
	private CreditPoint creditPoint;

	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name = "goal_member", joinColumns = @JoinColumn(name = "goalId"), inverseJoinColumns = @JoinColumn(name = "userId"))
	@JsonIgnore
	private List<OrgUser> goalMemberList;

	@ManyToOne
	@JoinColumn(name = "goal_classification_id")
	private GoalClassification goalClassification;

	@ManyToMany
	@JoinTable(name = "goal_prerequisite", joinColumns = @JoinColumn(name = "prerequisiteGoalId"), inverseJoinColumns = @JoinColumn(name = "goalId"))
	@JsonIgnore
	private List<Goal> goalPrerequisiteList;

	public void setStatus(GoalStatus status) {
		this.status = status;
	}

	public void setOtherPrerequisite(String otherPrerequisite) {
		this.otherPrerequisite = otherPrerequisite;
	}

	public void setActivationDate(Date activationDate) {
		this.activationDate = activationDate;
	}

	public void setCourseCost(Double courseCost) {
		this.courseCost = courseCost;
	}

	public void setGoalClassification(GoalClassification goalClassification) {
		this.goalClassification = goalClassification;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setTechStack(TechStack techStack) {
		this.techStack = techStack;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public void setGoalChapterList(List<GoalChapter> goalChapterList) {
		this.goalChapterList = goalChapterList;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setGoalPrerequisiteList(List<Goal> goalPrerequisiteList) {
		this.goalPrerequisiteList = goalPrerequisiteList;
	}

	public void setGoalMemberList(List<OrgUser> goalMemberList) {
		this.goalMemberList = goalMemberList;
	}

	public void setEsimatedEffort(Float esimatedEffort) {
		this.esimatedEffort = esimatedEffort;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public void setGoalId(String goalId) {
		this.goalId = goalId;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public void setCreditPoint(CreditPoint creditPoint) {
		this.creditPoint = creditPoint;
	}

	public void setCourseLink(String courseLink) {
		this.courseLink = courseLink;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public void setInactivationDate(Date inactivationDate) {
		this.inactivationDate = inactivationDate;
	}

	public void setGoalLevel(GoalLevel goalLevel) {
		this.goalLevel = goalLevel;
	}

	public GoalStatus getStatus() {
		return status;
	}

	public String getOtherPrerequisite() {
		return otherPrerequisite;
	}

	public Date getActivationDate() {
		return activationDate;
	}

	public Double getCourseCost() {
		return courseCost;
	}

	public GoalClassification getGoalClassification() {
		return goalClassification;
	}

	public String getDescription() {
		return description;
	}

	public TechStack getTechStack() {
		return techStack;
	}

	public String getTags() {
		return tags;
	}

	public Long getOrgId() {
		return orgId;
	}

	public UUID getUuid() {
		return uuid;
	}

	public List<GoalChapter> getGoalChapterList() {
		return goalChapterList;
	}

	public Long getId() {
		return id;
	}

	public List<Goal> getGoalPrerequisiteList() {
		return goalPrerequisiteList;
	}

	public List<OrgUser> getGoalMemberList() {
		return goalMemberList;
	}

	public Float getEsimatedEffort() {
		return esimatedEffort;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public String getGoalId() {
		return goalId;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public CreditPoint getCreditPoint() {
		return creditPoint;
	}

	public String getCourseLink() {
		return courseLink;
	}

	public String getName() {
		return name;
	}

	public String getVersion() {
		return version;
	}

	public Date getInactivationDate() {
		return inactivationDate;
	}

	public GoalLevel getGoalLevel() {
		return goalLevel;
	}
}
