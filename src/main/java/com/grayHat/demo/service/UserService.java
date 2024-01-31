package com.grayHat.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grayHat.demo.entities.User;
import com.grayHat.demo.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User insert (User user) {
		return userRepository.save(user);
	}
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
}
