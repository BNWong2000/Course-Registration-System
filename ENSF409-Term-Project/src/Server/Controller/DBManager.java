package Server.Controller;

import Server.Model.CourseDB;
import Server.Model.CourseOfferingDB;
import Server.Model.StudentDB;
import Util.Course;
import Util.CourseOffering;
import Util.Student;

import java.sql.*;
import java.util.ArrayList;

/**
 * A class to store the database for the registration system.
 * @author Branden Wong - 30040675
 * @author Savipal Jessel - 30039257
 * @version 2.0
 */
public class DBManager implements DBCredentials {

	private Connection conn;
	private ResultSet rs;
	private StudentDB studentDB;
	private CourseDB courseDB;
	private CourseOfferingDB offeringDB;

	/**
	 * the list of courses that will be loaded from the mySQL database
	 */
	private ArrayList <Course> courseList;

	/**
	 * the list of students that will be loaded from the mySQL database
	 */
	private ArrayList <Student> studentList;

	private ArrayList <CourseOffering> offeringList;
	/**
	 * A constructor for the database manager.
	 */
	public DBManager () {
		courseList = new ArrayList<Course>();
		studentList = new ArrayList<Student>();
		offeringList = new ArrayList<CourseOffering>();
		initializeConnection();
		studentDB = new StudentDB(conn);
		studentDB.createTable();
		courseDB = new CourseDB(conn);
		courseDB.createTable();
		offeringDB = new CourseOfferingDB(conn);
		offeringDB.createTable();
	}

	public ArrayList<CourseOffering> getOfferingList() {
		return offeringList;
	}

	public void setOfferingList(ArrayList<CourseOffering> offeringList) {
		this.offeringList = offeringList;
	}

	/**
	 * gets the course list.
	 * @return the course list
	 */
	public ArrayList<Course> getCourseList() {
		return courseList;
	}

	/**
	 * gets a student by ID
	 * @param id the id to search for
	 * @return the student, it they are found.
	 */
	public Student getStudent(int id){
		for(int i = 0; i < studentList.size(); ++i){
			if(studentList.get(i).getStudentId() == id){
				return studentList.get(i);
			}
		}
		return null;
	}

	/**
	 * gets a student by their name.
	 * @param name the name of the student
	 * @return the student, if they are found.
	 */
	public Student getStudent(String name){
		for(int i = 0; i < studentList.size(); ++i){
			if(studentList.get(i).getStudentName().equals(name)){
				return studentList.get(i);
			}
		}
		return null;
	}

	/**
	 * Loads the course and student lists with the courses from the databse
	 *
	 */
	public void loadFromDataBase() {
		// TODO Auto-generated method stub
		courseList = courseDB.readCoursesPreparedStatement();
		studentList = studentDB.readStudentsPreparedStatement();
		offeringList = offeringDB.readCourseOfferingPreparedStatement();

	}

	public CourseOfferingDB getOfferingDB() {
		return offeringDB;
	}

	public void setOfferingDB(CourseOfferingDB offeringDB) {
		this.offeringDB = offeringDB;
	}

	public StudentDB getStudentDB() {
		return studentDB;
	}

	public void setStudentDB(StudentDB studentDB) {
		this.studentDB = studentDB;
	}

	public CourseDB getCourseDB() {
		return courseDB;
	}

	public void setCourseDB(CourseDB courseDB) {
		this.courseDB = courseDB;
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
