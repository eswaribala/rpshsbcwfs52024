package com.hsbc.hospitalmanagementapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class HospitalmanagementapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalmanagementapiApplication.class, args);
    }

}
