package com.demo.task.service.test;

import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.demo.task.domain.Task;
import com.demo.task.service.TaskService;
import com.demo.task.util.TaskPriority;
import com.demo.task.util.TaskStatus;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/applicationContext.xml")
@TransactionConfiguration(defaultRollback=true)
@Transactional
public class ServiceTest {
	
	@Autowired
	private TaskService taskService;
	
	private static final String TEMP_TASK_NAME = "Temporary Task Name for testing purposes";
	
	@Test
	public void testAddTask() {
		
		int tasksBeforeAddition = taskService.listAllTasks().size();
		taskService.addTask(getTask());
		assertTrue((tasksBeforeAddition + 1) == taskService.listAllTasks().size());
	}
	
	@Test
	public void testDeleteTask() {
		Task task = getTask();
		taskService.addTask(task);
		int tasksBeforeDelete = taskService.listAllTasks().size();
		taskService.deleteTask(task);
		assertTrue((tasksBeforeDelete - 1) == taskService.listAllTasks().size());
	}
	
	@Test
	public void testDeleteByTaskId() {
		Task task = getTask();
		taskService.addTask(task);
		int tasksBeforeDelete = taskService.listAllTasks().size();
		taskService.deleteTask(task.getTaskId());
		assertTrue((tasksBeforeDelete - 1) == taskService.listAllTasks().size());
	}
	
	@Test
	public void testUpdateTask() {
		Task task = getTask();
		taskService.addTask(task);
		task.setTaskStatus(TaskStatus.COMPLETED);
		taskService.updateTask(task);
		Task updatedTask = taskService.loadTaskById(task.getTaskId());
		assertTrue(TaskStatus.COMPLETED.equals(updatedTask.getTaskStatus()));
	}
	
	@Test
	public void testLoadTaskById() {
		Task task = getTask();
		task.setTaskName(TEMP_TASK_NAME);
		taskService.addTask(task);
		
		assertTrue(TEMP_TASK_NAME.equals(taskService.loadTaskById(task.getTaskId()).getTaskName()));
	}
	
	@Test
	public void testListAllValues() {
		
		Long totalTasks = new Long(taskService.listAllTasks().size());
		Long totalTaskCount = taskService.getTotalTask();
		assertTrue(totalTasks.longValue() == totalTaskCount.longValue());
		
	}
	
	@Test
	public void testLoadTaskByStatus()  {
		Task task1 = getTask();
		task1.setTaskStatus(TaskStatus.PENDING);
		Task task2 = getTask();
		task2.setTaskStatus(TaskStatus.COMPLETED);
		taskService.addTask(task1);
		taskService.addTask(task2);
		
		Collection<Task> listTaskByStatus = taskService.listTaskByStatus(TaskStatus.PENDING);
		for (Task task : listTaskByStatus) {
			assertTrue(TaskStatus.PENDING.equals(task.getTaskStatus()));
		}
		
	}
	
	@Test
	public void testLoadTaskByPriority()  {
		Task task1 = getTask();
		task1.setTaskPriority(TaskPriority.LOW);
		Task task2 = getTask();
		task1.setTaskPriority(TaskPriority.MEDIUM);
		Task task3 = getTask();
		task1.setTaskPriority(TaskPriority.HIGH);
		
		taskService.addTask(task1);
		taskService.addTask(task2);
		taskService.addTask(task3);
		
		Collection<Task> listTaskByPriority = taskService.listTaskByPriority(TaskPriority.HIGH);
		for (Task task : listTaskByPriority) {
			assertTrue(TaskPriority.HIGH.equals(task.getTaskPriority()));
		}
		
	}
	
	
	private Task getTask() {
		Task task = new Task();
		task.setTaskName("Document preparation");
		task.setTaskPriority(TaskPriority.LOW);
		task.setTaskStatus(TaskStatus.PENDING);
		task.setTaskBeginDate(new Date());
		task.setTaskOwner("John");
		return task;
	}
}
