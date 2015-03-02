package com.demo.task.service;

import java.io.Serializable;
import java.util.Collection;

import com.demo.task.domain.Task;
import com.demo.task.util.TaskPriority;
import com.demo.task.util.TaskStatus;

public interface TaskService {
	
	public void addTask(Task t);
	
	public void deleteTask(Task t);
	
	public void deleteTask(Long taskId);
	
	public void updateTask(Task task);
	
	public Task loadTaskById(Serializable taskId);
	
	public Collection<Task> listAllTasks();
	
	public Collection<Task> listTaskByPriority(TaskPriority taskPriority);
	
	public Collection<Task> listTaskByStatus(TaskStatus taskStatus);
	
	public Long getTotalTask();
	
}
