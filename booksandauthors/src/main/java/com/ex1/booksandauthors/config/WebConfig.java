package com.ex1.booksandauthors.config;

import org.springframework.context.annotation.*;
import org.springframework.web.client.*;

@Configuration
public class WebConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
