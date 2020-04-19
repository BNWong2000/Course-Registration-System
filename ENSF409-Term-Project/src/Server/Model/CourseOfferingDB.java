package Server.Model;

import Server.Controller.DBCredentials;
import Util.Course;
import Util.CourseOffering;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;

/**
 * A class for creating a database to house information about course offerings.
 */
public class CourseOfferingDB implements DBCredentials {

    /**
     * The connection to the database
     */
    private Connection conn;

    /**
     * The response from the query when getting information from the database
     */
    private ResultSet rs;

    /**
     * A key which tracks the primary ID of the course.
     */
    private int offeringKey;

    /**
     * The constructor for course offering database. Creates the connection to the database
     * @param conn the connection to the database
     */
    public CourseOfferingDB(Connection conn){
        this.conn = conn;
        offeringKey = 0;
    }

    /**
     * A function used to populate the database with an arraylist of course offerings.
     * @param offerings the arraylist of course offerings.
     */
    public void populateOfferingDatabase(ArrayList<CourseOffering> offerings){
        for (CourseOffering c: offerings)
            insertCourseOfferingPreparedStatement(c);
    }

    /**
     * A functino used to obtain an arraylist of course offerings from the database.
     * @return the list of course offerings in the database
     */
    public ArrayList<CourseOffering> readCourseOfferingPreparedStatement() {
        ArrayList<CourseOffering> offering = new ArrayList<>();
        try {
            String query = "SELECT * FROM COURSEOFFERING";
            PreparedStatement pStat = conn.prepareStatement(query);
            rs = pStat.executeQuery();
            while (rs.next()) {
                offering.add(new CourseOffering(rs.getInt("number"),rs.getInt("cap")));
            }
            pStat.close();
        } catch (SQLException e) {
            System.out.println("problem reading Course Offerings");
            e.printStackTrace();
        }
        return offering;
    }

    /**
     * A function used to insert course offerings into the database
     * @param c the course offering to add to the database
     */
    public void insertCourseOfferingPreparedStatement(CourseOffering c) {
        try {
            offeringKey++;
            String query = "INSERT INTO COURSEOFFERING (id,number,cap) values(?,?,?)";
            PreparedStatement pStat = conn.prepareStatement(query);
            pStat.setInt(1, offeringKey);
            pStat.setInt(2, c.getSecNum());
            pStat.setInt(3, c.getSecCap());
            int rowCount = pStat.executeUpdate();
            System.out.println("row Count = " + rowCount);
            pStat.close();
        } catch (SQLException e) {
            offeringKey--;
            System.out.println("problem inserting course offering");
            e.printStackTrace();
        }
    }

    /**
     * a function used to generate the SQL table for the course offerings.
     */
    public void createTable() {
        String sql = "CREATE TABLE COURSEOFFERING " + "(id INTEGER not NULL, " + " number INTEGER not NULL, "
                + " cap INTEGER not NULL, " + " PRIMARY KEY ( id ))";

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
