package com.icanio.Training_Portal.Controller;


import com.icanio.Training_Portal.DTO.CreatedRequest;
import com.icanio.Training_Portal.DTO.LearningResponse;
import com.icanio.Training_Portal.Repository.CourseRepository;
import com.icanio.Training_Portal.Service.CreationService;
import com.icanio.Training_Portal.Service.LearningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CourseController {
 @Autowired
 private LearningService learningService;
 @Autowired
 private CreationService creationService;
 @Autowired
 public CourseRepository courseRepository;


 @PostMapping("/Create")
 public ResponseEntity<String> createCourse(@RequestBody CreatedRequest createdRequest) {
  return ResponseEntity.ok(creationService.createCourse(createdRequest));
 }

 @GetMapping("/learning")
 public List<LearningResponse> learning(){
  return  learningService.learningPath();
 }
}