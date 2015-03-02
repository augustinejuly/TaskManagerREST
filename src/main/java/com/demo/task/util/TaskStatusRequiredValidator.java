package com.demo.task.util;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TaskStatusRequiredValidator implements ConstraintValidator<TaskStatusRequired, TaskStatus>{
	
	List<TaskStatus> taskList;

	@Override
	public void initialize(TaskStatusRequired constraintAnnotation) {
		taskList = Arrays.asList(TaskStatus.values());
	}

	@Override
	public boolean isValid(TaskStatus taskStatus, ConstraintValidatorContext context) {
		boolean isValid = false;
		
		if(taskStatus == null) {
			return isValid;
		}
		
		isValid = taskList.contains(taskStatus) ? true : false;
		return isValid;
	}

}
