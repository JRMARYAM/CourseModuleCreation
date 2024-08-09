package com.icanio.Training_Portal.Service;


import com.icanio.Training_Portal.DTO.LearningResponse;
import com.icanio.Training_Portal.Entity.CourseManager;
import com.icanio.Training_Portal.Entity.Courses;
import com.icanio.Training_Portal.Repository.CourseManagerRepository;
import com.icanio.Training_Portal.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class LearningService {
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    CourseManagerRepository courseManagerRepository;
    public List<LearningResponse> learningPath(){
        List<Courses> coursesList = courseRepository.findAll();
        List<CourseManager> courseManagerList= courseManagerRepository.findAll();
        List<LearningResponse> learningResponses= new ArrayList<>();
        for (Courses courses:coursesList){
            LearningResponse learningResponse= new LearningResponse();
            learningResponse.setCourseId(courses.getCourseId());
            learningResponse.setCourseTitle(courses.getCourseTitle());
            learningResponse.setManagerName(courses.courseManager.getManagerName());
            learningResponses.add(learningResponse);
        }
        return learningResponses;
    }
}
