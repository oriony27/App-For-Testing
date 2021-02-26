package com.app.testing.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfiguration {

    @Autowired
    private ConfigHelper configHelper;

    @Bean
    public DataSource mysqlDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(configHelper.getJdbcDriverClassName());
        dataSource.setUrl(configHelper.getJdbcUrl());
        dataSource.setUsername(configHelper.getJdbcUsername());
        dataSource.setPassword(configHelper.getJdbcPassword());

        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(mysqlDataSource());
    }
}