package dao_database_access_object;

import db.DBConnection;
import models.Student;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class StudentDAOImpl {
    public void insertToTable() {

        {
            String sqlCreate = "CREATE TABLE IF NOT EXISTS ";
            String sqlUseDb = "USE " + databaseName;
            try (Connection conn = DBConnection.getConnection();
                 Statement stmt = conn.createStatement())
            {
                stmt.executeUpdate(sqlCreate);

                stmt.execute(sqlUseDb);
                return null;
            } catch(SQLException e){
                System.out.printf("Failed to create database %s: " + e.getMessage(), databaseName);
                return null;
            }
        }

        public static void useDatabase(String databaseName)
        {
            String sqlUseDb = "USE " + databaseName;
            try ( Connection conn = DBConnection.getConnection();
                  Statement stmt = conn.createStatement())
            {
                stmt.execute(sqlUseDb);
                return conn;
            } catch(SQLException e){
                System.out.printf("Failed to use database %s: " + e.getMessage(), databaseName);
                return null;
            }
        }
    }
}
