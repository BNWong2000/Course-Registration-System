package Server.Model;

import Server.Controller.DBCredentials;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

public class CourseDB implements DBCredentials {

    // Attributes
    private Connection conn;
    private ResultSet rs;

    public CourseDB(Connection conn){
        this.conn = conn;
    }


    public void insertCoursePreparedStatement(int id, String cName, String cNumber) {
        try {
            String query = "INSERT INTO COURSE (ID,Name,Number) values(?,?,?)";
            PreparedStatement pStat = conn.prepareStatement(query);
            pStat.setInt(1, id);
            pStat.setString(2, cName);
            pStat.setString(3, cName);
            int rowCount = pStat.executeUpdate();
            System.out.println("row Count = " + rowCount);
            pStat.close();
        } catch (SQLException e) {
            System.out.println("problem inserting course");
            e.printStackTrace();
        }
    }

    public void createTable() {
        String sql = "CREATE TABLE COURSE " + "(id INTEGER not NULL, " + " Name VARCHAR(255), "
                + " Number VARCHAR(255), " + " PRIMARY KEY ( id ))";

        try {
            Statement stmt = conn.createStatement(); // construct a statement
            stmt.executeUpdate(sql); // execute my query (i.e. sql)
            stmt.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Table can NOT be created!");
        }
        System.out.println("Created table in given database...");
    }


}
