package com.hsbc.hospitalmanagementapi.controllers;

import com.hsbc.hospitalmanagementapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/v1.0")
    public ResponseEntity<?> addUser(@RequestParam(name="name") String name,
                                     @RequestParam(name="job") String job){

        return ResponseEntity.status(HttpStatus.OK).body(userService.addUser(name,job));

    }

    @GetMapping("/v1.0")
    public ResponseEntity<?> fetchAllUsers(){

        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());

    }

}
