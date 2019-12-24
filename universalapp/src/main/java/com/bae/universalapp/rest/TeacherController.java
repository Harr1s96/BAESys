package com.bae.universalapp.rest;

import java.util.List;
import javax.websocket.server.PathParam;

import com.bae.universalapp.persistence.domain.Module;
import com.bae.universalapp.persistence.domain.Teacher;
import com.bae.universalapp.service.EmptyModuleListException;
import com.bae.universalapp.service.InvalidModuleCodeException;
import com.bae.universalapp.service.ModuleService;
import com.bae.universalapp.service.TeacherService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

/**
 * TeacherController
 */
@RestController
public class TeacherController {

	private TeacherService service;
	private ModuleService moduleService;

	public TeacherController(TeacherService service, ModuleService moduleService) {
		this.service = service;
		this.moduleService = moduleService;
	}

	@PostMapping("/teacher")
	public Teacher addTeacher(@RequestBody Teacher teacher)
			throws EmptyModuleListException, InvalidModuleCodeException {

		List<Module> theList = teacher.getModules();
		this.moduleService.verifyModuleCode(theList);
		return this.service.addTeacher(teacher);

	}

	@GetMapping("/teacher")
	public List<Teacher> getAllTeachers() {
		return this.service.getAllTeachers();
	}

	@GetMapping("/teacher/{id}")
	public Teacher getTeacherById(@PathVariable(value = "id") Long id) {

		return this.service.getTeacherById(id);
	}

	@PutMapping("/teacher")
	public Teacher updateTeacherById(@PathParam("id") Long id, @RequestBody Teacher teacher) {
		return this.service.updateTeacherById(teacher, id);

	}

	@DeleteMapping("/teacher/{id}")
	public String deleteTeacherById(@PathVariable Long id) {
		return this.service.deleteTeacherById(id);
	}

}