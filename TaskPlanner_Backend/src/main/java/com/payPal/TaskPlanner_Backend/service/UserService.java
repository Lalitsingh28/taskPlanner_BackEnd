package com.payPal.TaskPlanner_Backend.service;

import java.util.List;

import com.payPal.TaskPlanner_Backend.entity.User;
import com.payPal.TaskPlanner_Backend.exception.UserException;

public interface UserService {
	
	public User addUser(User user);
	
	public String deleteUser(Integer userId) throws UserException;
	
	public List<User> getAllUser()throws UserException;
	
	public User getUserById(Integer userId)throws UserException;

}
