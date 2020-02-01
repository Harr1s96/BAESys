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
@CrossOrigin
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
	public Module getModuleById(@PathVariable(value = "moduleId") Long id) {
		return this.service.getModuleById(id);
	}

	@PutMapping("/teachers/module/{moduleId}")
	public Module updateModuleById(@PathVariable(value = "moduleId") Long id, @RequestBody Module module) {
		return this.service.updateModuleById(module, id);

	}

	@PutMapping("/module/{moduleId}")
	public Module updateLecturesByModuleId(@PathVariable(value = "moduleId") Long id, @RequestBody List<Lecture> lectureList) {
		return this.service.updateLecturesByModuleId(id, lectureList);
	}

	@DeleteMapping("/teachers/module/{moduleId}")
	public String deleteModuleById(@PathVariable(value = "moduleId") Long id) {
		return this.service.deleteModuleById(id);
	}

}