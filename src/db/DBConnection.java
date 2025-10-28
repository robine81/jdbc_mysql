package db;

import com.mysql.cj.protocol.Resultset;

import java.sql.*;

public class DBConnection {
    private static final String URL = System.getenv("DB_URL");

    private static final String USER = System.getenv("DB_USER");
    private static final String PASSWORD = System.getenv("DB_PWD");

    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch(SQLException e)
        {
            System.out.printf("Failed to connect to database: ", e.getMessage());
            return null;
        }
    }

    public static Connection createDatabase(String databaseName)
    {
        String sqlCreate = "CREATE DATABASE IF NOT EXISTS " + databaseName;
        String sqlUseDb = "USE " + databaseName;
        try ( Connection conn = DBConnection.getConnection();
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

    public static Connection useDatabase(String databaseName)
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
