package com.bae.universalapp.rest;

import java.util.List;
import javax.websocket.server.PathParam;

import com.bae.universalapp.persistence.domain.Lecture;
import com.bae.universalapp.service.LectureService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;

/**
 * LectureController
 */
@CrossOrigin
@RestController
public class LectureController {

    private LectureService service;

    public LectureController(LectureService service) {
        this.service = service;
    }

    @PostMapping("/module/lectures")
    public Lecture addLecture(@RequestBody Lecture lecture) {
        return this.service.addLecture(lecture);
    }

    @GetMapping("/lecture")
    public List<Lecture> getAllLectures() {
        return this.service.getAllLectures();
    }

    @GetMapping("/lecture/{lectureId}")
    public Lecture getLectureById(@PathVariable(value = "lectureId") Long id) {

        return this.service.getLectureById(id);
    }

    @PutMapping("/lecture")
    public Lecture updateLectureById(@PathParam("id") Long id, @RequestBody Lecture lecture) {
        return this.service.updateLectureById(lecture, id);

    }

    @DeleteMapping("/lecture/{lectureId}")
    public String deleteLectureById(@PathVariable(value = "lectureId") Long id) {
        return this.service.deleteLectureById(id);
    }

}