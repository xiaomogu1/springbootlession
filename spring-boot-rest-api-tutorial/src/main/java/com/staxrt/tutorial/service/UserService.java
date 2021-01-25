package com.staxrt.tutorial.service;

import com.staxrt.tutorial.dao.UserMapper;
import com.staxrt.tutorial.exception.ResourceNotFoundException;
import com.staxrt.tutorial.model.User;
import com.staxrt.tutorial.model.UserFromUrl;
import com.staxrt.tutorial.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public List<UserFromUrl> findAll() {
        List<User> users = userRepository.findAll();

        return users.stream()
                .map(user -> userMapper.mapFromUrl(user))
                .collect(Collectors.toList());
    }

    public UserFromUrl findById(Long userId) throws ResourceNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user not found on " + userId));
        return userMapper.mapFromUrl(user);
    }

    public UserFromUrl save(User user){
        User user1 =userRepository.save(user);
        return userMapper.mapFromUrl(user1);
    }

    public void deleteById(Long userId) throws ResourceNotFoundException{
        User user = userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("user not found" + userId));
        userRepository.delete(user);
    }


}
