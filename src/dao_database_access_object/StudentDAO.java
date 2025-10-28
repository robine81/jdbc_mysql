package dao_database_access_object;

import models.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDAO extends BaseDAO<Student> {
    List<Student> findByName(String name) throws SQLException;
    Student findByEmail(String email) throws SQLException;
    //void insertStudent();
    //List<Student> showAllStudents();

    //Student getOldestStudent();
}
