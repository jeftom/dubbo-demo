package com.example.dubbo.demo.service.config;

import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * class description
 *
 * @author jeftom <jeftom@tenwe.com>
 * @date 2019-04-14 12:03
 * @since 1.0.0
 */
@Configuration
public class DataSourceConfig {
	private final static Logger LOGGER = LoggerFactory.getLogger(DataSourceConfig.class);

	@Bean(name = "masterDataSource")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource masterDataSource(DataSourceProperties properties) {
		LOGGER.info("init master data source：{}", properties.determineDriverClassName());
//		return DataSourceBuilder.create().build();
		return DataSourceBuilder.create(properties.getClassLoader())
				.type(HikariDataSource.class)
				.driverClassName(properties.determineDriverClassName())
				.url(properties.determineUrl())
				.username(properties.determineUsername())
				.password(properties.determinePassword())
				.build();
	}

	@Bean(name = "slaveDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.slave")
	public DataSource slaveDataSource(DataSourceProperties properties) {
		LOGGER.info("init slave data source：{}", properties);
//		return DataSourceBuilder.create().build();
		return DataSourceBuilder.create(properties.getClassLoader())
				.type(HikariDataSource.class)
				.driverClassName(properties.determineDriverClassName())
				.url(properties.determineUrl())
				.username(properties.determineUsername())
				.password(properties.determinePassword())
				.build();
	}

//	@Bean
//	@Primary
//	public JdbcTemplate masterJdbcTemplate(@Qualifier("masterDataSource") DataSource dataSource) {
//		return new JdbcTemplate(dataSource);
//	}
//
//	@Bean
//	public JdbcTemplate slaveJdbcTemplate(@Qualifier("slaveDataSource") DataSource dataSource) {
//		return new JdbcTemplate(dataSource);
//	}

	@Bean
	@Primary
	public DynamicDataSource dataSource(DataSource masterDataSource, DataSource slaveDataSource) {
		Map<String, DataSource> targetDataSources = new HashMap<>();
		targetDataSources.put(DataSourceEnum.MASTER.getName(), masterDataSource);
		targetDataSources.put(DataSourceEnum.SLAVE.getName(), slaveDataSource);

		return new DynamicDataSource(masterDataSource, targetDataSources);
	}
}
