package com.metacube.learninganddevelopment.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.metacube.learninganddevelopment.model.OrgUser;
public interface OrgUserRepository extends JpaRepository<OrgUser, Long> {

}
