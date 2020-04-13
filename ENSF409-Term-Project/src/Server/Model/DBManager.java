package Server.Model;

import Util.Course;
import Util.Student;

import java.util.ArrayList;

/**
 * A class to store the database for the registration system.
 * @author Branden Wong - 30040675
 * @author Savipal Jessel - 30039257
 * @version 2.0
 */
public class DBManager {

	/**
	 * the list of courses stored in the database
	 */
	private ArrayList <Course> courseList;

	/**
	 * the list of students stored in the database
	 */
	private ArrayList <Student> studentList;

	/**
	 * A constructor for the database manager.
	 */
	public DBManager () {
		courseList = new ArrayList<Course>();
		studentList = new ArrayList<Student>();
	}

	/**
	 * gets the course list.
	 * @return the course list
	 */
	public ArrayList<Course> getCourseList() {
		return courseList;
	}

	/**
	 * adds a student to the student list database
	 * @param s
	 */
	public void addStudent(Student s){
		studentList.add(s);
	}

	/**
	 * adds a course to the database
	 * @param c
	 */
	public void addCourse(Course c){
		courseList.add(c);
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
	 * Gets the course list.
	 * @return the course list.
	 */
	public ArrayList readFromDataBase() {
		// TODO Auto-generated method stub
		return courseList;
	}

}
