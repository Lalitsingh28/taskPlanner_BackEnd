package com.payPal.TaskPlanner_Backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payPal.TaskPlanner_Backend.entity.Task;

public interface TaskRepo extends JpaRepository<Task, Integer>{
	
	List<Task> findBySprintId(Integer sprintId);
    List<Task> findByAssigneeId(Integer assigneeId);

}
