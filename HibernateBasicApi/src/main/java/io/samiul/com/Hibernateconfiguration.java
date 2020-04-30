package io.samiul.com;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class Hibernateconfiguration {

	private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String username = "sa";
	private String password = "samisql";
	private String url = "jdbc:sqlserver://DESKTOP-IMM4C8H:1433;databaseName=Test;";
	private String dialect = "org.hibernate.dialect.SQLServer2012Dialect";
	private String show_sql = "true";
	private String hbm2ddl_auto = "update";
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", dialect);
		hibernateProperties.put("hibernate.show_sql", show_sql);
		hibernateProperties.put("hibernate.hbm2ddl.auto", hbm2ddl_auto);
		sessionFactory.setHibernateProperties(hibernateProperties);
		sessionFactory.setPackagesToScan("io.samiul.com.model");
		return sessionFactory;
	}
	
	@Bean
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}	
	
}
