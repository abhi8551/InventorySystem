package com.userSpringH2.repositories;

import org.springframework.data.repository.CrudRepository;

import com.userSpringH2.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	User findById(int id);

	User findByUsername(String username);
}
