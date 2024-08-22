package com.hsbc.hsbcapicloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HsbcapicloudgatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(HsbcapicloudgatewayApplication.class, args);
    }

}
