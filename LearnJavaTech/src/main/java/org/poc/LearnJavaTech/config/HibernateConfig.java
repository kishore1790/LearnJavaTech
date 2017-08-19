package org.poc.LearnJavaTech.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "org.poc.LearnJavaTech.model" })
@EnableTransactionManagement
public class HibernateConfig {

	@Value("${jdbc.url}")
	private String DB_URL;;
	@Value("${jdbc.driverClassName}")
	private String DB_DRIVER;
	@Value("${jdbc.username}")
	private String DB_USERNAME;
	@Value("${jdbc.password}")
	private String DB_PASSWORD;
	@Value("${hibernate.dialect}")
	private String HIBERNATE_DIALECT;
	@Value("${hibernate.show_sql}")
	private String HIBERNATE_SHOW_SQL;

	@Bean("dataSource")
	public DataSource getDataSource() {

		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(DB_DRIVER);
		dataSource.setUrl(DB_URL);
		dataSource.setUsername(DB_USERNAME);
		dataSource.setPassword(DB_PASSWORD);
		return dataSource;
	}

	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("org.poc.LearnJavaTech.model");
		return builder.buildSessionFactory();
	}

	// SET Hibernate Properties
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", HIBERNATE_DIALECT);
		properties.put("hibernate.show_sql", HIBERNATE_SHOW_SQL);
		properties.put("hibernate.format_sql", HIBERNATE_SHOW_SQL);
		return properties;
	}

	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}

}