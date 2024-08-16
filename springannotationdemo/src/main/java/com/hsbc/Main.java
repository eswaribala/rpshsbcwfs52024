package com.hsbc;

import com.hsbc.models.Person;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Main {
    public static void main(String[] args) {
        //IOC
        //Step 1
        Resource resource=new ClassPathResource("hospital-config.xml");
        //Step2
        //create container
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(resource);
        //step3
        //inversion of control
        Person person= (Person) factory.getBean("person");
        if(person!=null)
            System.out.println(person);
        else
            System.out.println("Object not created...");

        //singleton
        Person person1=(Person) factory.getBean("person");
        person1.setPersonId(1005);
        System.out.println(person);
        System.out.println(person1);



    }
}