package com.johnwstump.springdemo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

@ComponentScan(basePackages="com.johnwstump")
@EnableAspectJAutoProxy
@PropertySource("classpath:db.properties")
@Configuration("springConfig")
public class SpringConfig {

}
