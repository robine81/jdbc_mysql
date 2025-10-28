package services;

import dao.CourseDAOImpl;
import models.Course;
import models.Student;

import java.util.List;

public class CourseService {
    CourseDAOImpl dao = new CourseDAOImpl();

    public List<Course> getAllCourses(){ return dao.getAllCourses(); }

    public void addCourse(String name, int credits){
        dao.addCourse(new Course(name, credits));
    }
}
