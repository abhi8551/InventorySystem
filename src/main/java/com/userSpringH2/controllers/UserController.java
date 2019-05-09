package com.userSpringH2.controllers;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.userSpringH2.entities.User;
import com.userSpringH2.services.UserService;
import com.userSpringH2.utility.UserUtil;

@RestController
@RequestMapping("/api/")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	UserUtil userUtility;

	@GetMapping("/users")
	private List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/users/{id}")
	private User getPerson(@PathVariable("id") int id) {
		return userService.getUserById(id);
	}

	@DeleteMapping("/users/{id}")
	private void deletePerson(@PathVariable("id") Long id) {
		userService.delete(id);
	}

	@PostMapping("/registration/users/")
	private JsonNode registerUser(@RequestBody User user) throws UnsupportedEncodingException {
		if(userUtility.checkIfPresent(user.getUsername())) {
			return userUtility.statusMessage("User already present!!");
		}
		userService.saveOrUpdate(user);
		return userUtility.statusMessage("User successfully added!!");
	}
	
}