package controllers;

import models.Student;
import services.StudentService;

import java.util.List;

public class StudentController {
    StudentService service = new StudentService();

    public void getAllStudents(){
        for (Student s: service.getAllStudents()){
            System.out.println(s.toString());
        }
    }

    public void addStudent(String name, int age, String city){
        service.addStudent(name, age, city);
    }
}
