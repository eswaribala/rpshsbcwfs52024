package com.hsbc.models;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DiagnosisConfig {

    @Bean
    public DiagnosisBeanPostProcessor getInstance(){
        return new DiagnosisBeanPostProcessor();
    }
}
