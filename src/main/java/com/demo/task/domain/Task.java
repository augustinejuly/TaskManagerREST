package com.demo.task.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

import com.demo.task.util.TaskPriority;
import com.demo.task.util.TaskPriorityRequired;
import com.demo.task.util.TaskStatus;
import com.demo.task.util.TaskStatusRequired;

/**
 * @author augustine
 * 
 * The POJO Task represents the domain model of a task.
 */
@Entity
public class Task {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long taskId;
	
	@NotEmpty(message="Task name required")
	private String taskName;
	
	@NotEmpty(message="Task owner required")
	private String taskOwner;
	
	private Date taskBeginDate;
	
	private Date taskCompletedDate;
	
	@TaskPriorityRequired
	private TaskPriority taskPriority;
	
	@TaskStatusRequired
	private TaskStatus taskStatus;

	public Task(Long taskId, String taskName, String taskOwner,
			Date taskBeginDate, Date taskCompletedDate,
			TaskPriority taskPriority, TaskStatus taskStatus) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.taskOwner = taskOwner;
		this.taskBeginDate = taskBeginDate;
		this.taskCompletedDate = taskCompletedDate;
		this.taskPriority = taskPriority;
		this.taskStatus = taskStatus;
	}

	public Task() {
		super();
	}

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskOwner() {
		return taskOwner;
	}

	public void setTaskOwner(String taskOwner) {
		this.taskOwner = taskOwner;
	}

	public Date getTaskBeginDate() {
		return taskBeginDate;
	}

	public void setTaskBeginDate(Date taskBeginDate) {
		this.taskBeginDate = taskBeginDate;
	}

	public Date getTaskCompletedDate() {
		return taskCompletedDate;
	}

	public void setTaskCompletedDate(Date taskCompletedDate) {
		this.taskCompletedDate = taskCompletedDate;
	}

	public TaskPriority getTaskPriority() {
		return taskPriority;
	}

	public void setTaskPriority(TaskPriority taskPriority) {
		this.taskPriority = taskPriority;
	}

	public TaskStatus getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(TaskStatus taskStatus) {
		this.taskStatus = taskStatus;
	}

	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", taskName=" + taskName
				+ ", taskOwner=" + taskOwner + ", taskBeginDate="
				+ taskBeginDate + ", taskCompletedDate=" + taskCompletedDate
				+ ", taskPriority=" + taskPriority + ", taskStatus="
				+ taskStatus + "]";
	}
	
}
