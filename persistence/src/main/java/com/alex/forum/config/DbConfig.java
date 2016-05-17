package com.alex.forum.config;

import java.util.Properties;

import org.hibernate.cfg.Configuration;

public class DbConfig {

	private static final Properties DEFAULT_PROPERTIES = new Properties();
	
	static {
		DEFAULT_PROPERTIES.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		DEFAULT_PROPERTIES.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
		DEFAULT_PROPERTIES.setProperty("hibernate.connection.username", "postgres");
		DEFAULT_PROPERTIES.setProperty("hibernate.connection.password", "postgres");
		DEFAULT_PROPERTIES.setProperty("hibernate.hbm2ddl.auto", "update");
	}

	public static Configuration getPersistenceConfiguration() {
		Configuration config = new Configuration();
		config.setProperties(DEFAULT_PROPERTIES);
		config.setProperty("hibernate.connection.url",
				"jdbc:postgresql://localhost:5432/forum");
		return config;
	}
}