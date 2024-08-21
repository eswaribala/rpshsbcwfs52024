package com.hsbc.hospitalmanagementapi.services;

import com.hsbc.hospitalmanagementapi.models.Person;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
@Slf4j
public class PersonServiceAspect {
    @Before(value = "execution(* com.hsbc.hospitalmanagementapi.services.*.add*(*))" +
            "&& args(person)")
    public void monitorBeforeAddPerson(JoinPoint joinPoint, Person person){

        log.info("Entering Add Person method......");
        log.info("Add Person method receives the following values"+person);

    }

    @AfterReturning(value = "execution(* com.hsbc.hospitalmanagementapi.services.PersonService..*(..)) " +
            "&& args(person)")
    public void monitorAfterAddPerson(JoinPoint joinPoint, Person person){
        log.info("Exiting Add Person method......");
        log.info("Add Person method created new object...."+person);
    }


    @AfterReturning(pointcut="execution(* getAllPersons())", returning="returnData")
    public void getNameReturningAdvice(List<Person> returnData){
       for (Person person : returnData)
           log.info("Data Received as"+person);
    }


}
