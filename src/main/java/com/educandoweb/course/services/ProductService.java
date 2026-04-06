package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	/**
	 * Retrieves all products registered in the database.
	 *
	 * @return a list of all products
	 */
	public List<Product> findAll(){
		return repository.findAll();
	}

	/**
	 * Retrieves a Product by its unique identifier.
	 *
	 * @param id the ID of the product to be retrieved
	 * @return the Product entity corresponding to the given ID
	 */
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
	
}
