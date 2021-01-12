package com.staxrt.tutorial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.staxrt.tutorial.model.User;
import com.staxrt.tutorial.repository.UserRepository;

@Component
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	public List<User> findAll() {
		/**
		 * 
		 * 
		 * 
		 * 
		 */
		return userRepository.findAll();
	}

}
