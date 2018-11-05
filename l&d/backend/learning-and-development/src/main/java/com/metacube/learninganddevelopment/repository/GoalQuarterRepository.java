package com.metacube.learninganddevelopment.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.metacube.learninganddevelopment.model.GoalQuarter;
public interface GoalQuarterRepository extends JpaRepository<GoalQuarter, Long> {

}
