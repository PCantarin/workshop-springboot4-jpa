package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	
	/**
	 * Retrieves all categories registered in the database.
	 *
	 * @return a list of all categories
	 */
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	/**
	 * Retrieves a Category by its unique identifier.
	 *
	 * @param id the ID of the category to be retrieved
	 * @return the Category entity corresponding to the given ID
	 */
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
	
}
