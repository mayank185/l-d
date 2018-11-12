package com.metacube.learninganddevelopment.controller;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metacube.learninganddevelopment.model.Goal;
import com.metacube.learninganddevelopment.model.GoalChapter;
import com.metacube.learninganddevelopment.repository.GoalRepository;

@RestController
@RequestMapping("/api/goal")
@Transactional
public class GoalController {
	
	@Autowired
	private GoalRepository goalRepository;
	
	@Autowired
	private EntityManager entityManager;
	
	@PostMapping("/save")
	public Goal saveGoal(@RequestBody Goal goal){
		//entityManager.persist(goal);
		//goalRepository.save(goal);
//		System.out.println(goal.getGoalChapterList());
//		for (GoalChapter goalChapter: goal.getGoalChapterList())
//			goalChapter.setGoal(goal);
		return goalRepository.save(goal);
		//return goal;
	}
	
	@GetMapping("/chapters/{id}")
	public List<GoalChapter> showChapters(@PathVariable Long id){
		
		return goalRepository.getOne(id).getGoalChapterList();
		//return goal;
	}
	
	@DeleteMapping("/{id}")
	public Goal deleteGoal(@PathVariable Long id){
		Goal goal = goalRepository.getOne(id);
		goalRepository.deleteById(id);
		return null;
	}
	
	@GetMapping("/{id}")
	public Goal getGoal(@PathVariable Long id){
		return goalRepository.getOne(id);
	}
}
