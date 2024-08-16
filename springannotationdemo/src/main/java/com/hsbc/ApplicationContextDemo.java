package com.hsbc;

import com.hsbc.models.Employee;
import com.hsbc.models.Patient;
import com.hsbc.models.Person;
import lombok.experimental.SuperBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextDemo {

    public static void main(String[] args){
        ApplicationContext applicationContext=new
                ClassPathXmlApplicationContext
                ("hospital-config.xml");
        Person person= (Person) applicationContext.getBean("person");
        if(person!=null)
            System.out.println(person);
        else
            System.out.println("Object not created...");


    }
}
