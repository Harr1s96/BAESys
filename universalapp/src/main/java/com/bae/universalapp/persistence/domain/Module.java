package com.bae.universalapp.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.*;

/**
 * Module
 */
@Entity
public class Module {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String moduleName;
    private String moduleCode;

    @ManyToOne
    @JoinColumn(name="teacher_id")
    private Teacher teacher;

    public Module() {

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

}