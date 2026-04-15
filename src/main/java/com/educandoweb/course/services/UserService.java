package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.exceptions.DatabaseException;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

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
	 * Retrieves a user by their unique identifier.
	 *
	 * @param id The ID of the user to be retrieved.
	 * @return The user entity corresponding to the given ID.
	 * @throws ResourceNotFoundException If no user is found with the given ID.
	 */
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
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
     * Deletes a user from the database by their ID.
     *
     * @param id The ID of the user to be deleted.
     * @throws ResourceNotFoundException If the user is not found.
     * @throws DatabaseException If the deletion violates database constraints.
     */
	public void delete(Long id) {
		repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	/**
     * Updates an existing user's information.
     *
     * @param id The unique identifier of the user to be updated.
     * @param obj The object containing the updated data.
     * @return The updated and persisted user entity.
     * @throws ResourceNotFoundException If no user is found with the given ID.
     */
	public User update(Long id, User obj) {
		try {
			User entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
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
