package com.demo.task.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LoggerAspect {
	
	private static Logger logger = LoggerFactory.getLogger(LoggerAspect.class);
	
	@Pointcut("within(com.demo.task.*.*)") 
	private void loggingService() {}
	
	@Before("loggingService()")
	public void doBeforeTask(JoinPoint joinPoint){
		if(logger.isDebugEnabled()) {
			logger.debug("Method " + joinPoint.getSignature().getName() + " from " + joinPoint.getTarget().getClass().getSimpleName() +" is invoked");
		}
	}

	@After("loggingService()")
	public void doAfterTask(JoinPoint joinPoint){
		if(logger.isDebugEnabled()) {
			logger.debug("Method " + joinPoint.getSignature().getName() + " from " + joinPoint.getTarget().getClass().getSimpleName() + " has ended");
		}
	}
	
	@AfterThrowing(pointcut="within(com.demo.task.*.*)", throwing = "e")
	public void doAfterThrowing(JoinPoint jp,Throwable e) {
		
		logger.error("Exception occured in " + jp.getSignature().getName() + " of " + jp.getTarget().getClass().getName() , e);
	}

}
