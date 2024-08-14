package com.io.dal;

import com.io.models.Person;

import java.io.IOException;

public interface PersonDAL {

    boolean addPerson(Person person) throws IOException;
    Person[] getPersons() throws IOException;
}
