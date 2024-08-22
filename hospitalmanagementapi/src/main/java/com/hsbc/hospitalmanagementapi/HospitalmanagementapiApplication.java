package com.hsbc.hospitalmanagementapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.client.RestClient;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableDiscoveryClient
public class HospitalmanagementapiApplication {

    public static void main(String[] args) {

        SpringApplication.run(HospitalmanagementapiApplication.class, args);
    }


    @Bean
    public RestClient getRestClient(){

        return RestClient.create();
    }

}
