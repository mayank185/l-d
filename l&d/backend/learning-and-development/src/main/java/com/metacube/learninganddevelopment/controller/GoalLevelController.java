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
import com.metacube.learninganddevelopment.model.GoalChapter;
import com.metacube.learninganddevelopment.model.GoalLevel;
import com.metacube.learninganddevelopment.model.OrgUser;
import com.metacube.learninganddevelopment.model.TechStack;
import com.metacube.learninganddevelopment.model.UserGoal;
import com.metacube.learninganddevelopment.repository.GoalChapterRepository;
import com.metacube.learninganddevelopment.repository.GoalLevelRepository;
import com.metacube.learninganddevelopment.repository.GoalRepository;
import com.metacube.learninganddevelopment.repository.OrgUserRepository;
import com.metacube.learninganddevelopment.repository.TechStackRepository;
import com.metacube.learninganddevelopment.repository.UserGoalRepository;

@RestController
@RequestMapping("/api/goal-level")
public class GoalLevelController {

	@Autowired
	private GoalLevelRepository goalLevelRepository;

	@Autowired
	private GoalChapterRepository goalChapterRepository;
	@Autowired
	private GoalRepository goalRepository;
	@Autowired
	private OrgUserRepository orgUserRepository;
	@Autowired
	private TechStackRepository techStackRepository;
	
	@Autowired
	private UserGoalRepository userGoalRepository;
	
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
	
	@GetMapping("/tech-stacks/{id}")
	public TechStack getTByTechStackId(@PathVariable("id") long id){
		return techStackRepository.findById(id).get();
	}
	
	@GetMapping("/goal/{id}")
	public List<OrgUser> getOrgUsersByGoalId(@PathVariable("id") long id){
		return goalRepository.findById(id).get().getGoalMemberList();
	}
	
	@GetMapping("/goal-chapter/{id}")
	public List<GoalChapter> getGoalChapterByGoalId(@PathVariable("id") long id){
		return goalRepository.findById(id).get().getGoalChapterList();
	}
	
	@GetMapping("/goal-chapter/goal/{id}")
	public Goal getGoalByGoalChapterId(@PathVariable("id") long id){
		return goalChapterRepository.findById(id).get().getGoal();
	}

	@GetMapping("/goal-chapter/goal-user/{id}")
	public UserGoal getGoalOfUserById(@PathVariable("id") Long id){
		return userGoalRepository.getOne(id);
	}
	
}
