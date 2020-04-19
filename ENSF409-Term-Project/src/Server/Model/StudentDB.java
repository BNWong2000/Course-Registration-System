package Server.Model;

import Server.Controller.DBCredentials;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

public class StudentDB implements DBCredentials {

    // Attributes
    private Connection conn;
    private ResultSet rs;

    public StudentDB(Connection conn){
        this.conn = conn;
    }



    public void insertStudentPreparedStatement(int id, String Name) {
        try {
            String query = "INSERT INTO STUDENT (ID,first,last) values(?,?,?)";
            PreparedStatement pStat = conn.prepareStatement(query);
            pStat.setInt(1, id);
            pStat.setString(2, Name);
            int rowCount = pStat.executeUpdate();
            System.out.println("row Count = " + rowCount);
            pStat.close();
        } catch (SQLException e) {
            System.out.println("problem inserting user");
            e.printStackTrace();
        }
    }

    public void createTable() {
        String sql = "CREATE TABLE STUDENT " + "(id INTEGER not NULL, " + " Name VARCHAR(255), "
                 + " PRIMARY KEY ( id ))";

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
