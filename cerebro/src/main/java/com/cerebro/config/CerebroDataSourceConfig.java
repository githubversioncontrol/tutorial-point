package com.cerebro.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class CerebroDataSourceConfig {

	@Bean
	@Primary
	public DataSource dataSource() {
		String currentDirectory = new String(System.getProperty("user.dir"));
		currentDirectory = currentDirectory.replace("\\", "/");
		String url = "jdbc:h2:file:" + currentDirectory + "/src/main/resources/cerebro;MV_STORE=FALSE";
		return DataSourceBuilder.create().url(url).username("cerebro").password("cerebro")
				.driverClassName("org.h2.Driver").build();
	}
}
