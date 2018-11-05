package com.metacube.learninganddevelopment.model;
import javax.persistence.GenerationType;

import javax.persistence.OneToMany;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.GeneratedValue;

import java.util.UUID;

import javax.persistence.JoinColumn;

import com.metacube.learninganddevelopment.model.UserGoalClaim;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Id;

import javax.persistence.Entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AssignmentQuality{
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;


private UUID uuid;


private String quality;


private Long lastModifiedBy;


private Timestamp lastModifiedDate;


private Boolean isActive;

@OneToMany
@JoinColumn(name="assignment_quality_id")
@JsonIgnore
private List<UserGoalClaim> userGoalClaimList;
public void setId(Long id){
this.id=id;
}

public void setUuid(UUID uuid){
this.uuid=uuid;
}

public void setQuality(String quality){
this.quality=quality;
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

public void setUserGoalClaimList(List<UserGoalClaim> userGoalClaimList){
this.userGoalClaimList=userGoalClaimList;
}
public Long getId(){
return id;
}

public UUID getUuid(){
return uuid;
}

public String getQuality(){
return quality;
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

public List<UserGoalClaim> getUserGoalClaimList(){
return userGoalClaimList;
}
}
