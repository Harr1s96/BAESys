package com.bae.universalapp.persistence.domain;

import javax.persistence.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Module
 */
@Entity
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String moduleName;
    private String moduleCode;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "module_id")
    private List<Lecture> lectures = new ArrayList<>();

    public Module() {

    }

    public Module(String moduleName, String moduleCode) {
        this.moduleName = moduleName;
        this.moduleCode = moduleCode;
    }

    /**
     * @param lectures the lectures to set
     */
    public void setLectures(List<Lecture> lectures) {
        this.lectures = lectures;
    }

    /**
     * @return the lectures
     */
    public List<Lecture> getLectures() {
        return this.lectures;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @param moduleName the moduleName to set
     */
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    /**
     * @param moduleCode the moduleCode to set
     */
    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the moduleName
     */
    public String getModuleName() {
        return moduleName;
    }

    /**
     * @return the moduleCode
     */
    public String getModuleCode() {
        return moduleCode;
    }

   @Override
   public boolean equals(Object obj) {
       
       if (this == obj) {
           return true;
       }
       if (null == obj) {
           return false;
       }
       if (this.getClass() == obj.getClass()) {
           return true;
       }
       return super.equals(obj);
   }

	// @Override
	// public boolean equals(Object obj) {
        
    //     if (this == obj)
	// 		return true;
        
    //     if (obj == null)
	// 		return false;
        
    //     if (getClass() != obj.getClass())
	// 		return false;
        
    //     Module other = (Module) obj;
	// 	if (id == null) {
	// 		if (other.id != null)
	// 			return false;
    //     } 
    //     else if (!id.equals(other.id))
	// 		return false;
        
    //     if (lectures == null) {
	// 		if (other.lectures != null)
	// 			return false;
    //     } 
    //     else if (!lectures.equals(other.lectures))
	// 		return false;
        
    //     if (moduleCode == null) {
	// 		if (other.moduleCode != null)
	// 			return false;
    //     } 
    //     else if (!moduleCode.equals(other.moduleCode))
	// 		return false;
        
    //     if (moduleName == null) {
	// 		if (other.moduleName != null)
	// 			return false;
    //     } 
    //     else if (!moduleName.equals(other.moduleName))
	// 		return false;
        
    //     return true;
	// }

	@Override
    public String toString() {
        return "Module [id=" + this.id + ", moduleCode=" + this.moduleCode + ", moduleName=" + this.moduleName + ", lectures=" + this.lectures + "]";
    }
    
}