package com.icanio.Training_Portal.Service;

import com.icanio.Training_Portal.DTO.ModuleResponse;
import com.icanio.Training_Portal.Entity.Module;
import com.icanio.Training_Portal.Repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ModuleService {

    @Autowired
    private ModuleRepository moduleRepository;



    public List<Module> getAllCourses() {
        return moduleRepository.findAll();
    }

    public Optional<Module> getCourseById(Long id) {
        return moduleRepository.findById(id);
    }

    public Module saveOrUpdateCourse(Module module) {
        Optional<Module> existingModule = moduleRepository.findById(module.getId());
        if (existingModule.isPresent()) {
            Module existing = existingModule.get();

            existing.setTittle(module.getTittle());
            existing.setTopic(module.getTopic());
            existing.setCourseid(module.getCourseid());
            return moduleRepository.save(existing);
        } else {

            return moduleRepository.save(module);
        }
    }

    public void deleteCourse(Long id) {
        moduleRepository.deleteById(id);
    }

    public List<ModuleResponse> all() {
        List<Module> modules = moduleRepository.findAll();
        List<ModuleResponse> moduleResponseList = new ArrayList<>();
        for (Module module : modules) {
            ModuleResponse moduleResponse = new ModuleResponse();
            moduleResponse.setCourseid(module.getCourseid());
            moduleResponse.setId(module.getId());
            moduleResponse.setTopic(module.getTopic());
            moduleResponse.setTittle(module.getTittle());
            moduleResponseList.add(moduleResponse);

        }
        return moduleResponseList;
    }

}
