package com.hsbc.views;

import com.hsbc.dal.StudentDAL;
import com.hsbc.dal.StudentImpl;
import com.hsbc.helpers.MySQLHelper;
import com.hsbc.models.Student;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Random;

public class StudentApp {
    public static void main(String... args){

        try {
            StudentDAL studentDAL=new StudentImpl();
            studentDAL.updateStudent(10,"EEE");

            //addStudents(studentDAL);
           // for(Student student: studentDAL.getAllStudents())
             //   System.out.println(student);

        } catch (SQLException e) {
            //throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            //throw new RuntimeException(e);
        }

    }

    public static  void addStudents(StudentDAL studentDAL) throws SQLException, ClassNotFoundException {
        for(int count=10;count<100;count++){
            studentDAL.addStudent(new Student(count,"student"+count,
                    "CSE",7.45f,
                    LocalDate.of(new Random().nextInt(1991,2023),
                    new Random().nextInt(1,12),
                    new Random().nextInt(1,26)
                    )));
        }

    }


}
