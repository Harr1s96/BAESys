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
	

    @PostMapping("/teachers/{teacherId}/modules")
	public Module addModule(@PathVariable(value="teacherId") Long id, 
							@RequestBody Module module) {
		
		// return this.teacherRepo.findById(id)
		// 	.map(teacher -> {module.setTeacher(teacher);
		// 	return this.service.addModule(module);})
		// 	.orElseThrow(() -> new ResourceNotFoundException("instructor not found"));
		return this.service.addModule(module);
	}
	
	@GetMapping("/teachers/modules")
	public List<Module> getAllModules() {
		return this.service.getAllModules();
	
	// @GetMapping("/getModuleById/{id}")
	// public Module getOneModule(Long id) {
	// 	return this.service.getModuleById(id);
	// }
		
	}
	@PutMapping("/updateModule")
	public Module updateModuleById(@PathParam("id") Long id, @RequestBody Module teacher) {
		return this.service.updateModuleById(teacher, id);
		
	}
	
	@DeleteMapping("/deleteModule/{id}")
	public void deleteModuleById(@PathVariable Long id) {
		this.service.deleteModuleById(id);
	}

    
}