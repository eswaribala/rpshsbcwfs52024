package com.hsbc.dal;

import com.hsbc.exceptions.DbConnectionException;
import com.hsbc.exceptions.DriverException;
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
    public List<Student> getAllStudents() throws SQLException, ClassNotFoundException {
       List<Student> students=new ArrayList<Student>();
       String query=resourceBundle.getString("getAllStudents");
        try(Connection connection=MySQLHelper.getConnection()){
           statement=connection.createStatement();
           resultSet=statement.executeQuery(query);
           while(resultSet.next()){
               students.add(new Student(resultSet.getInt(1),
                       resultSet.getString(2),
                       resultSet.getString(3),
                       resultSet.getFloat(4),
                       resultSet.getDate(5).toLocalDate()));
           }
       }
        return students;

    }

    @Override
    public Student getStudent(int sapId) {
        return null;
    }

    @Override
    public boolean updateStudent(int sapId, String stream) throws SQLException, ClassNotFoundException {
        String query=resourceBundle.getString("updateStudent");
        try(Connection connection=MySQLHelper.getConnection()){
            preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1,stream);
            preparedStatement.setInt(2,sapId);
            //execute query
            int rows=preparedStatement.executeUpdate();
            if(rows>0)
                return true;
            else
                return false;
        }

    }

    @Override
    public boolean deleteStudent(int sapId) {
        return false;
    }
}
