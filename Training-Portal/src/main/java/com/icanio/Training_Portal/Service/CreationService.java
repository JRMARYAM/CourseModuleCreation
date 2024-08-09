package com.icanio.Training_Portal.Service;


import com.icanio.Training_Portal.DTO.CreatedRequest;
import com.icanio.Training_Portal.Entity.CourseManager;
import com.icanio.Training_Portal.Entity.Courses;
import com.icanio.Training_Portal.Repository.CourseManagerRepository;
import com.icanio.Training_Portal.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class CreationService {

    @Autowired
    private CourseManagerRepository courseManagerRepository;
    @Autowired
    private CourseRepository courseRepository;

    public String createCourse(@RequestBody CreatedRequest createdRequest) {
        Optional<CourseManager> existManager = courseManagerRepository.findByManagerEmail(createdRequest.getManagerEmail());
        CourseManager courseManager;

        if (existManager.isPresent()) {
            courseManager = existManager.get();
        } else {
            courseManager = new CourseManager();
            courseManager.setManagerEmail(createdRequest.getManagerEmail());
            courseManager.setManagerName(createdRequest.getManagerName());
            courseManagerRepository.save(courseManager);
        }

        Courses courses = new Courses();
        courses.setCourseTitle(createdRequest.getCourseTitle());
        courses.setCourseManager(courseManager);
        courseRepository.save(courses);

        return "Successfully saved";
    }

}
