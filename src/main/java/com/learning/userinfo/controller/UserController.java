package com.learning.userinfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.userinfo.entity.User;
import com.learning.userinfo.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/addUser")
	public ResponseEntity<User> addUser(@RequestBody User user){
		
	    User savedUser = userService.addUser(user);
		return new ResponseEntity<>(savedUser,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/fetchUserById/{userId}")
	public ResponseEntity<User> fetchUserDetailsById(@PathVariable Integer userId){
		
		return userService.fetchUserById(userId);
		
		
	}
	

}
