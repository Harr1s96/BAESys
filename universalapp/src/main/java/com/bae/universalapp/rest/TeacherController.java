package com.bae.universalapp.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import com.bae.universalapp.persistence.domain.Teacher;
import com.bae.universalapp.service.TeacherService;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

/**
 * TeacherController
*/
@RestController
public class TeacherController {

    private TeacherService service;

    public TeacherController(TeacherService service) {
        this.service = service;
    }

    @PostMapping("/createTeacher")
	public Teacher addTeacher(@RequestBody Teacher teacher) {
		return this.service.addTeacher(teacher);
	}
	
	@GetMapping("/getTeachers")
	public List<Teacher> getAllTeachers() {
		return this.service.getAllTeachers();
	
	// @GetMapping("/getTeacherById/{id}")
	// public Teacher getOneTeacher(Long id) {
	// 	return this.service.getTeacherById(id);
	// }
		
	}
	@PutMapping("/updateTeacher")
	public Teacher updateTeacherById(@PathParam("id") Long id, @RequestBody Teacher teacher) {
		return this.service.updateTeacherById(teacher, id);
		
	}
	
	@DeleteMapping("/deleteTeacher/{id}")
	public void deleteTeacherById(@PathVariable Long id) {
		this.service.deleteTeacherById(id);
	}

    
}