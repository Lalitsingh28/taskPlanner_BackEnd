package com.payPal.TaskPlanner_Backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.payPal.TaskPlanner_Backend.entity.Task;

@Repository
public interface TaskRepo extends JpaRepository<Task, Integer>{
	
	List<Task> findBySprint(Integer sprintId);
	
    List<Task> findByAssignee(Integer assigneeId);

}
