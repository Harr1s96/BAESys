// package com.bae.universalapp.persistence.domain;

// import javax.persistence.Entity;

// import java.util.List;

// import javax.persistence.*;

// import javax.persistence.Id;

// //import javax.persistence.Entity;

// /**
// * Lecture
// */
// @Entity
// public class Lecture {

// @Id
// @GeneratedValue(strategy = GenerationType.AUTO)
// private Long id;

// private String lectureName;

// @OneToOne
// @JoinColumn(name="lecture_id")
// private List<Module> modules;

// public Lecture() {

// }

// /**
// * @param modules the modules to set
// */
// public void setModules(List<Module> modules) {
// this.modules = modules;
// }

// /**
// * @return the modules
// */
// public List<Module> getModules() {
// return modules;
// }

// /**
// * @param id the id to set
// */
// public void setId(Long id) {
// this.id = id;
// }

// /**
// * @return the id
// */
// public Long getId() {
// return id;
// }

// /**
// * @param lectureName the lectureName to set
// */
// public void setLectureName(String lectureName) {
// this.lectureName = lectureName;
// }

// /**
// * @return the lectureName
// */
// public String getLectureName() {
// return lectureName;
// }

// }