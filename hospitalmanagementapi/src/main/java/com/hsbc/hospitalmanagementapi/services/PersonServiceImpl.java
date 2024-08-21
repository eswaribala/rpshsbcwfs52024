package com.hsbc.hospitalmanagementapi.services;

import com.hsbc.hospitalmanagementapi.exceptions.PersonNotFoundException;
import com.hsbc.hospitalmanagementapi.models.Person;
import com.hsbc.hospitalmanagementapi.repositories.PersonRepository;
import jakarta.persistence.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    private PersonRepository personRepository;
    @Override
    public Person addPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public Person getPersonById(long personId) {

        return personRepository
                .findById(personId)
                .orElseThrow(()->new PersonNotFoundException("Person not available"));
    }

    @Override
    public List<Person> getPersonByFirstName(String firstName) {
        return null;
    }

    @Override
    public boolean deletePerson(long personId) {
        boolean status=false;
        personRepository.deleteById(personId);
        if(getPersonById(personId)==null)
            status=true;
        return status;
    }
}
