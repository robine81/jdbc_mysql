package services;

import dao.StudentDAOImpl;
import models.Student;

import java.util.List;

public class StudentService {
    StudentDAOImpl dao = new StudentDAOImpl();

    public List<Student> getAllStudents(){ return dao.getAllStudents(); }

    public void addStudent(String name, int age, String city){
        dao.addStudent(new Student(name, age,city));
    }
}
