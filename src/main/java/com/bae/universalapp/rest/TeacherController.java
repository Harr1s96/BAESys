package com.bae.universalapp.rest;

import java.util.List;
import javax.websocket.server.PathParam;

import com.bae.universalapp.persistence.domain.Module;
import com.bae.universalapp.persistence.domain.Teacher;
import com.bae.universalapp.service.EmptyModuleListException;
import com.bae.universalapp.service.ModuleService;
import com.bae.universalapp.service.TeacherService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

/**
 * TeacherController
 */
@CrossOrigin
@RestController
public class TeacherController {

	private TeacherService service;
	private ModuleService moduleService;

	public TeacherController(TeacherService service, ModuleService moduleService) {
		this.service = service;
		this.moduleService = moduleService;
	}
 
	@PostMapping("/teacher")
	public Teacher addTeacher(@RequestBody Teacher teacher) throws EmptyModuleListException {

		List<Module> theList = teacher.getModules();
		this.moduleService.verifyModuleCode(theList);
		return this.service.addTeacher(teacher);
	}

	@GetMapping("/teachers")
	public List<Teacher> getAllTeachers() {
		return this.service.getAllTeachers();
	}

	@GetMapping("/teacher/{teacherId}")
	public Teacher getTeacherById(@PathVariable(value = "teacherId") Long id) {

		return this.service.getTeacherById(id);
	}

	@PutMapping("/teacher")
	public Teacher updateTeacherById(@PathParam("id") Long id, @RequestBody Teacher teacher) {
		return this.service.updateTeacherById(teacher, id);

	}

	@PutMapping("/teacher/{teacherId}")
	public Teacher updateModulesByTeacherId(@PathVariable(value = "teacherId") Long id, @RequestBody List<Module> moduleList) {
		return this.service.updateModulesByTeacherId(id, moduleList);
	}

	@DeleteMapping("/teacher/{teacherId}")
	public String deleteTeacherById(@PathVariable(value ="teacherId") Long id) {
		return this.service.deleteTeacherById(id);
	}

}