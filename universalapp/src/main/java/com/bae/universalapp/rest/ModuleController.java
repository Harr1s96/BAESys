package com.bae.universalapp.rest;

import com.bae.universalapp.service.ModuleService;
import java.util.List;
import javax.websocket.server.PathParam;
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

	@PutMapping("/updateModule")
	public Module updateModuleById(@PathParam("id") Long id, @RequestBody Module teacher) {
		return this.service.updateModuleById(teacher, id);

	}

	@DeleteMapping("/deleteModule/{id}")
	public String deleteModuleById(@PathVariable Long id) {
		return this.service.deleteModuleById(id);
	}

}