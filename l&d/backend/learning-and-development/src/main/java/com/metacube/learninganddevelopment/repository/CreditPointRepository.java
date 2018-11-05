package com.metacube.learninganddevelopment.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.metacube.learninganddevelopment.model.CreditPoint;
public interface CreditPointRepository extends JpaRepository<CreditPoint, Long> {

}
