package com.johnwstump.webcustomertracker.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class PointcutDeclarations {

	@Pointcut("execution(* com.johnwstump.webcustomertracker.dao.*.* (..))")
	public void inDAOPackage() {
	}
	
	@Pointcut("execution(* com.johnwstump.webcustomertracker.service.*.* (..))")
	public void inServicePackage() {
	}
	
	@Pointcut("execution(* com.johnwstump.webcustomertracker.controller.*.* (..))")
	public void inControllerPackage() {
	}
	
	@Pointcut("inDAOPackage() || inServicePackage() || inControllerPackage()")
	public void isLoggable() {
	}
}
