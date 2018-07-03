package com.johnwstump.springdemo.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@ComponentScan(basePackages="com.johnwstump")
@EnableTransactionManagement
public class HibernateConfig {

	@Bean
	public DataSource dataSource() {
		ComboPooledDataSource source = new ComboPooledDataSource();
		try {
			source.setDriverClass("com.mysql.cj.jdbc.Driver");
			//TODO Replace with Environment Variables
			source.setJdbcUrl("jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false");
			source.setUser("springstudent");
			source.setPassword("springstudent");
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}

		/* Connection Pool properties */
		source.setInitialPoolSize(5);
		source.setMinPoolSize(5);
		source.setMaxPoolSize(20);
		source.setMaxIdleTime(30000);
		return source;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("com.johnwstump.springdemo.entity");
		sessionFactory.setHibernateProperties(getHibernateProperties());
		return sessionFactory;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) throws Exception{
		HibernateTransactionManager manager = new HibernateTransactionManager();
		manager.setSessionFactory(sessionFactory);
		return manager;
	}
	
	private Properties getHibernateProperties() {
		Properties hibernateProperties = new Properties();
		
		hibernateProperties.put("hibernate.temp.use_jdbc_metadata_defaults","false");
		hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		hibernateProperties.put("hibernate.show_sql", true);
		
		return hibernateProperties;
	}
	

}
