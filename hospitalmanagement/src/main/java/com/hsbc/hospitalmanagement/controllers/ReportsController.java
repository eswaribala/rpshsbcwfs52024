package com.hsbc.hospitalmanagement.controllers;

import com.hsbc.hospitalmanagement.dtos.EmployeeRequest;
import com.hsbc.hospitalmanagement.models.Employee;
import com.hsbc.hospitalmanagement.services.CountryService;
import com.hsbc.hospitalmanagement.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReportsController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private CountryService countryService;

    @GetMapping("/reports")
    public String loadSignUp(Model model)  {
        model.addAttribute("employee",new Employee());

        model.addAttribute("countryNames",
                countryService.getCountryNames());
        model.addAttribute("employees",
                employeeService.getAllEmployees());
        return "reports.html";
    }

    @PostMapping("/employeeById")
    public String loadEmployeeById(@ModelAttribute("employee") Employee employee, Model model)  {

        model.addAttribute("employee",
                employeeService.getEmployeeById(employee.getEmployeeCode()));
        return "reports.html";
    }

}
