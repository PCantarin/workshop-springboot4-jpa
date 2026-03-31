package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	/**
	 * Retrieves all users registered in the database.
	 *
	 * @return a list of all users
	 */
	public List<User> findAll(){
		return repository.findAll();
	}
	
	/**
	 * Retrieves a User by its unique identifier.
	 *
	 * @param id the ID of the user to be retrieved
	 * @return the User entity corresponding to the given ID
	 */
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
}
