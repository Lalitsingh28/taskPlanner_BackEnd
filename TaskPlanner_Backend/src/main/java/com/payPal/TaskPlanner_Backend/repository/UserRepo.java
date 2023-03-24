package com.payPal.TaskPlanner_Backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payPal.TaskPlanner_Backend.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

}
