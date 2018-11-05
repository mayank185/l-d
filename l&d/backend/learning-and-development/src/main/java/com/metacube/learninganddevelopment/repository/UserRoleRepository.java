package com.metacube.learninganddevelopment.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.metacube.learninganddevelopment.model.UserRole;
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

}
