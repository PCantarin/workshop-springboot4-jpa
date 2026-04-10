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
	 * Retrieves an User by its unique identifier.
	 *
	 * @param id the ID of the user to be retrieved
	 * @return the User entity corresponding to the given ID
	 */
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
	/**
	 * Persists a new user into the database.
	 * * @param obj The user entity to be saved.
	 * @return The saved user entity, including the generated primary key.
	 */
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	/**
	 * Deletes an user from the database.
	 * * @param id The id of the user that will be deleted.
	 */
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	/**
	 * Updates an existing user's information.
	 * * @param id The unique identifier of the user to be updated.
	 * @param obj The object containing the updated data.
	 * @return The updated and persisted user entity.
	 */
	public User update(Long id, User obj) {
		User entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	/**
	 * Updates the data of an existing user entity with information from a new object.
	 * * @param entity The existing entity currently managed by the persistence context.
	 * @param obj The object containing the new data to be applied.
	 */
	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
	
}
