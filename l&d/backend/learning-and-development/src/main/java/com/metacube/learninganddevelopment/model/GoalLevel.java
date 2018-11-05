package com.metacube.learninganddevelopment.model;
import javax.persistence.GenerationType;

import javax.persistence.OneToMany;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.GeneratedValue;

import java.util.UUID;

import com.metacube.learninganddevelopment.model.Goal;

import javax.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Id;

import javax.persistence.Entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class GoalLevel{
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;


private UUID uuid;


private String level;


private Long lastModifiedBy;


private Timestamp lastModifiedDate;


private Boolean isActive;

@OneToMany
@JoinColumn(name="level_id")
@JsonIgnore
private List<Goal> goalList;
public void setId(Long id){
this.id=id;
}

public void setUuid(UUID uuid){
this.uuid=uuid;
}

public void setLevel(String level){
this.level=level;
}

public void setLastModifiedBy(Long lastModifiedBy){
this.lastModifiedBy=lastModifiedBy;
}

public void setLastModifiedDate(Timestamp lastModifiedDate){
this.lastModifiedDate=lastModifiedDate;
}

public void setIsActive(Boolean isActive){
this.isActive=isActive;
}

public void setGoalList(List<Goal> goalList){
this.goalList=goalList;
}
public Long getId(){
return id;
}

public UUID getUuid(){
return uuid;
}

public String getLevel(){
return level;
}

public Long getLastModifiedBy(){
return lastModifiedBy;
}

public Timestamp getLastModifiedDate(){
return lastModifiedDate;
}

public Boolean getIsActive(){
return isActive;
}

public List<Goal> getGoalList(){
return goalList;
}
}
