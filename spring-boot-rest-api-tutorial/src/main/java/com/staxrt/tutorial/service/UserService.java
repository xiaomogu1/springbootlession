package com.staxrt.tutorial.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.staxrt.tutorial.application.UserMapper;
import com.staxrt.tutorial.exception.ResourceNotFoundException;
import com.staxrt.tutorial.model.User;
import com.staxrt.tutorial.model.UserReq;
import com.staxrt.tutorial.model.UserResp;
import com.staxrt.tutorial.repository.UserRepository;

@Component
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Autowired
	private UserMapper userMapper;
	
	
	public List<UserResp> findAll() {
		List<User> users = userRepository.findAll();
		
		return users
		  .stream()
		  .map(user -> userMapper.mapFrom(user))
		  .collect(Collectors.toList());
	}
	
	public UserResp findUserById(long userId) throws ResourceNotFoundException {
		 User user = userRepository
         .findById(userId)
         .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
		 return userMapper.mapFrom(user);
	}

	public UserResp save(User user) {
		User u = userRepository.save(user);
		return userMapper.mapFrom(u);
	}
	
	public UserResp update(long userId, UserReq userReq ) throws ResourceNotFoundException {
		User user = userRepository
		         .findById(userId)
		         .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));

	    user.setEmail(userReq.getEmail());
	    user.setLastName(userReq.getLastName());
	    user.setFirstName(userReq.getFirstName());
	    user.setUpdatedAt(new Date());
	    return save(user);
		
	}

	public void delete(long userId) throws ResourceNotFoundException {
		User user = userRepository
		         .findById(userId)
		         .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
		userRepository.delete(user);
	}

}
