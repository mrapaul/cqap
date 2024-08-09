package com.capstone.server.controller;


import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.*;

import javax.servlet.*;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Server
{
    public static void main(String[] args)
    {
        SpringApplication.run(Server.class, args);
    }

    @Bean
    MultipartConfigElement multipartConfigElement()
    {
        return new MultipartConfigElement("");
    }
}
