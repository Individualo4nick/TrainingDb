package com.example.trainingdb.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {
        "com.example.trainingdb.repo"
})
@Configuration
@ComponentScan
public class DBConfig {
}
