package Server.Model;

import Server.Controller.DBCredentials;
import Util.Course;
import Util.Student;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;

/**
 * A class used to generate a database to house information on courses
 * @author Branden Wong - 30040675
 * @author Savipal Jessel - 30039257
 * @version 1.0
 */
public class CourseDB implements DBCredentials {

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
    private int courseKey;

    /**
     * A constructor for the course database class.
     * @param conn the connection to the database
     */
    public CourseDB(Connection conn){
        this.conn = conn;
        courseKey = 0;
    }

    /**
     * A function which populates the course database with an arraylist of courses
     * @param courses the arraylist of courses to fill the database with
     */
    public void populateCourseDatabase(ArrayList<Course> courses){
        for (Course c: courses)
            insertCoursePreparedStatement(c);
    }

    /**
     * A function which fills an arraylist of courses with all the courses from the database
     * @return an arraylist of courses from the database
     */
    public ArrayList<Course> readCoursesPreparedStatement() {
        ArrayList<Course> courses = new ArrayList<>();
        try {
            String query = "SELECT * FROM COURSE";
            PreparedStatement pStat = conn.prepareStatement(query);
            rs = pStat.executeQuery();
            while (rs.next()) {
                courses.add(new Course(rs.getString("name"),rs.getInt("number")));
            }
            pStat.close();
        } catch (SQLException e) {
            System.out.println("problem reading Courses");
            e.printStackTrace();
        }
        return courses;
    }

    /**
     * A function which adds a course into the database
     * @param c the course to add to the database
     */
    public void insertCoursePreparedStatement(Course c) {
        try {
            courseKey++;
            String query = "INSERT INTO COURSE (id,name,number) values(?,?,?)";
            PreparedStatement pStat = conn.prepareStatement(query);
            pStat.setInt(1, courseKey);
            pStat.setString(2, c.getCourseName());
            pStat.setInt(3, c.getCourseNum());
            int rowCount = pStat.executeUpdate();
            System.out.println("row Count = " + rowCount);
            pStat.close();
        } catch (SQLException e) {
            courseKey--;
            System.out.println("problem inserting course");
            e.printStackTrace();
        }
    }

    /**
     * A function which creates a SQL table for the courses.
     */
    public void createTable() {
        String sql = "CREATE TABLE COURSE " + "(id INTEGER not NULL, " + "name VARCHAR(255), "
                + " number INTEGER not NULL, " + " PRIMARY KEY ( id ))";

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
