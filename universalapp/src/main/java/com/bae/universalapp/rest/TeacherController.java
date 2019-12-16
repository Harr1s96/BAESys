package com.bae.universalapp.rest;

import java.util.List;
import javax.websocket.server.PathParam;
import com.bae.universalapp.persistence.domain.Module;
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

	@PostMapping("/teacher")
	public Teacher addTeacher(@RequestBody Teacher teacher) {

		// Module myModule = new Module();
		// myModule.setModuleCode(module.getModuleCode());
		// myModule.setModuleName(module.getModuleName());
		// teacher.setModules(Arrays.asList(myModule));

		teacher.setModules(teacher);
		return this.service.addTeacher(teacher);
	}

	@GetMapping("/teacher")
	public List<Teacher> getAllTeachers() {
		return this.service.getAllTeachers();
	}

	@GetMapping("/teacher/{id}")
	public Teacher getOneTeacher(@PathVariable(value = "id") Long id) {

		return this.service.getTeacherById(id);
	}

	@PutMapping("/teacher")
	public Teacher updateTeacherById(@PathParam("id") Long id, @RequestBody Teacher teacher) {
		return this.service.updateTeacherById(teacher, id);

	}

	@DeleteMapping("/teacher/{id}")
	public void deleteTeacherById(@PathVariable Long id) {
		this.service.deleteTeacherById(id);
	}

}