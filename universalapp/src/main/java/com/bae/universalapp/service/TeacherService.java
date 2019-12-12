// package com.bae.universalapp.service;

// import java.util.List;

// import com.bae.universalapp.persistence.domain.Teacher;
// import com.bae.universalapp.persistence.repo.TeacherRepo;

// import org.springframework.stereotype.Service;

// /**
//  * TeacherService
//  */
// @Service
// public class TeacherService {

//     private TeacherRepo teacherRepo;

//     public TeacherService(TeacherRepo repo) {
        
//         this.teacherRepo = repo;
//     }

//     public Teacher addTeacher(Teacher teacher) {
        
//         return this.teacherRepo.save(teacher);  
//     }

//     public Teacher getTeacherById(Long id) {

//         return this.teacherRepo.findById(id).get();
//     }

//     public List<Teacher> getAllTeachers() {

//         return this.teacherRepo.findAll();
//     }

//     public Teacher updateTeacherById(Teacher teacher, Long id) {

//         Teacher toUpdate = this.teacherRepo.findById(id).get();
//         toUpdate.setFirstName(teacher.getFirstName());
//         toUpdate.setLastName(teacher.getLastName());

//         return toUpdate;
//     }

//     public String deleteTeacherById(Long id) {

//         this.teacherRepo.deleteById(id);

//         boolean teacherCheck = this.teacherRepo.existsById(id);

//         if (teacherCheck) {
//             return "Teacher has not been deleted";
//         }
//         return "Teacher deleted sucessfully";


//     }


    
// }