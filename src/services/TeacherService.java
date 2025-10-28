package services;

import dao.TeacherDAOImpl;
import models.Teacher;

import java.util.List;

public class TeacherService {
    TeacherDAOImpl dao = new TeacherDAOImpl();

    public List<Teacher> getAllTeachers(){ return dao.getAllTeachers(); }

    public void addTeacher(String name, String department){
        dao.addTeacher(new Teacher(name, department));
    }
}
