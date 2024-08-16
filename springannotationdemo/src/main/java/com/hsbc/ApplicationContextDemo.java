package com.hsbc;

import com.hsbc.models.*;
import lombok.experimental.SuperBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDate;

public class ApplicationContextDemo {

    public static void main(String[] args){
        //AbstractApplicationContext applicationContext=new
       //         ClassPathXmlApplicationContext
       //         ("hospital-config.xml");

        AnnotationConfigApplicationContext applicationContext=new
                AnnotationConfigApplicationContext();
        applicationContext.register(Person.class);
        applicationContext.register(FullName.class);
        applicationContext.register(Diagnosis.class);
        applicationContext.refresh();

        FullName fullName= (FullName) applicationContext.getBean("fullName");
        fullName.setFirstName("Parameswari");
        fullName.setMiddleName("");
        fullName.setLastName("Bala");
        Person person= (Person) applicationContext.getBean("person");
        person.setPersonId(49596);
        person.setSenderName(fullName);
        person.setReceiverName(fullName);
        person.setDob(LocalDate.of(1970,12,2));

        if(person!=null)
            System.out.println(person);
        else
            System.out.println("Object not created...");

        //@con
        Diagnosis diagnosis= (Diagnosis) applicationContext
                .getBean("diagnosis");
        //treatment
        Treatment treatment=diagnosis.recommenedTreatment();
      //  treatment.setCharges(10000L);
        //destroy method
        //calls @predestroy
         applicationContext.registerShutdownHook();

    }
}
