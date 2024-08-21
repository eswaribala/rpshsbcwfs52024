package com.hsbc.hospitalmanagementapi.controllers;

import com.hsbc.hospitalmanagementapi.dtos.ResponseWrapper;
import com.hsbc.hospitalmanagementapi.models.Person;
import com.hsbc.hospitalmanagementapi.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("persons")
public class PersonController {
    @Autowired
    private PersonService personService;
    //adding person

    @PostMapping("/v1.0")
    ResponseEntity<ResponseWrapper> addPerson(@RequestBody Person person){
       Person personObj= personService.addPerson(person);
       if(personObj!=null){
           return ResponseEntity.status(HttpStatus.CREATED).body(
                   new ResponseWrapper(personObj));
       }else
       {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                   .body(new ResponseWrapper("No Sufficient Input"));
       }
    }

   @GetMapping("/v1.0")
    public List<Person> fetchAllPersons(){

        return personService.getAllPersons();
    }

    @GetMapping("/v1.0/{personId}")
    public ResponseEntity<ResponseWrapper> fetchPersonById(@PathVariable("personId") long personId){
        Person person= personService.getPersonById(personId);
        if(person!=null){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseWrapper(person));
        }else
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseWrapper("Person Not found"));
        }

    }

    @DeleteMapping("/v1.0/{personId}")
    public ResponseEntity<ResponseWrapper> deletePersonById(@PathVariable("personId") long personId){

        if(personService.deletePerson(personId)){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseWrapper("Person Deleted"));
        }else
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseWrapper("Person Not found"));
        }

    }

}
