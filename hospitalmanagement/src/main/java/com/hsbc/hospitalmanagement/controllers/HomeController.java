package com.hsbc.hospitalmanagement.controllers;

import com.hsbc.hospitalmanagement.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    private CountryService countryService;

    @GetMapping("/home")
    public String loadHome() throws NoSuchFieldException, IllegalAccessException {
        countryService.getCountryNames();
        return "home.html";
    }


}
