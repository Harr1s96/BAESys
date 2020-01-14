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

	// @Override
	// public boolean equals(Object obj) {
        
    //     if (this == obj)
	// 		return true;
        
    //     if (obj == null)
	// 		return false;
        
    //     if (getClass() != obj.getClass())
	// 		return false;
        
    //     Lecture other = (Lecture) obj;
	// 	if (id == null) {
	// 		if (other.id != null)
	// 			return false;
    //     } 
    //     else if (!id.equals(other.id))
	// 		return false;
        
    //     if (lectureName == null) {
	// 		if (other.lectureName != null)
	// 			return false;
    //     } 
    //     else if (!lectureName.equals(other.lectureName))
	// 		return false;
        
    //     return true;
    // }
    
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