package com.wanted.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class DataSourceConfig {

    private final ApplicationProperties applicationProperties;

    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(applicationProperties.getDatasource().getDriverClassName());
        dataSourceBuilder.url(applicationProperties.getDatasource().getUrl());
        dataSourceBuilder.username(applicationProperties.getDatasource().getUsername());
        dataSourceBuilder.password(applicationProperties.getDatasource().getPassword());
        return dataSourceBuilder.build();
    }
}
