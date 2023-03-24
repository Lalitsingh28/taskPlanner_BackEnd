package com.payPal.TaskPlanner_Backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payPal.TaskPlanner_Backend.entity.Sprint;
import com.payPal.TaskPlanner_Backend.entity.Task;
import com.payPal.TaskPlanner_Backend.entity.TaskStatus;
import com.payPal.TaskPlanner_Backend.entity.User;
import com.payPal.TaskPlanner_Backend.exception.SprintException;
import com.payPal.TaskPlanner_Backend.exception.TaskException;
import com.payPal.TaskPlanner_Backend.exception.UserException;
import com.payPal.TaskPlanner_Backend.repository.SprintRepo;
import com.payPal.TaskPlanner_Backend.repository.TaskRepo;
import com.payPal.TaskPlanner_Backend.repository.UserRepo;

@Service
public class TaskServiceImplementation implements TaskService{
	
	@Autowired
	private TaskRepo taskRepo;
	
	@Autowired
	private SprintRepo sprintRepo;
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public Task createTask(Task task) {
		Task savedTask = taskRepo.save(task);
		return savedTask;
	}

	@Override
	public List<Task> getAllTasksBySprint(Integer sprintId) throws TaskException, SprintException {
		
		Optional<Sprint> sprint =  sprintRepo.findById(sprintId);
		if(sprint.isPresent()) {
			
			List<Task>  taskList = taskRepo.findBySprint(sprintId);
			if(!taskList.isEmpty()) {
				return taskList;
			}else {
				throw new TaskException("There is no task available");
			}
			
		}else {
			throw new SprintException("There is no sprint with Id : "+ sprintId);
		}
		
	}

	@Override
	public List<Task> getAllTasksByAssignee(Integer assigneeId) throws UserException, TaskException {
		Optional<User> optUser =  userRepo.findById(assigneeId);
		if(optUser.isPresent()) {
			
			List<Task> taskList =  taskRepo.findByAssignee(assigneeId);
			if(taskList.size()!=0) {
				return taskList;
			}else {
				throw new TaskException("There are no task Assigned to assignee with Id : "+ assigneeId);
			}
			
		}else {
			throw new UserException("There is No assignee with Id : "+ assigneeId);
		}
	}

	@Override
	public Task updateTaskAssignee(Integer taskId, Integer assigneeId) throws UserException, TaskException {
		Optional<Task> optTask = taskRepo.findById(taskId);
		if(optTask.isPresent()) {
			Optional<User> optUser = userRepo.findById(assigneeId);
			if(optUser.isPresent()) {
				 optTask.get().setAssignee(optUser.get());
				 Task task = taskRepo.save(optTask.get());
				 return task;
			}else {
				throw new UserException("There is no User with Id : "+assigneeId);
			}
		}else {
			throw new TaskException("There is no task with Id : "+ taskId);
		}
	}

	@Override
	public Task updateTaskStatus(Integer taskId, TaskStatus status) throws TaskException {
		Optional<Task> optTask = taskRepo.findById(taskId);
		if(optTask.isPresent()) {
			optTask.get().setStatus(status);
			Task task =  taskRepo.save(optTask.get());
			return task;
		}else {
			throw new TaskException("There is no task with Id : "+ taskId);
		}
	}

}
