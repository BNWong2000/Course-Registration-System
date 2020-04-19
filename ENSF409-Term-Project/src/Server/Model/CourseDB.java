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

public class CourseDB implements DBCredentials {

    // Attributes
    private Connection conn;
    private ResultSet rs;
    private int courseKey;
    private ArrayList<Course> Courses;


    public CourseDB(Connection conn){
        this.conn = conn;
        courseKey = 0;
    }

    public ArrayList<Course> getCourses() {
        return Courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        Courses = courses;
    }

    public void loadCourseDatabase(ArrayList<Course> courses){
        for (Course c: courses)
            insertCoursePreparedStatement(c);
    }

    public void readCoursesPreparedStatement() {
        ArrayList<Course> courses = new ArrayList<>();
        try {
            String query = "SELECT * FROM COURSE";
            PreparedStatement pStat = conn.prepareStatement(query);
            rs = pStat.executeQuery();
            while (rs.next()) {
                courses.add(new Course(rs.getString("Name"),rs.getInt("Number")));
            }
            pStat.close();
            setCourses(courses);
        } catch (SQLException e) {
            System.out.println("problem reading Courses");
            e.printStackTrace();
        }
    }

    public void insertCoursePreparedStatement(Course c) {
        try {
            courseKey++;
            String query = "INSERT INTO COURSE (id,Name,Number) values(?,?,?)";
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

    public void createTable() {
        String sql = "CREATE TABLE COURSE " + "(id INTEGER not NULL, " + " Name VARCHAR(255), "
                + " Number INTEGER not NULL, " + " PRIMARY KEY ( id ))";

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
