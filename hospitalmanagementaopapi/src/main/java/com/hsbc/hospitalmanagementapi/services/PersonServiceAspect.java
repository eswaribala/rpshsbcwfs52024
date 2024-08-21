package com.hsbc.hospitalmanagementapi.services;

import com.hsbc.hospitalmanagementapi.models.Person;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class PersonServiceAspect {

    @Before(value = "execution(* com.hsbc.hospitalmanagementapi.services.PersonService..*(..)) && args(person)")
    public void beforeAdvice(JoinPoint joinPoint, Person person) {
        System.out.println("Before method:" + joinPoint.getSignature());
        System.out.println("Creating Person with first name - " + person.getFullName().getFirstName());
    }
    @After(value = "execution(* com.hsbc.hospitalmanagementapi.services.PersonService..*(..)) && args(person)")
    public void afterAdvice(JoinPoint joinPoint, Person person) {
        System.out.println("After method:" + joinPoint.getSignature());
        System.out.println("Created Person with first name - " + person.getFullName().getFirstName());
    }
}
