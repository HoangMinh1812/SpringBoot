package com.hoangminh;

import com.hoangminh.database.DatabaseConnector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);

        DatabaseConnector databaseConnector = context.getBean(DatabaseConnector.class);
        databaseConnector.connect();
    }
}
