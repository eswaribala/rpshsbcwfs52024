package com.hsbc.hospitalmanagement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignupController {

    @GetMapping("/signup")
    public String loadSignUp(){
        return "signup.html";
    }
}
