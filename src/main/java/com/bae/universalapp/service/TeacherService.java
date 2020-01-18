package com.bae.universalapp.service;

import java.util.List;

import com.bae.universalapp.persistence.domain.Module;
import com.bae.universalapp.persistence.domain.Teacher;
import com.bae.universalapp.persistence.repo.TeacherRepo;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

/**
 * TeacherService
 */
@Service
public class TeacherService {

    private TeacherRepo teacherRepo;

    public TeacherService(TeacherRepo repo) {

        this.teacherRepo = repo;
    }

    public Teacher addTeacher(Teacher teacher) {

        return this.teacherRepo.save(teacher);
    }

    public Teacher getTeacherById(Long id) {

        return this.teacherRepo.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public List<Teacher> getAllTeachers() {

        return this.teacherRepo.findAll();
    }

    public Teacher updateTeacherById(Teacher teacher, Long id) {

        Teacher toUpdate = this.teacherRepo.findById(id).orElseThrow(ResourceNotFoundException::new);
        toUpdate.setFirstName(teacher.getFirstName());
        toUpdate.setLastName(teacher.getLastName());

        return this.teacherRepo.save(toUpdate);
    }

    public Teacher updateModulesByTeacherId(Long id, List<Module> moduleList) {
        
        Teacher toUpdate = this.teacherRepo.findById(id).orElseThrow(ResourceNotFoundException::new);
        toUpdate.getModules().addAll(moduleList);

        return this.teacherRepo.saveAndFlush(toUpdate);
    }

    public String deleteTeacherById(Long id) {

        this.teacherRepo.deleteById(id);

        boolean teacherCheck = this.teacherRepo.existsById(id);

        if (teacherCheck) {
            return "Teacher has not been deleted";
        }
        return "Teacher deleted successfully";

    }

}