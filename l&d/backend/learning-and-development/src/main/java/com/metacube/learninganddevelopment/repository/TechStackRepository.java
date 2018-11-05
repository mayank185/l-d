package com.metacube.learninganddevelopment.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.metacube.learninganddevelopment.model.TechStack;
public interface TechStackRepository extends JpaRepository<TechStack, Long> {

}
