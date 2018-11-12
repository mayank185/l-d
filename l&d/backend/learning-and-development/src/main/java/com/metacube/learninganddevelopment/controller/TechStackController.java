package com.metacube.learninganddevelopment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metacube.learninganddevelopment.model.Goal;
import com.metacube.learninganddevelopment.model.TechStack;
import com.metacube.learninganddevelopment.repository.TechStackRepository;


@RestController
@RequestMapping("/api/tech-stack")
public class TechStackController {
	
	@Autowired
	private TechStackRepository techStackRepository;
	
	@GetMapping("/")
	public List<TechStack> list(){
		return techStackRepository.findAll();
	}
	
	@GetMapping("/goal/{id}")
	public List<Goal> listGoals(@PathVariable("id") long id){
		return techStackRepository.getOne(id).getGoalList();
	}
}
