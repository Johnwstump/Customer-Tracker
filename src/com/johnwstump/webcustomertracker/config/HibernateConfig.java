package com.johnwstump.webcustomertracker.config;

import java.util.Optional;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@ComponentScan(basePackages="com.johnwstump")
@EnableTransactionManagement
@DependsOn(value="springConfig")
public class HibernateConfig {

	@Value("${db.usernameVariable:customerTrackerDBUsername}")
	private String DBUSERVAR;
	@Value("${db.passwordVariable:customerTrackerDBPassword}")
	private String DBPASSWORDVAR;
	
	@Autowired
	private Environment env;
	
	@Bean
	public DataSource dataSource() {
		ComboPooledDataSource source = new ComboPooledDataSource();
		try {
			source.setDriverClass("com.mysql.cj.jdbc.Driver");
			source.setJdbcUrl("jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false");
			String username = Optional.ofNullable(System.getenv(DBUSERVAR)).orElseThrow(() -> new Exception(DBUSERVAR + " is not set in the environment"));
			source.setUser(username);
			String password = Optional.ofNullable(System.getenv(DBPASSWORDVAR)).orElseThrow(() -> new Exception(DBPASSWORDVAR + " is not set in the environment"));
			source.setPassword(password);
		} catch (Exception e) {
			e.printStackTrace();
		}

		/* Connection Pool properties */
		source.setInitialPoolSize(5);
		source.setMinPoolSize(5);
		source.setMaxPoolSize(20);
		source.setMaxIdleTime(30000);
		return source;
	}
	
	@Bean(name="securityDataSource")
	public DataSource securityDataSource(){
		System.out.println("Building Security Source");
		ComboPooledDataSource securitySource = new ComboPooledDataSource();
		try {
			securitySource.setDriverClass(env.getProperty("security.jdbc.driver"));
			securitySource.setJdbcUrl(env.getProperty("security.jdbc.url"));
			securitySource.setUser(env.getProperty("security.jdbc.user"));
			securitySource.setPassword(env.getProperty("security.jdbc.password"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		/* Connection Pool properties */
		securitySource.setInitialPoolSize(5);
		securitySource.setMinPoolSize(5);
		securitySource.setMaxPoolSize(20);
		securitySource.setMaxIdleTime(30000);
		return securitySource;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("com.johnwstump.webcustomertracker.entity");
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
