package com.hoangminh.config;

import com.hoangminh.database.DatabaseConnector;
import com.hoangminh.database.MySqlConnector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Value("${spring.datasource.url}")
    String mysqlUrl;

    @Value("${spring.datasource.username}")
    String mysqlUsername;

    @Value("${spring.datasource.password}")
    String mysqlPassword;

    @Bean
    DatabaseConnector mysqlConfigure() {
        DatabaseConnector mysqlConnector = new MySqlConnector();
        // Set URL
        System.out.println("Config Mysql Url: " + mysqlUrl);
        mysqlConnector.setUrl(mysqlUrl);
        // Set Username
        System.out.println("Config Mysql Username: " + mysqlUsername);
        mysqlConnector.setUsername(mysqlUsername);
        // Set Password
        System.out.println("Config Mysql Password: " + mysqlPassword);
        mysqlConnector.setPassword(mysqlPassword);
        return mysqlConnector;
    }
}
