package com.johnwstump.webcustomertracker.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

@ComponentScan(basePackages="com.johnwstump")
@EnableAspectJAutoProxy
@PropertySource({"classpath:db.properties", "classpath:security-persistence-mysql.properties"})
@Configuration("springConfig")
public class SpringConfig {

}
