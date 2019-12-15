package com.bae.universalapp.rest;

import java.util.Arrays;
import java.util.List;

import javax.websocket.server.PathParam;

import com.bae.universalapp.persistence.domain.Lecture;
import com.bae.universalapp.persistence.domain.Module;
import com.bae.universalapp.service.LectureService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;

/**
 * LectureController
 */
@RestController
public class LectureController {

    private LectureService service;

    public LectureController(LectureService service) {
        this.service = service;
	}

    @PostMapping("/lecture")
	public Lecture addLecture(@RequestBody Lecture lecture, Module module) {

		// Module myModule = new Module();
		// myModule.setModuleCode("CHEM 333");
		// myModule.setModuleName("Further Organic Chemistry");
		
		lecture.setModules(Arrays.asList(module));
		return this.service.addLecture(lecture);
	}
	
	@GetMapping("/lecture")
	public List<Lecture> getAllLectures() {
		return this.service.getAllLectures();
	}
	
	@GetMapping("/lecture/{id}")
	public Lecture getOneLecture(@PathVariable(value="id") Long id) {
		
		return this.service.getLectureById(id);
	}
		
	@PutMapping("/lecture")
	public Lecture updateTeacherById(@PathParam("id") Long id, @RequestBody Lecture lecture) {
		return this.service.updateLectureById(lecture, id);
		
	}
	
	@DeleteMapping("/lecture/{id}")
	public void deleteLectureById(@PathVariable Long id) {
		this.service.deleteLectureById(id);
	}

    
}