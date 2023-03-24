package com.payPal.TaskPlanner_Backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payPal.TaskPlanner_Backend.entity.Sprint;
import com.payPal.TaskPlanner_Backend.entity.Task;
import com.payPal.TaskPlanner_Backend.exception.SprintException;
import com.payPal.TaskPlanner_Backend.exception.TaskException;
import com.payPal.TaskPlanner_Backend.repository.SprintRepo;

@Service
public class SprintServiceImplementation implements SprintService{
	
	@Autowired
	private SprintRepo sprintRepo;

	@Override
	public Sprint createSprint(Sprint sprint) {
		Sprint savedSprint = sprintRepo.save(sprint);
		return savedSprint;
	}

	@Override
	public List<Sprint> getAllSprints() throws SprintException {
		List<Sprint> sprintList = sprintRepo.findAll();
		if(sprintList.size()!=0) {
			return sprintList;
		}else {
			throw new SprintException("There are no Sprints");
		}
	}

	@Override
	public List<Task> getAllTaskByWeekDays(String day) throws TaskException {
		List<Task> taskList =  sprintRepo.findByWeekDay(day);
		if(taskList.size()!=0) {
			return taskList;
		}else {
			throw new TaskException("There are no Tasks for : "+day);
		}
	}

}
