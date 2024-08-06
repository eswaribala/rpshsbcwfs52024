package com.hsbc.dal;

import com.hsbc.models.Student;

import java.util.List;

public interface StudentDAL {

    boolean addStudent(Student student);
    List<Student> getAllStudents();
    Student getStudent(int sapId);

    Student updateStudent(int sapId, String stream);

    boolean deleteStudent(int sapId);


}
