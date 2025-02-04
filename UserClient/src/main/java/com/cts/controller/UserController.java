package com.cts.controller;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.model.User;

import com.cts.service.UserService;

@RestController
@Validated
public class UserController {
 
	@Autowired
	UserService userService;

	@GetMapping("/users")
	public List<User> getAllUser(){
		return userService.getAllUser();
	}
	@PostMapping("/user")
	public void insertStudent(@Valid @RequestBody User user) {
		userService.saveUser(user);
	}
	
	@GetMapping("/assignedstory/{username}")
	public Long getId(@PathVariable String username)
	{
		return userService.getId(username);
	}	
	
}
