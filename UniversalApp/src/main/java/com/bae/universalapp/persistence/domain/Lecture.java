package com.bae.universalapp.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Id;

/**
 * Lecture
 */
@Entity
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lectureName;

    public Lecture() {

    }

    public Lecture(String lectureName) {
        this.lectureName = lectureName;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param lectureName the lectureName to set
     */
    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    /**
     * @return the lectureName
     */
    public String getLectureName() {
        return lectureName;
    }
    
    @Override
    public String toString() {
        return "Lecture [id=" + this.id + ", lectureName=" + this.lectureName + "]";
    }
    
   @Override
   public boolean equals(Object obj) {
       
       if (this == obj) {
           return true;
       }
       if (obj == null) {
           return false;
       }
       if (this.getClass() == obj.getClass()) {
           return true;
       }
       return super.equals(obj);
   }
}