package com.bae.universalapp.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import com.bae.universalapp.persistence.domain.User;
import com.bae.universalapp.service.UserService;
import org.springframework.web.bind.annotation.*;

/**
 * UserController
 */
@RestController
public class UserController {

	private UserService service;

	public UserController(UserService service) {
		this.service = service;
	}

	@PostMapping("/user")
	public User addUser(@RequestBody User user) {
		return this.service.addUser(user);
	}

	@GetMapping("/getUsers")
	public List<User> getAllUsers() {
		return this.service.getAllUsers();

	}

	@GetMapping("/user/{userId}")
	public User getUserById(@PathVariable(value = "userId") Long id) {
		return this.service.getUserById(id);
	}

	@PutMapping("/updateUser")
	public User updateUserById(@PathParam("id") Long id, @RequestBody User user) {
		return this.service.updateUserById(user, id);

	}

	@DeleteMapping("/user/{userId}")
	public String deleteUserById(@PathVariable(value = "userId") Long id) {
		return this.service.deleteUserById(id);
	}
	
	@DeleteMapping("/deleteAllUsers")
	public String deleteAllUsers() {
		return this.service.deleteAllUsers();
	}

}