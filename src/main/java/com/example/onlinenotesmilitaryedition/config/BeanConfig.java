package com.example.onlinenotesmilitaryedition.config;

import com.example.onlinenotesmilitaryedition.dao.UserService;
import com.example.onlinenotesmilitaryedition.dao.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }
}
