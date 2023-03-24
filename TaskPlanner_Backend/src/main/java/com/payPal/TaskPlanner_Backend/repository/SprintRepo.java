package com.payPal.TaskPlanner_Backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.payPal.TaskPlanner_Backend.entity.Sprint;
import com.payPal.TaskPlanner_Backend.entity.Task;

@Repository
public interface SprintRepo extends JpaRepository<Sprint, Integer>{
	
	@Query("Select s.tasks from Sprint s where s.weekDay like : day")
	List<Task> findByWeekDay(@Param("day") String day);

}
