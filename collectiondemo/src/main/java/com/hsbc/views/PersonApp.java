package com.hsbc.views;

import com.hsbc.dal.PersonDAL;
import com.hsbc.dal.PersonImpl;
import com.hsbc.models.Person;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.Random;

@Slf4j
public class PersonApp {
    public static void main(String[] args){
        try {
            PersonDAL personDAL=new PersonImpl("store","person.csv");
            //addPerson(personDAL);
            //iterator
            Person person=null;
            Iterator<Person> itr= personDAL.getPersons().iterator();
            while(itr.hasNext()){
               // System.out.println(itr.next());
                person=itr.next();
                log.info(""+person.getName());
                log.info(""+person.getDob().getYear());
            }

        } catch (IOException e) {

        }


    }

    public static  void addPerson(PersonDAL personDAL) throws IOException {
        for(int count=0;count<100;count++){
              personDAL.addPerson(new Person("person"+count,
                      LocalDate.of(new Random().nextInt(1970,2023),
                              new Random().nextInt(1,12),
                              new Random().nextInt(1,27)
                              )));
        }
    }
}
