package com.bae.universalapp.rest;

import java.util.List;
import javax.websocket.server.PathParam;

import com.bae.universalapp.persistence.domain.Lecture;
import com.bae.universalapp.persistence.domain.Module;
import com.bae.universalapp.persistence.repo.ModuleRepo;
import com.bae.universalapp.service.LectureService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

/**
 * LectureController
 */
@RestController
public class LectureController {

    private LectureService service;
    // private ModuleRepo moduleRepo;

    public LectureController(LectureService service) {
        this.service = service;
    }

    @PostMapping("/module/lectures")
    public Lecture addLecture(@RequestBody Lecture lecture) {

        // Module module = this.moduleRepo.findById(id).orElseThrow(ResourceNotFoundException::new);
        // lecture.setModule(module);
        return this.service.addLecture(lecture);
    }

    // @PostMapping("/module/{moduleId}lectures")
    // public List<Lecture> addLectureList(@PathVariable(value = "moduleId") Long id,
    //         @RequestBody List<Lecture> lectureList) {
        
    //     return this.service.addLectureList(lectureList);
    // }

    @GetMapping("/lecture")
    public List<Lecture> getAllLectures() {
        return this.service.getAllLectures();
    }

    @GetMapping("/lecture/{id}")
    public Lecture getLectureById(@PathVariable(value = "id") Long id) {

        return this.service.getLectureById(id);
    }

    @PutMapping("/lecture")
    public Lecture updateLectureById(@PathParam("id") Long id, @RequestBody Lecture lecture) {
        return this.service.updateLectureById(lecture, id);

    }

    @DeleteMapping("/lecture/{id}")
    public String deleteLectureById(@PathVariable Long id) {
        return this.service.deleteLectureById(id);
    }

}