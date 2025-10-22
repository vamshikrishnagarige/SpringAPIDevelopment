package com.vamshi.learningspring.SpringAPIDevelopment.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author: Vamshi Krishna Garige
 * Description: Learning purpose.
 * Date: 22-10-2025
 */
@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
