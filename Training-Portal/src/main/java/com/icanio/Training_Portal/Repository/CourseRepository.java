package com.icanio.Training_Portal.Repository;


import com.icanio.Training_Portal.Entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Courses,Integer> {
}
