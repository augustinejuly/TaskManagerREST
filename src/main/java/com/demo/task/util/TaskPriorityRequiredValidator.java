package com.demo.task.util;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TaskPriorityRequiredValidator implements ConstraintValidator<TaskPriorityRequired, TaskPriority>{
	
	List<TaskPriority> taskList;

	@Override
	public void initialize(TaskPriorityRequired constraintAnnotation) {
		taskList = Arrays.asList(TaskPriority.values());
	}

	@Override
	public boolean isValid(TaskPriority taskPriority, ConstraintValidatorContext context) {
		boolean isValid = false;
		
		if(taskPriority == null) {
			return isValid;
		}
		
		isValid = taskList.contains(taskPriority) ? true : false;
		return isValid;
	}

}
