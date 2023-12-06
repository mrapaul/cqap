package com.capstone.server.controller;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(scanBasePackages = {"com.cqap.*", "com.lakeland.*", "com.peirs.*", "com.capstone.*"})
@EnableMongoRepositories
@EnableWebMvc
public class Server
{
    public static void main(String[] args)
    {
        SpringApplication.run(Server.class, args);
    }
}
