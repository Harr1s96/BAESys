package com.bae.universalapp.service;

import java.util.List;

import com.bae.universalapp.persistence.domain.Lecture;
import com.bae.universalapp.persistence.repo.LectureRepo;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

/**
 * LectureService
 */
@Service
public class LectureService {

    private LectureRepo lectureRepo;

    public LectureService(LectureRepo repo) {
        this.lectureRepo = repo;
    }

    public Lecture addLecture(Lecture lecture) {
        return this.lectureRepo.save(lecture);

    }

    public Lecture getLectureById(Long id) {
        return this.lectureRepo.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public List<Lecture> getAllLectures() {
        return this.lectureRepo.findAll();
    }

    public Lecture updateLectureById(Lecture lecture, Long id) {

        Lecture toUpdate = this.lectureRepo.findById(id).orElseThrow(ResourceNotFoundException::new);
        toUpdate.setLectureName(lecture.getLectureName());

        return this.lectureRepo.save(toUpdate);
    }

    public String deleteLectureById(Long id) {

        this.lectureRepo.deleteById(id);

        boolean lectureCheck = this.lectureRepo.existsById(id);

        if (lectureCheck) {
            return "Lecture has not been deleted";
        }
        return "Lecture deleted successfully";
    }

}