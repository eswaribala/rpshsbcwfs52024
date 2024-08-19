package com.hsbc.hospitalmanagement.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hsbc.hospitalmanagement.models.Employee;
import com.hsbc.hospitalmanagement.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private CountryService countryService;

    @GetMapping("/home")
    public String loadHome(Model model)  {
        model.addAttribute("employee",new Employee());
        model.addAttribute("countryNames",
                countryService.getCountryNames());
        return "home.html";
    }


}
