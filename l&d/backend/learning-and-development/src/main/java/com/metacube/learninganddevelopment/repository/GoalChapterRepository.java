package com.metacube.learninganddevelopment.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.metacube.learninganddevelopment.model.GoalChapter;
public interface GoalChapterRepository extends JpaRepository<GoalChapter, Long> {

}
