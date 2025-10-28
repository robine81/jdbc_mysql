package controllers;

import models.Course;
import models.Student;
import services.CourseService;

public class CourseController {
    CourseService service = new CourseService();

    public void getAllCourses(){
        for (Course c: service.getAllCourses()){
            System.out.println(c.toString());
        }
    }

    public void addCourse(String course_name, int credits){
        service.addCourse(course_name, credits);
    }
}
