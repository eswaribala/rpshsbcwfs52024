package com.hsbc.hospitalmanagementapi.services;

import com.hsbc.hospitalmanagementapi.models.Person;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class PersonServiceAspect {
    @Before(value = "execution(* com.hsbc.hospitalmanagementapi.services.PersonService..*(..)) " +
            "&& args(person)")
    public void monitorBeforeAddPerson(JoinPoint joinPoint, Person person){

    }

    @AfterReturning()
    public void monitorAfterAddPerson(){

    }
}
