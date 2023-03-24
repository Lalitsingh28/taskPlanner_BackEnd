package com.payPal.TaskPlanner_Backend.service;

import java.util.List;

import com.payPal.TaskPlanner_Backend.entity.Sprint;
import com.payPal.TaskPlanner_Backend.entity.Task;
import com.payPal.TaskPlanner_Backend.exception.SprintException;
import com.payPal.TaskPlanner_Backend.exception.TaskException;

public interface SprintService {
	
	public Sprint createSprint(Sprint sprint);
	
	public List<Sprint> getAllSprints() throws SprintException;
	
	public List<Task> getAllTaskByWeekDays(String day) throws TaskException;

}
