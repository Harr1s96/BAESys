package com.bae.universalapp.service;

import java.util.List;

import com.bae.universalapp.persistence.domain.User;
import com.bae.universalapp.persistence.repo.UserRepo;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

/**
 * UserService
 */
@Service
public class UserService {

    private UserRepo userRepo;

    public UserService(UserRepo repo) {
        this.userRepo = repo;
    }

    public User addUser(User user) {
        return this.userRepo.save(user);
    }

    public User getUserById(Long id) {
        return this.userRepo.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public List<User> getAllUsers() {
        return this.userRepo.findAll();
    }

    public User updateUserById(User user, Long id) {

        User toUpdate = this.userRepo.findById(id).orElseThrow(ResourceNotFoundException::new);
        toUpdate.setEmail(user.getEmail());
        toUpdate.setPassword(user.getPassword());

        return this.userRepo.save(toUpdate);
    }

    public String deleteUserById(Long id) {

        this.userRepo.deleteById(id);

        boolean userCheck = this.userRepo.existsById(id);

        if (userCheck) {
            return "User has not been deleted";
        }
        return "User deleted successfully";

    }

    public String deleteAllUsers() {

        this.userRepo.truncateUserTable();
        this.userRepo.flush();

        boolean entityCheck = this.userRepo.findAll().isEmpty();

        if (entityCheck) {
            return "User table is not empty";
        }
        return "User table has been emptied successfully";
    }

}