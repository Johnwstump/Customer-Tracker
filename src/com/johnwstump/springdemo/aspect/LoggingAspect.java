package com.johnwstump.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	Logger logger = Logger.getLogger(getClass().getName());
	
	@Before("com.johnwstump.springdemo.aspect.PointcutDeclarations.isLoggable()")
	public void logCall(JoinPoint joinPoint) {
		logger.info("Logging method call: " + joinPoint.getSignature().toShortString());
		
		Object[] args = joinPoint.getArgs();
		
		for (Object arg : args) {
			logger.info("===> argument: " + arg);
		}
	}
	
	@AfterReturning(pointcut="com.johnwstump.springdemo.aspect.PointcutDeclarations.isLoggable()", returning="result")
	public void logCall(JoinPoint joinPoint, Object result) {
		logger.info("Logging method Return: " + joinPoint.getSignature().toShortString());
		logger.info("===> return: " + result);
	}
	
}
