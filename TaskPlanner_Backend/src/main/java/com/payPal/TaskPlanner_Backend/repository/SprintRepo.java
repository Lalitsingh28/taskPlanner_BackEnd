package com.payPal.TaskPlanner_Backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payPal.TaskPlanner_Backend.entity.Sprint;

public interface SprintRepo extends JpaRepository<Sprint, Integer>{

}