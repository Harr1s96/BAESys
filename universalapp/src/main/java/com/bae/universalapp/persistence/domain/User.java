package com.bae.universalapp.persistence.domain;

import java.util.Objects;

import javax.persistence.*;

/**
 * User
 */
@Entity
public class User {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String email;
    private String password;

    public User() {

    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }
        if (Objects.isNull(obj)) {
            return false;
        }
        if (this.getClass() == obj.getClass()) {
            return true;
        }
        return super.equals(obj);
    }    
}