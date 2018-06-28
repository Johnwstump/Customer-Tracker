package com.johnwstump.springdemo.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class PointcutDeclarations {

	@Pointcut("execution(* com.johnwstump.springdemo.dao.*.* (..))")
	public void inDAOPackage() {
	}
	
	@Pointcut("execution(* com.johnwstump.springdemo.service.*.* (..))")
	public void inServicePackage() {
	}
	
	@Pointcut("execution(* com.johnwstump.springdemo.controller.*.* (..))")
	public void inControllerPackage() {
	}
	
	@Pointcut("inDAOPackage() || inServicePackage() || inControllerPackage()")
	public void isLoggable() {
	}
}
