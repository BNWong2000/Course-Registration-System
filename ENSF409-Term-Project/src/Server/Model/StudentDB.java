package Server.Model;

import Server.Controller.DBCredentials;
import Util.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;

/**
 * A class used to generate a database to house information about students.
 * @author Branden Wong - 30040675
 * @author Savipal Jessel - 30039257
 * @version 1.0
 */
public class StudentDB implements DBCredentials {

    /**
     * The connection to the database
     */
    private Connection conn;

    /**
     * The response from the query when getting information from the database
     */
    private ResultSet rs;

    /**
     * A constructor for the student database.
     * @param conn the connection to the database
     */
    public StudentDB(Connection conn){
        this.conn = conn;
    }

    /**
     * A function which adds an arraylist of students to the database
     * @param students the arraylist of students to add to the database
     */
    public void populateStudentDatabase(ArrayList<Student> students){
        for (Student s: students)
            insertStudentPreparedStatement(s);
    }

    /**
     * A function which query's the database for students, and returns a list of students from the database.
     * @return the list of students obtained from the database.
     */
    public ArrayList<Student> readStudentsPreparedStatement() {
        ArrayList<Student> students = new ArrayList<>();
        try {
            String query = "SELECT * FROM STUDENT";
            PreparedStatement pStat = conn.prepareStatement(query);
            rs = pStat.executeQuery();
            while (rs.next()) {
                students.add(new Student(rs.getString("name"),rs.getInt("id")));
            }
            pStat.close();
        } catch (SQLException e) {
            System.out.println("problem reading Students");
            e.printStackTrace();
        }
        return students;
    }

    /**
     * A function which adds a student to the database
     * @param s the student to add to the database
     */
    public void insertStudentPreparedStatement(Student s) {
        try {
            String query = "INSERT INTO STUDENT (ID,name) values(?,?)";
            PreparedStatement pStat = conn.prepareStatement(query);
            pStat.setInt(1, s.getStudentId());
            pStat.setString(2, s.getStudentName());
            pStat.executeUpdate();
            System.out.println("record inserted into table in database");
            pStat.close();
        } catch (SQLException e) {
            System.out.println("problem inserting user");
            e.printStackTrace();
        }
    }

    /**
     * A function which creates a table in the database for students
     */
    public void createTable() {
        String sql = "CREATE TABLE STUDENT " + "(id INTEGER not NULL, " + "name VARCHAR(255), "
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
