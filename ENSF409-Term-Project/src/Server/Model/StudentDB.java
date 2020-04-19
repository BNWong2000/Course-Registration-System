package Server.Model;

import Server.Controller.DBCredentials;
import Util.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;


public class StudentDB implements DBCredentials {

    // Attributes
    private Connection conn;



    private ResultSet rs;
    private ArrayList<Student> students;

    public StudentDB(Connection conn){
        this.conn = conn;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }



    public void populateStudentDatabase(ArrayList<Student> students){
        for (Student s: students)
            insertStudentPreparedStatement(s);
    }

    public void readStudentsPreparedStatement() {
        ArrayList<Student> students = new ArrayList<>();
        try {
            String query = "SELECT * FROM STUDENT";
            PreparedStatement pStat = conn.prepareStatement(query);
            rs = pStat.executeQuery();
            while (rs.next()) {
                students.add(new Student(rs.getString("name"),rs.getInt("id")));
            }
            pStat.close();
            setStudents(students);
        } catch (SQLException e) {
            System.out.println("problem reading Students");
            e.printStackTrace();
        }
    }


    public void insertStudentPreparedStatement(Student s) {
        try {
            String query = "INSERT INTO STUDENT (ID,name) values(?,?)";
            PreparedStatement pStat = conn.prepareStatement(query);
            pStat.setInt(1, s.getStudentId());
            pStat.setString(2, s.getStudentName());
            int rowCount = pStat.executeUpdate();
            System.out.println("row Count = " + rowCount);
            pStat.close();
        } catch (SQLException e) {
            System.out.println("problem inserting user");
            e.printStackTrace();
        }
    }

    public Student searchStudentPreparedStatement(int id) {
        Student student = null;
        try {
            String query= "SELECT * FROM STUDENT where id= ?";
            PreparedStatement pStat = conn.prepareStatement(query);
            pStat.setInt(1, id);
            rs = pStat.executeQuery();
            while (rs.next()){
                student = getStudent(rs.getInt("id"));
            }
            pStat.close();
        } catch (SQLException e) {
            System.out.println("problem inserting user");
            e.printStackTrace();
        }
        return student;
    }

    public Student searchStudentPreparedStatement(int id, String name) {
        Student student = null;
        try {
            String query= "SELECT * FROM STUDENT where id= ? and name= ?";
            PreparedStatement pStat = conn.prepareStatement(query);
            pStat.setInt(1, id);
            pStat.setString(2, name);
            rs = pStat.executeQuery();
            while (rs.next()){
                student = getStudent(rs.getInt("id"));
            }
            pStat.close();
        } catch (SQLException e) {
            System.out.println("problem inserting user");
            e.printStackTrace();
        }
        return student;
    }

    public Student getStudent(int id){
        for(int i = 0; i < students.size(); ++i){
            if(students.get(i).getStudentId() == id){
                return students.get(i);
            }
        }
        return null;
    }
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
