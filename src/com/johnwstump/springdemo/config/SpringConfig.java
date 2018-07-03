package com.johnwstump.springdemo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan(basePackages="com.johnwstump")
@EnableAspectJAutoProxy
@Configuration
public class SpringConfig {

}
