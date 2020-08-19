package com.cts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.exception.UserNotFoundException;
import com.cts.model.User;
import com.cts.repository.UserRepository;

@Service
@Transactional
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public List<User> getAllUser(){
		return (List<User>) userRepository.findAll();
	}
	public void saveUser(User user) {
		userRepository.save(user);
	}
		

	public Long getId(String username) {
		return userRepository.getIdByUsername(username);
	}
	
}
