package com.hsbc.hospitalmanagementapi.exceptions;

import com.hsbc.hospitalmanagementapi.dtos.ResponseWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<ResponseWrapper> handlePersonNotFoundException(PersonNotFoundException
                                                                    personNotFoundException){

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ResponseWrapper(personNotFoundException.getMessage()));

    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ResponseWrapper> handleRunTimeException(RuntimeException exception){

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ResponseWrapper(exception.getMessage()));

    }

}
