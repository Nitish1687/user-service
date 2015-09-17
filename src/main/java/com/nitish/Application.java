package com.nitish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.sql.SQLException;

/**
 * Created by nsm1211 on 16-09-2015.
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableEurekaClient
public class Application {
    public static void main(String[] args) throws SQLException {
        System.setProperty("spring.config.name", "accounts-server");
        SpringApplication.run(Application.class, args);
    }
}
