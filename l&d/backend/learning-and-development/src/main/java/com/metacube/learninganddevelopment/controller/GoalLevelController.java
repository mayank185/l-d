package com.metacube.learninganddevelopment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.metacube.learninganddevelopment.model.Goal;
import com.metacube.learninganddevelopment.model.GoalLevel;
import com.metacube.learninganddevelopment.model.OrgUser;
import com.metacube.learninganddevelopment.repository.GoalLevelRepository;
import com.metacube.learninganddevelopment.repository.GoalRepository;
import com.metacube.learninganddevelopment.repository.OrgUserRepository;
import com.metacube.learninganddevelopment.repository.TechStackRepository;

@RestController
@RequestMapping("/api/goal-level")
public class GoalLevelController {

	@Autowired
	private GoalLevelRepository goalLevelRepository;
	@Autowired
	private GoalRepository goalRepository;
	@Autowired
	private OrgUserRepository orgUserRepository;
	@Autowired
	private TechStackRepository techStackRepository;
	
	@GetMapping("/list")
	public List<GoalLevel> list(){
		return goalLevelRepository.findAll();
	}
	
	@GetMapping("/list/users")
	public List<OrgUser> listUsers(){
		return orgUserRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody GoalLevel level){
	}
	
	@GetMapping("/{id}")
	public GoalLevel getById(@PathVariable("id") long id){
		return goalLevelRepository.findById(id).get();
	}
	
	@GetMapping("/tech-stack/{id}")
	public List<Goal> getGoalsByTechStackId(@PathVariable("id") long id){
		return techStackRepository.findById(id).get().getGoalList();
	}
	
	@GetMapping("/goal/{id}")
	public List<OrgUser> getOrgUsersByGoalId(@PathVariable("id") long id){
		return goalRepository.findById(id).get().getGoalMemberList();
	}
	
}
