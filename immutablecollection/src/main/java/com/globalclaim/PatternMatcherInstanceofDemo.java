package com.globalclaim;

import com.github.javafaker.Faker;
import com.globalclaim.models.Employee;
import com.globalclaim.models.Person;

public class PatternMatcherInstanceofDemo {

    public static  void main(String... args){
        Faker faker=new Faker();
        Employee employee=Employee.builder()
                .id(faker.number().numberBetween(1,1000))
                .name(faker.name().firstName())
                .designation(faker.job().position())
                .location(faker.address().city())
                .build();
        //instance of pattern matcher
        if(employee instanceof Person person){
            System.out.println(person.getId()+","+person.getName());
        }

    }
}
