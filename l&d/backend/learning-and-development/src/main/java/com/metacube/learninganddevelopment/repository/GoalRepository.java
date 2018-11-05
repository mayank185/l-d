package com.metacube.learninganddevelopment.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.metacube.learninganddevelopment.model.Goal;
public interface GoalRepository extends JpaRepository<Goal, Long> {

}
