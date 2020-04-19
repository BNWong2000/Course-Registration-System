package Server.Model;

import java.util.ArrayList;

import Server.Controller.DBManager;
import Util.Course;
import Util.CourseOffering;

/**
 * A class to store the catalogue of courses available
 * @author Branden Wong - 30040675
 * @author Savipal Jessel - 30039257
 * @version 2.0
 */
public class CourseCatalogue {

	/**
	 * The list of courses on the catalogue
	 */
	private ArrayList <Course> courseList;

	/**
	 * The database to store all the information in
	 */
	private DBManager db;

	/**
	 * A constructor for the course catalogue
	 * @param db the database to retrieve information from.
	 */
	public CourseCatalogue (DBManager db) {
		setDb(db);
	}

	/**
	 * sets the database
	 * @param db the database to set.
	 */
	public void setDb(DBManager db){
		this.db = db;
	}

	/**
	 * loads information from the database.
	 */
	public void readCourseList() {
		// TODO Auto-generated method stub
		//DBManager db = new DBManager();
		setCourseList(db.getCourseList());

	}


	public void createCourseOfferings (ArrayList<CourseOffering> offerings) {
		int j = 0;
		for (int i = 0; i < courseList.size(); i++,j++){
			if (courseList.get(i) != null){
				courseList.get(i).addOffering(offerings.get(j));
			}
		}
		for (int i = 0; i < courseList.size(); i++,j++){
			if (courseList.get(i) != null){
				courseList.get(i).addOffering(offerings.get(j));
			}
		}
	}
	/**
	 * searches the catalogue for a given course
	 * @param courseName the name of the course to search for
	 * @param courseNum the course number to search for
	 * @return the course, if it is found, or null if it is not found.
	 */
	public Course searchCat (String courseName, int courseNum) {
		for (Course c : courseList) {
			if (courseName.equals(c.getCourseName()) &&
					courseNum == c.getCourseNum()) {
				return c;
			}	
		}
		displayCourseNotFoundError();
		return null;
	}

	/**
	 * prints an error if the course is not found.
	 */
	private void displayCourseNotFoundError() {
		// TODO Auto-generated method stub
		System.err.println("Course was not found!");
		
	}

	/**
	 * Gets the list of courses.
	 * @return the list of courses.
	 */
	public ArrayList <Course> getCourseList() {
		return courseList;
	}

	/**
	 * Sets the list of courses
	 * @param courseList the course list to set to.
	 */
	public void setCourseList(ArrayList <Course> courseList) {
		this.courseList = courseList;
	}

	/**
	 * Gets the information about the course catalogue
	 * @return the information in the course catalogue in string form.
	 */
	@Override
	public String toString () {
		String st = "All courses in the catalogue: \n";
		for (Course c : courseList) {
			st += c;  //This line invokes the toString() method of Course
			st += "\n";
		}
		return st;
	}

}
