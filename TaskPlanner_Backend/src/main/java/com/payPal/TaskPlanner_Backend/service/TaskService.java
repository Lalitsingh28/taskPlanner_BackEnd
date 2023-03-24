package com.payPal.TaskPlanner_Backend.service;

import java.util.List;

import com.payPal.TaskPlanner_Backend.entity.Task;
import com.payPal.TaskPlanner_Backend.entity.TaskStatus;
import com.payPal.TaskPlanner_Backend.exception.SprintException;
import com.payPal.TaskPlanner_Backend.exception.TaskException;
import com.payPal.TaskPlanner_Backend.exception.UserException;

public interface TaskService {
	
	public Task createTask(Task task);
	
	public List<Task> getAllTasksBySprint(Integer sprintId) throws TaskException, SprintException;
	
	public List<Task> getAllTasksByAssignee(Integer assigneeId) throws UserException, TaskException;
	
	public Task updateTaskAssignee(Integer taskId, Integer assigneeId) throws UserException, TaskException;
	
	public Task updateTaskStatus(Integer taskId, TaskStatus status) throws TaskException;

}
