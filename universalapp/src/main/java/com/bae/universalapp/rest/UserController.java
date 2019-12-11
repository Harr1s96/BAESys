package com.bae.universalapp.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import com.bae.universalapp.persistence.domain.User;
import com.bae.universalapp.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * UserController
*/
@RestController
public class UserController {

    @Autowired
	private UserService service;
	
	@PostMapping("/createUser")
	public User createUser (@RequestBody User user) {
		return this.service.addUser(user);
	}
	
	@GetMapping("/getUsers")
	public List<User> readUsers() {
		return this.service.getAllUsers();
		
	}
	@PutMapping("/updateUser")
	public User updateUser(@PathParam("id")Long id, @RequestBody User user) {
		return this.service.updateUserById(user, id);
		
	}
	@DeleteMapping("/deleteUser/{id}")
	public void deleteUserById(@PathVariable Long id) {
		this.service.deleteUserById(id);
	}

}