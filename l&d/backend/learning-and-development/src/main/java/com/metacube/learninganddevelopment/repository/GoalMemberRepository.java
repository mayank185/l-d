package com.metacube.learninganddevelopment.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.metacube.learninganddevelopment.model.GoalMember;
public interface GoalMemberRepository extends JpaRepository<GoalMember, Long> {

}
