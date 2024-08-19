package com.hsbc.hospitalmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class HospitalManagementApplication {

    public static void main(String[] args) {

        SpringApplication.run(HospitalManagementApplication.class, args);
    }
    //Rest Client
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
