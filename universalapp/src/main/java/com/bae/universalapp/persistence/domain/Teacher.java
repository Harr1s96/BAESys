package com.bae.universalapp.persistence.domain;

import java.util.Set;
import javax.persistence.*;

/**
 * Lecturer
 */
@Entity
public class Teacher {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstName;
    private String lastName;

    @OneToMany
    @JoinColumn(name="teacher_id")
    private Set<Module> modules;

    public Teacher() {

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

    
}