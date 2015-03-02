package com.demo.task.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Constraint(validatedBy=TaskPriorityRequiredValidator.class)
@Target({ ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface TaskPriorityRequired {

	String message() default "Task Priority is required";

	TaskPriority[] bloodGroups() default TaskPriority.LOW;

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
	
}
