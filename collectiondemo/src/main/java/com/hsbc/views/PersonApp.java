package com.hsbc.views;

import com.hsbc.dal.PersonDAL;
import com.hsbc.dal.PersonImpl;
import com.hsbc.models.Person;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.Random;

public class PersonApp {

    public static void main(String[] args){
        try {
            PersonDAL personDAL=new PersonImpl("store","person.csv");
            //addPerson(personDAL);
            //iterator
            Iterator<Person> itr= personDAL.getPersons().iterator();
            while(itr.hasNext()){
                System.out.println(itr.next());
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
