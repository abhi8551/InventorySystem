package com.userSpringH2.utility;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userSpringH2.entities.User;
import com.userSpringH2.repositories.UserRepository;

@Service
public class UserUtility {

	@Autowired
	UserRepository userRepository;

	public boolean checkIfPresent(String username) {
		User user = userRepository.findByUsername(username);
		return user != null;
	}

	public static String encode(String str) throws UnsupportedEncodingException {
		return Base64.getEncoder().encodeToString(str.getBytes("utf-8"));
	}
}