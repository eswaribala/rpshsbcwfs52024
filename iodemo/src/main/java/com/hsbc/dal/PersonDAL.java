package com.hsbc.dal;

import com.hsbc.models.Person;

import java.io.IOException;

public interface PersonDAL {

    boolean addPerson(Person person) throws IOException;
    Person[] getPersons() throws IOException;
}
