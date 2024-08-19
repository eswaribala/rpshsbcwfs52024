package com.hsbc.hospitalmanagement.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hsbc.hospitalmanagement.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignupController {
    @Autowired
    private CountryService countryService;

    @GetMapping("/signup")
    public String loadSignUp(Model model)  {
        model.addAttribute("countryNames",
                countryService.getCountryNames());
        return "signup.html";
    }
}
