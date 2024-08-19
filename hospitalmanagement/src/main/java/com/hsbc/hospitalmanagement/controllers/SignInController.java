package com.hsbc.hospitalmanagement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignInController {

    @GetMapping("/signin")
    public String loadSignIn(){
        return "signin.html";
    }
}
