package com.bae.universalapp.service;

import java.util.List;

import com.bae.universalapp.persistence.domain.User;
import com.bae.universalapp.persistence.repo.UserRepo;

//import org.springframework.beans.factory.annotation.Autowired;
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

        return this.userRepo.findById(id).get();
    }

    public List<User> getAllUsers() {

        return this.userRepo.findAll();
    }

    public User updateUserById(User user, Long id) {

        User toUpdate = this.userRepo.findById(id).get();
        toUpdate.setEmail(user.getEmail());
        toUpdate.setPassword(user.getPassword());

        return toUpdate;
    }

    public String deleteUserById(Long id) {

        this.userRepo.deleteById(id);

        boolean userCheck = this.userRepo.existsById(id);

        if (userCheck) {
            String message = "User has not been deleted";
            return message;
        }
        return "User deleted sucessfully";


    }

    
}