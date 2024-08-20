package com.hsbc.hospitalmanagement.services;

import com.hsbc.hospitalmanagement.dtos.EmployeeRequest;
import com.hsbc.hospitalmanagement.models.Employee;
import com.hsbc.hospitalmanagement.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private JdbcClient jdbcClient;

    @Value("${addPerson}")
    private String addPersonQuery;
    @Value("${addEmployee}")
    private String addEmployeeQuery;
    @Value("${getPerson}")
    private String getPersonQuery;
    @Value("${getEmployee}")
    private String getEmployeeQuery;
    @Value("${getAllEmployees}")
    private String getAllEmployeesQuery;

    @Override
    public boolean addEmployee(EmployeeRequest employeeRequest) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
      /*int rows=  jdbcTemplate.update(addPersonQuery,new Object[]{
                employeeRequest.getFirstName(),
                employeeRequest.getMiddleName(),
                employeeRequest.getLastName(),
                Date.valueOf(employeeRequest.getDob())
        },keyHolder);*/
     int personRows=   jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(addPersonQuery,
                        Statement.RETURN_GENERATED_KEYS);
                ps.setString(1,  employeeRequest.getFirstName());
                ps.setString(2, employeeRequest.getMiddleName());
                ps.setString(3, employeeRequest.getLastName());
                ps.setDate(4,Date.valueOf(employeeRequest.getDob()));
                return ps;
            }
        }, keyHolder);
      System.out.println(keyHolder.getKey());
       int employeeRows=  jdbcTemplate.update(addEmployeeQuery,new Object[]{
                employeeRequest.getDesignation().toString(),
                employeeRequest.getSalary(),
                keyHolder.getKey()});

        if((personRows>0)&&(employeeRows>0))
            return true;
        else
         return false;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return jdbcTemplate.query(getAllEmployeesQuery,
                BeanPropertyRowMapper.newInstance(Employee.class));
    }

    @Override
    public Optional<Employee> getEmployeeById(long employeeCode) {

        return jdbcClient.sql(getEmployeeQuery).param("employeeCode",employeeCode)
                .query(Employee.class).optional();

       // return (Employee) jdbcTemplate.queryForObject(getEmployeeQuery, new Object[]{employeeCode},
         //       new BeanPropertyRowMapper(Employee.class));
    }

    @Override
    public Employee updateEmployee(long employeeCode, long salary) {
        return null;
    }

    @Override
    public boolean deleteEmployee(long employeeCode) {
        return false;
    }

    @Override
    public Person getPerson(String firstName, String lastName, String dob) {
        return jdbcTemplate.queryForObject(getPersonQuery,
                new Object[]{firstName,lastName,Date.valueOf(dob)},
                BeanPropertyRowMapper.newInstance(Person.class));

    }
}
