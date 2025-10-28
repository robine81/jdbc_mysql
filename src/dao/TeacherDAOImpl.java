package dao;

import db.DBConnection;
import models.Course;
import models.Teacher;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TeacherDAOImpl {
    //init
    {
        String sql = """
                CREATE TABLE IF NOT EXISTS teachers (
                teacher_id INT AUTO_INCREMENT PRIMARY KEY,
                name VARCHAR(50) NOT NULL,
                department VARCHAR(50)
                )
                """;
        try(Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement())
        {
            stmt.execute(sql);
            System.out.println("Teachers table created");
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public List<Teacher> getAllTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        String sqlquery = "SELECT * FROM teachers";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sqlquery)) {

            while (rs.next()) {
                teachers.add(new Teacher(rs.getInt("teacher_id"),
                        rs.getString("name"),
                        rs.getString("department")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teachers;
    }

    public void addTeacher(Teacher teacher){
        String sqlQuery = "INSERT INTO teachers (name, department) " +
                "VALUES ('"+teacher.getName()+"', '"+teacher.getDepartment()+"')";
        try(Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement()){
            stmt.executeUpdate(sqlQuery);
            System.out.println("Teacher added!");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
