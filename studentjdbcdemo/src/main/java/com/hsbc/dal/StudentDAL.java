package com.hsbc.dal;

import com.hsbc.exceptions.DbConnectionException;
import com.hsbc.exceptions.DriverException;
import com.hsbc.models.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDAL {

    boolean addStudent(Student student) throws  DbConnectionException, DriverException;
    List<Student> getAllStudents() throws SQLException, ClassNotFoundException;
    Student getStudent(int sapId);

    boolean updateStudent(int sapId, String stream) throws SQLException, ClassNotFoundException;

    boolean deleteStudent(int sapId);


}
