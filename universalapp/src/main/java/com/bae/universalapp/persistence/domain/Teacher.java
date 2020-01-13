package com.bae.universalapp.persistence.domain;

import java.util.List;
import javax.persistence.*;

/**
 * Lecturer
 */
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id")
    private List<Module> modules;

    public Teacher() {

    }

    public Teacher(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * @param modules the modules to set
     */
    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    /**
     * @return the modules
     */
    public List<Module> getModules() {
        return modules;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

	@Override
	public boolean equals(Object obj) {
        
        if (this == obj)
			return true;
        
        if (obj == null)
			return false;
        
        if (getClass() != obj.getClass())
			return false;
        
        Teacher other = (Teacher) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
        } 
        else if (!firstName.equals(other.firstName))
			return false;
        
        if (id == null) {
			if (other.id != null)
				return false;
        } 
        else if (!id.equals(other.id))
			return false;
        
        if (lastName == null) {
			if (other.lastName != null)
				return false;
        } 
        else if (!lastName.equals(other.lastName))
			return false;
        
        if (modules == null) {
			if (other.modules != null)
				return false;
        } 
        else if (!modules.equals(other.modules))
			return false;
        
        return true;
	}

//    @Override
//    public boolean equals(Object obj) {
//        
//        if (this == obj) {
//            return true;
//        }
//        if (Objects.isNull(obj)) {
//            return false;
//        }
//        if (this.getClass() == obj.getClass()) {
//            return true;
//        }
//        return super.equals(obj);
//    }
}