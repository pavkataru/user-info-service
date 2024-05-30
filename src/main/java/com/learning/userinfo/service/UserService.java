package com.learning.userinfo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.learning.userinfo.entity.User;
import com.learning.userinfo.repository.UserRepo;

@Service
public class UserService {
	
	
	@Autowired
	UserRepo userRepo;

	public User addUser(User user) {
		// TODO Auto-generated method stub
		
		return userRepo.save(user);
		
	}

	public ResponseEntity<User> fetchUserById(Integer userId) {
		// TODO Auto-generated method stub
		Optional<User> fetchedUser = userRepo.findById(userId);
		if(fetchedUser.isPresent()) {
			return new ResponseEntity<>(fetchedUser.get(),HttpStatus.OK);
		}else
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		
	}
	
	

}
