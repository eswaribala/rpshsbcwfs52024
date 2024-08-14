package com.globalclaim;

import com.github.javafaker.Faker;
import com.globalclaim.models.Employee;

public class SwitchExpressionDemo {

    public static void main(String... args){
        Faker faker=new Faker();
        Employee employee=Employee.builder()
                .id(faker.number().numberBetween(1,1000))
                .name(faker.name().firstName())
                .designation(faker.job().position())
                .location(faker.address().city())
                .build();

       // employee.setLocation("London");
        String cityName=switch (employee.getLocation()){
            case "New York"->{
                yield "New York";
            }
            case "London" -> "London";
            default -> {
                yield "India";

            }
        };
        System.out.println(cityName);

    }
}
