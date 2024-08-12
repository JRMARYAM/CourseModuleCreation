package com.icanio.Training_Portal.Controller;

import com.icanio.Training_Portal.DTO.ModuleResponse;
import com.icanio.Training_Portal.Entity.Module;
import com.icanio.Training_Portal.Service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@PreAuthorize("hasAuthority('USER')")
@RequestMapping("/courses")
public class ModuleController {

 @Autowired
 private ModuleService moduleService;
 @PreAuthorize("hasAuthority('USER')")
 @GetMapping("/allcourses")
 public List<ModuleResponse> all() {
  return moduleService.all();
 }
 @PreAuthorize("hasAuthority('USER')")
 @GetMapping("/get/{id}")
 public ResponseEntity<Module> getCourseById(@PathVariable Long id) {
  Optional<Module> course = moduleService.getCourseById(id);
  return course.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
 }
 @PreAuthorize("hasAuthority('USER')")
 @PostMapping("/register")
 public ResponseEntity<Module> saveOrUpdateCourse(@RequestBody Module module) {
  Module savedModule = moduleService.saveOrUpdateCourse(module);
  return ResponseEntity.ok(savedModule);
 }



}















