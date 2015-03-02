package com.demo.task.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.task.dao.TaskDao;
import com.demo.task.domain.Task;
import com.demo.task.util.TaskPriority;
import com.demo.task.util.TaskStatus;

@Service("taskService")
@Transactional
public class TaskServiceImpl implements TaskService, InitializingBean{
	
	@Autowired
	private TaskDao<Task> taskDao;
	
	@Autowired
	private ApplicationContext applicationContext;

	@Override
	public void addTask(Task task) {
		task.setTaskBeginDate(new Date());
		taskDao.add(task);
	}

	@Override
	public void deleteTask(Task task) {
		taskDao.delete(task);
	}

	@Override
	public void deleteTask(Long taskId) {
		taskDao.delete(Task.class, taskId);
	}

	@Override
	public void updateTask(Task task) {
		Task oldTask = taskDao.loadById(Task.class, task.getTaskId());
		oldTask.setTaskName(task.getTaskName());
		oldTask.setTaskOwner(task.getTaskOwner());
		oldTask.setTaskPriority(task.getTaskPriority());
		oldTask.setTaskStatus(task.getTaskStatus());
		if(TaskStatus.COMPLETED.equals(task.getTaskStatus())) {
			oldTask.setTaskCompletedDate(new Date());
		}
		taskDao.update(oldTask);
	}
	
	@Override
	public Task loadTaskById(Serializable taskId) {
		return taskDao.loadById(Task.class, taskId);
	}

	@Override
	public List<Task> listAllTasks() {
		return taskDao.listAll(Task.class);
	}

	@Override
	public List<Task> listTaskByPriority(TaskPriority taskPriority) {
		return taskDao.listTaskByCriteria(Task.class, taskPriority, "taskPriority");
	}

	@Override
	public List<Task> listTaskByStatus(TaskStatus taskStatus) {
		return taskDao.listTaskByCriteria(Task.class, taskStatus, "taskStatus");
	}

	@Override
	public Long getTotalTask() {
		return taskDao.getCount(Task.class);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		
				Date today = new Date();
				Task task1 = new Task(null,"Start Up", "Admin", today, null, TaskPriority.HIGH, TaskStatus.PENDING);
				Task task2 = new Task(null,"Back Up", "Admin", today, null, TaskPriority.HIGH, TaskStatus.PENDING);
				TaskService transactionProxiedTaskServiceBean = applicationContext.getBean("taskService",TaskService.class);
				transactionProxiedTaskServiceBean.addTask(task1);
				transactionProxiedTaskServiceBean.addTask(task2);
	}

}
