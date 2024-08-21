package com.hsbc.hospitalmanagementapi.controllers;

import com.hsbc.hospitalmanagementapi.models.Person;
import com.hsbc.hospitalmanagementapi.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("persons")
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping("/v1.0")
    public ResponseEntity<?> addPerson(@RequestBody Person person){

        Person personObject=personService.addPerson(person);
        if(personObject!=null)
            return ResponseEntity.status(HttpStatus.CREATED).body(personObject);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not having sufficient data");

    }


}
