package com.educandoweb.course.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@GetMapping
	public ResponseEntity<User> findAll(){
		User user = new User(1L, "Pedro", "pedro@gmail.com", "(19) 99999-9999", "12345");
		return ResponseEntity.ok().body(user);
	}
	
}
