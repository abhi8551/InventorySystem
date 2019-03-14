package com.userSpringH2.validation.services;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userSpringH2.entities.User;
import com.userSpringH2.repositories.UserRepository;

@Service
public class UserValidationService {

	@Autowired
	UserRepository userRepository;

	public String validateUser(User user) throws UnsupportedEncodingException {
		String username = user.getUsername();
		String password = Base64.getEncoder().encodeToString(user.getPassword().getBytes("utf-8"));
		User rUser = userRepository.findByUsername(username);
		if(rUser!=null && rUser.getPassword().equals(password)) {
			return "Success";
		}
		return "Failure";
	}
}