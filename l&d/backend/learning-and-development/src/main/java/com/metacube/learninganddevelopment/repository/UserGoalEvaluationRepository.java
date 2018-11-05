package com.metacube.learninganddevelopment.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.metacube.learninganddevelopment.model.UserGoalEvaluation;
public interface UserGoalEvaluationRepository extends JpaRepository<UserGoalEvaluation, Long> {

}
