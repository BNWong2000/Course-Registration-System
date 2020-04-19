package Server.Model;

import Server.Controller.DBCredentials;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

public class CourseOfferingDB implements DBCredentials {

    // Attributes
    private Connection conn;
    private ResultSet rs;
    private int offeringKey;

    public CourseOfferingDB(Connection conn){
        this.conn = conn;
        offeringKey = 0;
    }


    public void insertCourseOfferingPreparedStatement(int sNum, int sCap) {
        try {
            offeringKey++;
            String query = "INSERT INTO COURSEOFFERING (id,Number,Cap) values(?,?,?)";
            PreparedStatement pStat = conn.prepareStatement(query);
            pStat.setInt(1, offeringKey);
            pStat.setInt(2, sNum);
            pStat.setInt(3, sCap);
            int rowCount = pStat.executeUpdate();
            System.out.println("row Count = " + rowCount);
            pStat.close();
        } catch (SQLException e) {
            offeringKey--;
            System.out.println("problem inserting course offering");
            e.printStackTrace();
        }
    }

    public void createTable() {
        String sql = "CREATE TABLE COURSEOFFERING " + "(id INTEGER not NULL, " + " Number INTEGER not NULL, "
                + " Cap INTEGER not NULL, " + " PRIMARY KEY ( id ))";

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
