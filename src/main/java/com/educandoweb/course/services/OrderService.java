package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	/**
	 * Retrieves all orders registered in the database.
	 *
	 * @return a list of all orders
	 */
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	/**
	 * Retrieves an Order by its unique identifier.
	 *
	 * @param id the ID of the order to be retrieved
	 * @return the Order entity corresponding to the given ID
	 */
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
	
}
