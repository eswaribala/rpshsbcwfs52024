package com.hsbc.dal;

import com.hsbc.exceptions.DbConnectionException;
import com.hsbc.exceptions.DriverException;
import com.hsbc.exceptions.StudentNotFoundException;
import com.hsbc.helpers.MySQLHelper;
import com.hsbc.models.Student;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class StudentImpl implements StudentDAL{
  //  private static Connection connection;
    private static ResourceBundle resourceBundle;
    //parameterized queries
    private PreparedStatement preparedStatement;

    //ResultSet
    private Statement statement;

    private ResultSet resultSet;

    private ResultSetMetaData resultSetMetaData;


    public StudentImpl()  {
        //connection= MySQLHelper.getConnection();
        resourceBundle=ResourceBundle.getBundle("db");
    }


    @Override
    public boolean addStudent(Student student) throws DbConnectionException, DriverException {
        String query=resourceBundle.getString("addStudent");
        int rows=0;
        try{
        try(Connection connection=MySQLHelper.getConnection()) {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, student.getSapId());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setString(3, student.getStream());
            preparedStatement.setFloat(4, student.getPercentage());
            preparedStatement.setDate(5, Date.valueOf(student.getDor()));
            //execute query
             rows= preparedStatement.executeUpdate();

        }catch(SQLException e){

            throw new DbConnectionException("Db Connection Error");
        }

        }catch(ClassNotFoundException e){
            throw new DriverException("Driver not found Exception");
        }finally {
            if (rows > 0)
                return true;
            else
                return false;
        }

    }

    @Override
    public List<Student> getAllStudents()  {
       List<Student> students=new ArrayList<Student>();
       String query=resourceBundle.getString("getAllStudents");
       try {
           try (Connection connection = MySQLHelper.getConnection()) {
               statement = connection.createStatement();
               resultSet = statement.executeQuery(query);
               while (resultSet.next()) {
                   students.add(new Student(resultSet.getInt(1),
                           resultSet.getString(2),
                           resultSet.getString(3),
                           resultSet.getFloat(4),
                           resultSet.getDate(5).toLocalDate()));
               }
           }
       }catch(SQLException e){
           throw new DbConnectionException("Db Connection Error");

    }finally {
        return students;
    }


    }

    @Override
    public Student getStudent(int sapId) {
        Student student=null;
        String query=resourceBundle.getString("getStudent");
        try {
            try (Connection connection = MySQLHelper.getConnection()) {
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1,sapId);
                resultSet = preparedStatement.executeQuery();
                resultSet.next();
                resultSetMetaData=resultSet.getMetaData();
               for(int count=1;count<=resultSetMetaData.getColumnCount();count++){
                   System.out.println(resultSetMetaData.getColumnName(count));
               }

                student= new Student(resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getFloat(4),
                            resultSet.getDate(5).toLocalDate());
            }
        }catch(SQLException e){
            throw new DbConnectionException("Db Connection Error");

        }finally {
          if (student!=null)
            return student;
          else
              throw new StudentNotFoundException("Record not found");
        }
    }

    @Override
    public boolean updateStudent(int sapId, String stream) throws DbConnectionException {
        String query=resourceBundle.getString("updateStudent");
        int rows=0;
        try {
            try (Connection connection = MySQLHelper.getConnection()) {
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, stream);
                preparedStatement.setInt(2, sapId);
                //execute query
                rows = preparedStatement.executeUpdate();

            }
        }catch(SQLException e){
            throw new DbConnectionException("Db Connection Error");
        } finally {
        if (rows > 0)
            return true;
        else
            throw new StudentNotFoundException("Record Not found");
    }

    }

    @Override
    public boolean deleteStudent(int sapId) {
        boolean status=false;
        int rows=0;
        String query=resourceBundle.getString("deleteStudent");
        try {
            try (Connection connection = MySQLHelper.getConnection()) {
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1,sapId);
                rows=preparedStatement.executeUpdate();
                connection.commit();
            }
        }catch(SQLException e){

            throw new DbConnectionException("Db Connection Error");

        }finally {
            if (rows>0) {
                status=true;
                return status;
            }
            else
                throw new StudentNotFoundException("Record not found");
        }
    }
}
