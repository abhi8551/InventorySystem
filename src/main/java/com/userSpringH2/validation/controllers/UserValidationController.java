package com.userSpringH2.validation.controllers;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userSpringH2.entities.User;
import com.userSpringH2.validation.services.UserValidationService;

@RestController
@RequestMapping("/validate")
public class UserValidationController {
	
	@Autowired
	UserValidationService userValidationService;
	
	@PostMapping("/users")
    private String validateUser(@RequestBody User user) throws UnsupportedEncodingException {
		return userValidationService.validateUser(user);
    }
}