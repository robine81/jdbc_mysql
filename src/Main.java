import dao_database_access_object.StudentDAO;
import dao_database_access_object.StudentDAOImpl;
import db.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String databaseName = "SchoolDB";
        String useDatabaseQuery = "USE " + databaseName;
        createDatabase(databaseName);
        createAllTables(databaseName, useDatabaseQuery);
    }



    public static void createDatabase(String databaseName){
       try(Connection conn = DBConnection.createDatabase(databaseName))
       {
           System.out.printf("Database created%n");
       } catch (SQLException e) {
           System.err.println("Something went wrong" + e.getMessage());
       }
    }

    public static void useDatabase(String databaseName){
        try(Connection conn = DBConnection.useDatabase(databaseName))
        {
            System.out.printf("Using database %s%n", databaseName);
        } catch (SQLException e) {
            System.err.println("Something went wrong" + e.getMessage());
        }
    }

    public static void createAllTables(String databaseName, String useDatabaseQuery){
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(useDatabaseQuery);
            createStudentsTable(stmt);
        } catch (SQLException e) {
            System.err.println("Something went wrong with creating table " + e.getMessage());
        }
    }

    private static void createStudentsTable(Statement stmt) throws SQLException {
        String sql = """
            CREATE TABLE IF NOT EXISTS students (
                student_id INT AUTO_INCREMENT PRIMARY KEY,
                name VARCHAR(100) NOT NULL,
                age INT,
                city VARCHAR(50)
            )
            """;
        stmt.execute(sql);
        System.out.println("Students table created");
    }
}
