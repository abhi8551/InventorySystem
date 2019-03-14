package com.userSpringH2.services;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userSpringH2.entities.User;
import com.userSpringH2.repositories.UserRepository;
import com.userSpringH2.utility.UserUtility;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		userRepository.findAll().forEach(user -> users.add(user));
		return users;
	}

	public User getUserById(int id) {
		return userRepository.findById(id);
	}

	public void saveOrUpdate(User user) throws UnsupportedEncodingException {
		User updatedUser = new User();
		updatedUser.setId(user.getId());
		updatedUser.setName(user.getName());
		updatedUser.setUsername(user.getUsername());
		//BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		//updatedUser.setPassword(passwordEncoder.encode(user.getPassword()));
		updatedUser.setPassword(UserUtility.encode(user.getPassword()));
		updatedUser.setEmail(user.getEmail());
		userRepository.save(updatedUser);
	}

	public void delete(Long id) {
		userRepository.deleteById(id);
	}
}
