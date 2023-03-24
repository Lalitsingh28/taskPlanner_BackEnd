package com.payPal.TaskPlanner_Backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payPal.TaskPlanner_Backend.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
