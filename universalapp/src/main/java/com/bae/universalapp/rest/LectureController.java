package com.bae.universalapp.rest;

import java.util.List;
import javax.websocket.server.PathParam;

import com.bae.universalapp.persistence.domain.Lecture;
import com.bae.universalapp.persistence.domain.Module;
import com.bae.universalapp.persistence.repo.ModuleRepo;
import com.bae.universalapp.service.LectureService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
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

    @Autowired
    private ModuleRepo moduleRepo;

    @PostMapping("/module/{moduleId}/lectures")
    public Lecture addLecture(@PathVariable(value="moduleId") Long id, @RequestBody Lecture lecture)
    throws ResourceNotFoundException {

        try {
		Module module = this.moduleRepo.findById(id).get();
		lecture.setModule(module);
		} catch (ResourceNotFoundException e) {
		e.printStackTrace();
		}

        // Module myModule = new Module();
        // myModule.setModuleCode("CHEM 333");
        // myModule.setModuleName("Further Organic Chemistry");

        return this.service.addLecture(lecture);
    }

    @GetMapping("/lecture")
    public List<Lecture> getAllLectures() {
        return this.service.getAllLectures();
    }

    @GetMapping("/lecture/{id}")
    public Lecture getOneLecture(@PathVariable(value = "id") Long id) {

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