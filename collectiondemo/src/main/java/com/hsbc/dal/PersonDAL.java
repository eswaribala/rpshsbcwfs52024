package com.hsbc.dal;

import com.hsbc.models.Person;

import java.io.IOException;
import java.util.List;

public interface PersonDAL {

    boolean addPerson(Person person) throws IOException;
    List<Person> getPersons() throws IOException;
}
