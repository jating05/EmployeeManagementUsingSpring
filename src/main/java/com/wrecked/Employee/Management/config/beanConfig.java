package com.wrecked.Employee.Management.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class beanConfig {

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }

}
