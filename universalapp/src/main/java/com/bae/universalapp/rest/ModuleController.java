package com.bae.universalapp.rest;

import com.bae.universalapp.service.ModuleService;
import java.util.List;

import com.bae.universalapp.persistence.domain.Lecture;
import com.bae.universalapp.persistence.domain.Module;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

/**
 * ModuleController
 */
@RestController
public class ModuleController {

	private ModuleService service;

	public ModuleController(ModuleService service) {
		this.service = service;
	}

	@PostMapping("/teachers/modules")
	public Module addModule(@RequestBody Module module) {

		this.service.verifyModuleCode(module);
		return this.service.addModule(module);
	}

	@GetMapping("/teachers/modules")
	public List<Module> getAllModules() {
		return this.service.getAllModules();

	}

	@GetMapping("/teachers/modules/{moduleId}")
	public Module getModuleById(@PathVariable Long id) {
		return this.service.getModuleById(id);
	}

	@PutMapping("/teachers/module/{moduleId}")
	public Module updateModuleById(@PathVariable Long id, @RequestBody Module teacher) {
		return this.service.updateModuleById(teacher, id);

	}

	@PutMapping("/module/{moduleId}")
	public List<Lecture> updateLecturesByModuleId(@PathVariable(value = "moduleId") Long id, @RequestBody List<Lecture> lectureList) {
		return this.service.updateLecturesByModuleId(id, lectureList);
	}

	@DeleteMapping("/teachers/module/{id}")
	public String deleteModuleById(@PathVariable Long id) {
		return this.service.deleteModuleById(id);
	}

}