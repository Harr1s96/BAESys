package com.bae.universalapp.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import com.bae.universalapp.persistence.domain.User;
import com.bae.universalapp.service.UserService;

//import org.springframework.beans.factory.annotation.Autowired;
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
	
	@PostMapping("/createUser")
	public User addUser(@RequestBody User user) {
		return this.service.addUser(user);
	}
	
	@GetMapping("/getUsers")
	public List<User> getAllUsers() {
		return this.service.getAllUsers();
	
	// @GetMapping("/getUserById/{id}")
	// public User getOneUser(Long id) {
	// 	return this.service.getUserById(id);
	// }
		
	}
	@PutMapping("/updateUser")
	public User updateUserById(@PathParam("id") Long id, @RequestBody User user) {
		return this.service.updateUserById(user, id);
		
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public void deleteUserById(@PathVariable Long id) {
		this.service.deleteUserById(id);
	}

}