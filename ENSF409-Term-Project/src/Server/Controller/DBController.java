package Server.Controller;



import Server.Model.StudentDB;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBController implements DBCredentials {

    // Attributes
    private Connection conn;
    private ResultSet rs;
    private StudentDB studentDB;

    public DBController(){
        initializeConnection();
        studentDB = new StudentDB(conn);


    }

    public void initializeConnection() {
        try {
            // Register JDBC driver
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            // Open a connection
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("SQL Exception!");
            e.printStackTrace();
        }

    }
    public void close() {
        try {
            // rs.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}