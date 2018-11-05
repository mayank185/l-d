package com.metacube.learninganddevelopment.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.metacube.learninganddevelopment.model.UserGoalClaim;
public interface UserGoalClaimRepository extends JpaRepository<UserGoalClaim, Long> {

}
