package com.hsbc.hospitalmanagement.services;

import com.hsbc.hospitalmanagement.dtos.EmployeeRequest;
import com.hsbc.hospitalmanagement.models.Employee;
import com.hsbc.hospitalmanagement.models.Person;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    boolean addEmployee(EmployeeRequest employeeRequest);
    List<Employee> getAllEmployees();
    Optional<Employee> getEmployeeById(long employeeCode);
    Employee updateEmployee(long employeeCode, long salary);
    boolean deleteEmployee(long employeeCode);
    Person getPerson(String firstName, String lastName, String dob);

}
