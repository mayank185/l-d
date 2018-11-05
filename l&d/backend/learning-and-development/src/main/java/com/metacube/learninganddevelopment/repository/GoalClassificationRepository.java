package com.metacube.learninganddevelopment.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.metacube.learninganddevelopment.model.GoalClassification;
public interface GoalClassificationRepository extends JpaRepository<GoalClassification, Long> {

}
