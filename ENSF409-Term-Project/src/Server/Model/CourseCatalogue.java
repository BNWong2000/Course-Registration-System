package Server.Model;

import java.util.ArrayList;

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
	private CourseDB courseDB;

	/**
	 * The database to store all the information in
	 */
	private DBManager db;


	public CourseCatalogue (CourseDB courseDB) {
		this.courseDB = courseDB;
	}

	/**
	 * sets the database
	 * @param db the database to set.
	 */
	public void setDb(DBManager db){
		this.db = db;
	}



	/**
	 * crease a new course offering
	 * @param c the course
	 * @param secNum the section number
	 * @param secCap the max cap of the section.
	 */
	public void createCourseOffering (Course c, int secNum, int secCap) {
		if (c!= null) {
			CourseOffering theOffering = new CourseOffering (secNum, secCap);
			c.addOffering(theOffering);
		}
	}

	/**
	 * searches the catalogue for a given course
	 * @param courseName the name of the course to search for
	 * @param courseNum the course number to search for
	 * @return the course, if it is found, or null if it is not found.
	 */
	public Course searchCat (String courseName, int courseNum) {
		Course course = courseDB.searchCoursePreparedStatement(courseName,courseNum);
		if (course == null){
			displayCourseNotFoundError();
			return null;
		}
		return course;
	}

	/**
	 * prints an error if the course is not found.
	 */
	private void displayCourseNotFoundError() {
		// TODO Auto-generated method stub
		System.err.println("Course was not found!");
		
	}



	/**
	 * Gets the information about the course catalogue
	 * @return the information in the course catalogue in string form.
	 */
	@Override
	public String toString () {
		String st = "All courses in the catalogue: \n";
		for (Course c : courseDB.getCourses()) {
			st += c;  //This line invokes the toString() method of Course
			st += "\n";
		}
		return st;
	}

}
