package dao;

import models.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDAO{

    List<Student> findByName(String name) throws SQLException;
    Student findByEmail(String email) throws SQLException;
    //void insertStudent();
    //List<Student> showAllStudents();

    //Student getOldestStudent();
}
