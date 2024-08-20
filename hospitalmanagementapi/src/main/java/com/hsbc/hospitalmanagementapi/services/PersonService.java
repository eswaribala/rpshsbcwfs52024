package com.hsbc.hospitalmanagementapi.services;

import com.hsbc.hospitalmanagementapi.models.Person;

import java.util.List;

public interface PersonService {

    Person addPerson(Person person);
    List<Person> getAllPersons();
    Person getPersonById(long personId);
    List<Person> getPersonByFirstName(String firstName);
   boolean deletePerson(long personId);

}
