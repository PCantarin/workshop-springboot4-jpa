package com.educandoweb.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Pedro", "pedro@gmail.com", "19 91234-5678", "12345");
		User u2 = new User(null, "Cantarin", "cantarin@gmail.com", "19 98765-4321", "12345");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		
	}
	
}
