package com.payPal.TaskPlanner_Backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payPal.TaskPlanner_Backend.entity.Sprint;
import com.payPal.TaskPlanner_Backend.entity.Task;
import com.payPal.TaskPlanner_Backend.entity.TaskStatus;
import com.payPal.TaskPlanner_Backend.entity.User;
import com.payPal.TaskPlanner_Backend.exception.SprintException;
import com.payPal.TaskPlanner_Backend.exception.TaskException;
import com.payPal.TaskPlanner_Backend.exception.UserException;
import com.payPal.TaskPlanner_Backend.service.SprintService;
import com.payPal.TaskPlanner_Backend.service.TaskService;
import com.payPal.TaskPlanner_Backend.service.UserService;

@RestController
@RequestMapping("/api")
public class TaskPlannerController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private SprintService sprintService;
	
	// User Api's
	
	@PostMapping("/user/save")
	public ResponseEntity<User> addUserHandler(@RequestBody User user){
		User savedUser = userService.addUser(user);
		return new ResponseEntity<>(savedUser,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/user/delete/{userId}")
	public ResponseEntity<String> deleteUserHandler(@PathVariable("userId") Integer userId) throws UserException{
		String message =  userService.deleteUser(userId);
		return new ResponseEntity<>(message,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/user")
	public ResponseEntity<List<User>> getAllUserHandler() throws UserException{
		List<User> userList = userService.getAllUser();
		return new ResponseEntity<>(userList,HttpStatus.OK);
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<User> getUserByIdHandler(@PathVariable("userId") Integer userId) throws UserException{
		User user = userService.getUserById(userId);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
		
	// Task Api's
	
	@PostMapping("/task/save")
	public ResponseEntity<Task> addTaskHandler(@RequestBody Task task){
		Task savedTask = taskService.createTask(task);
		return new ResponseEntity<>(savedTask,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/task/sprint/{sprintId}")
	public ResponseEntity<List<Task>> getAllTasksBySprintHandler(@PathVariable("sprintId") Integer sprintId) throws TaskException, SprintException{
		List<Task> taskList = taskService.getAllTasksBySprint(sprintId);
		return new ResponseEntity<List<Task>>(taskList,HttpStatus.OK);
	}
	
	@GetMapping("/task/{assigneeId}")
	public ResponseEntity<List<Task>> getAllTasksByAssigneeHandler(@PathVariable("assigneeId") Integer assigneeId) throws UserException, TaskException{
		List<Task> taskList = taskService.getAllTasksByAssignee(assigneeId);
		return new ResponseEntity<List<Task>>(taskList,HttpStatus.OK);
	}
	
	@PutMapping("/task/{taskId}/{assigneeId}")
	public ResponseEntity<Task> updateTaskAssigneeHandler(@PathVariable("taskId") Integer taskId, @PathVariable("assigneeId") Integer assigneeId) throws UserException, TaskException {
		Task task = taskService.updateTaskAssignee(taskId, assigneeId);
		return new ResponseEntity<>(task,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/task/{taskId}")
	public ResponseEntity<Task> updateTaskStatusHandler(@PathVariable("taskId") Integer taskId, TaskStatus status) throws TaskException{
		Task task = taskService.updateTaskStatus(taskId, status);
		return new ResponseEntity<>(task,HttpStatus.ACCEPTED);
	}
		
	// Sprint Api's
	
	@PostMapping("/sprint/save")
	public ResponseEntity<Sprint> addSprintHandler(@RequestBody Sprint sprint){
		Sprint savedSprint = sprintService.createSprint(sprint);
		return new ResponseEntity<>(savedSprint,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/sprint")
	public ResponseEntity<List<Sprint>> getAllSprintsHandler() throws SprintException{
		List<Sprint> sprintList = sprintService.getAllSprints();
		return new ResponseEntity<List<Sprint>>(sprintList,HttpStatus.OK);
	}
	
	@GetMapping("/sprint/{day}")
	public ResponseEntity<List<Task>> getAllTaskByWeekDays(@PathVariable("day") String day) throws TaskException{
		List<Task> taskList = sprintService.getAllTaskByWeekDays(day);
		return new ResponseEntity<List<Task>>(taskList,HttpStatus.OK);
	}
	

}
