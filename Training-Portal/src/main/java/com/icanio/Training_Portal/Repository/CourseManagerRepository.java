package com.icanio.Training_Portal.Repository;



import com.icanio.Training_Portal.Entity.CourseManager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseManagerRepository extends JpaRepository<CourseManager,Integer> {
  Optional<CourseManager> findByManagerEmail(String managerEmail);
}
