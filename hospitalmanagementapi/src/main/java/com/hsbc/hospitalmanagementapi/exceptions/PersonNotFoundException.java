package com.hsbc.hospitalmanagementapi.exceptions;

public class PersonNotFoundException extends RuntimeException{

    public PersonNotFoundException(String message) {
        super(message);
    }
}
