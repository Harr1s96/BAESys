// package com.bae.universalapp.service;

// import java.util.List;

// import com.bae.universalapp.persistence.domain.Lecture;
// import com.bae.universalapp.persistence.repo.LectureRepo;

// import org.springframework.stereotype.Service;

// /**
// * LectureService
// */
// @Service
// public class LectureService {

// private LectureRepo lectureRepo;

// public LectureService(LectureRepo repo) {
// this.lectureRepo = repo;
// }

// public Lecture addLecture(Lecture lecture) {

// return this.lectureRepo.save(lecture);

// }

// public Lecture getLectureById(Long id) {

// return this.lectureRepo.findById(id).get();
// }

// public List<Lecture> getAllLectures() {

// return this.lectureRepo.findAll();
// }

// public Lecture updateLectureById(Lecture Lecture, Long id) {

// Lecture toUpdate = this.lectureRepo.findById(id).get();
// toUpdate.setLectureName(Lecture.getLectureName());

// return toUpdate;
// }

// public String deleteLectureById(Long id) {

// this.lectureRepo.deleteById(id);

// boolean LectureCheck = this.lectureRepo.existsById(id);

// if (LectureCheck) {
// return "Lecture has not been deleted";
// }
// return "Lecture deleted sucessfully";
// }
// }