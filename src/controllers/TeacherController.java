package controllers;

import models.Teacher;
import services.TeacherService;

public class TeacherController {
    TeacherService service = new TeacherService();

    public void getAllTeachers(){
        for (Teacher t: service.getAllTeachers()){
            System.out.println(t.toString());
        }
    }

    public void addTeacher(String name, String department){
        service.addTeacher(name, department);
    }
}
