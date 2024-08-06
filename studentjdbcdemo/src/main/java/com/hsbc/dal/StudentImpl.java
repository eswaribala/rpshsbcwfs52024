package com.hsbc.dal;

import com.hsbc.helpers.MySQLHelper;
import com.hsbc.models.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class StudentImpl implements StudentDAL{
    private static Connection connection;
    private static ResourceBundle resourceBundle;
    //parameterized queries
    private PreparedStatement preparedStatement;

    public StudentImpl() throws SQLException, ClassNotFoundException {
        //connection= MySQLHelper.getConnection();
        resourceBundle=ResourceBundle.getBundle("db");
    }


    @Override
    public boolean addStudent(Student student) throws SQLException, ClassNotFoundException {
        String query=resourceBundle.getString("addStudent");
        try(Connection connection=MySQLHelper.getConnection()){
            preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1,student.getSapId());
            preparedStatement.setString(2,student.getName());
            preparedStatement.setString(3,student.getStream());
            preparedStatement.setFloat(4,student.getPercentage());
            preparedStatement.setDate(5,student.getDor());


        }


        return false;
    }

    @Override
    public List<Student> getAllStudents() {
        return null;
    }

    @Override
    public Student getStudent(int sapId) {
        return null;
    }

    @Override
    public Student updateStudent(int sapId, String stream) {
        return null;
    }

    @Override
    public boolean deleteStudent(int sapId) {
        return false;
    }
}
