package com.payPal.TaskPlanner_Backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payPal.TaskPlanner_Backend.entity.User;
import com.payPal.TaskPlanner_Backend.exception.UserException;
import com.payPal.TaskPlanner_Backend.repository.UserRepo;

@Service
public class UserServiceImplementation implements UserService{
	
	@Autowired
	private UserRepo userRepo;
	

	@Override
	public User addUser(User user) {
		User savedUser = userRepo.save(user);
		return savedUser;
	}

	@Override
	public String deleteUser(Integer userId) throws UserException {
		Optional<User> optionalUser =  userRepo.findById(userId);
		
		if(optionalUser.isPresent()) {
			userRepo.deleteById(userId);
			return "User Deleted by Id : "+userId;
		}else {
			throw new UserException("User Not Available with ID : "+ userId);
		}
	}

	@Override
	public List<User> getAllUser() throws UserException {
		List<User> userList =  userRepo.findAll();
		if(!userList.isEmpty()) {
			return userList;
		}else {
			throw new UserException("No Users Are Avilable");
		}
	}

	@Override
	public User getUserById(Integer userId) throws UserException {
		
		Optional<User> optionalUser =  userRepo.findById(userId);
		
		if(optionalUser.isPresent()) {
			User user = userRepo.findById(userId).get();
			return user;
		}else {
			throw new UserException("User Not Available with ID : "+ userId);
		}
	}

}
