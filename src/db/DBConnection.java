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
}
