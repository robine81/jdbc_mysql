package dao;

import db.DBConnection;
import models.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl {
    //init
    {
        String sql = """
                CREATE TABLE IF NOT EXISTS students (
                    student_id INT AUTO_INCREMENT PRIMARY KEY,
                    name VARCHAR(100) NOT NULL,
                    age INT,
                    city VARCHAR(50)
                )
                """;
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Students table created");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sqlquery = "SELECT * FROM students";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sqlquery)) {

            while (rs.next()) {
                students.add(new Student(rs.getInt("student_id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("city")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public void addStudent(Student student){
        String sqlQuery = "INSERT INTO students (name, age, city) " +
                "VALUES ('"+student.getName()+"', '"+student.getAge()+"', '"+student.getCity()+"')";
        try(Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement()){
            stmt.executeUpdate(sqlQuery);
            System.out.println("Student added!");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}