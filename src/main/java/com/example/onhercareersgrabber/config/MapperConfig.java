package com.example.onhercareersgrabber.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

@Bean
    DozerBeanMapper mapper(){
    return new DozerBeanMapper();
}


}
