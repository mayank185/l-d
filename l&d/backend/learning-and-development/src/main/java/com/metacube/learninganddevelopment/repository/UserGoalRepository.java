package com.metacube.learninganddevelopment.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.metacube.learninganddevelopment.model.UserGoal;
public interface UserGoalRepository extends JpaRepository<UserGoal, Long> {

}
