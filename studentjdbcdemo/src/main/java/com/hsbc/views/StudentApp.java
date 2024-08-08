package com.hsbc.views;

import com.hsbc.dal.StudentDAL;
import com.hsbc.dal.StudentImpl;
import com.hsbc.exceptions.DbConnectionException;
import com.hsbc.exceptions.DriverException;
import com.hsbc.helpers.MySQLHelper;
import com.hsbc.models.Student;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StudentApp {
    public static void main(String... args){
        try {
            StudentDAL studentDAL=new StudentImpl();
            //bulk transaction
           studentDAL.addStudents(sendStudentsData());


            //studentDAL.updateStudent(1010,"IT");
           // studentDAL.deleteStudent(1010);
       // System.out.println(studentDAL.getStudent(1011));
           // addStudents(studentDAL);
            //for(Student student: studentDAL.getAllStudents())
              //  System.out.println(student);

       } catch (DbConnectionException | DriverException e) {
            //throw new RuntimeException(e);
        }

    }

    public static  void addStudents(StudentDAL studentDAL) throws DbConnectionException, DriverException {
        for(int count=1000;count<1100;count++){
            studentDAL.addStudent(new Student(count,"student"+count,
                    "CSE",7.45f,
                    LocalDate.of(new Random().nextInt(1991,2023),
                    new Random().nextInt(1,12),
                    new Random().nextInt(1,26)
                    )));
        }

    }
    public static  List<Student> sendStudentsData()  {
        List<Student> studentList=new ArrayList<Student>();
        for(int count=5000;count<5100;count++){
           studentList.add(new Student(count,"student"+count,
                    "CSE",7.45f,
                    LocalDate.of(new Random().nextInt(1991,2023),
                            new Random().nextInt(1,12),
                            new Random().nextInt(1,26)
                    )));
        }
        return studentList;
    }


}
