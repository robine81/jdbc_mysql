package dao;

import db.DBConnection;
import models.Course;
import models.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CourseDAOImpl {
    //init
    {
        String sql = """
                CREATE TABLE IF NOT EXISTS courses (
                course_id INT AUTO_INCREMENT PRIMARY KEY,
                course_name VARCHAR(50) NOT NULL,
                credits INT
                )
                """;
        try(Connection conn = DBConnection.getConnection();
        Statement stmt = conn.createStatement())
        {
            stmt.execute(sql);
            System.out.println("Courses table created");
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        String sqlquery = "SELECT * FROM courses";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sqlquery)) {

            while (rs.next()) {
                courses.add(new Course(rs.getInt("course_id"),
                        rs.getString("course_name"),
                        rs.getInt("credits")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }

    public void addCourse(Course course){
        String sqlQuery = "INSERT INTO courses (course_name, credits) " +
                "VALUES ('"+course.getName()+"', "+course.getCredits()+")";
        try(Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement()){
            stmt.executeUpdate(sqlQuery);
            System.out.println("Course added!");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
