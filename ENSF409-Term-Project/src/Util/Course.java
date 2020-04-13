package Util;


import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class to store information about courses
 * @author Branden Wong - 30040675
 * @author Savipal Jessel - 30039257
 * @version 2.0
 */
public class Course implements Serializable {

	/**
	 * Serial ID for this class
	 */
	private static final long serialVersionUID=1L;

	/**
	 * the name of the course
	 */
	private String courseName;

	/**
	 * the course number
	 */
	private int courseNum;

	/**
	 * A list of prerequisite courses
	 */
	private ArrayList<Course> preReq;

	/**
	 * A list of offerings for the course
	 */
	private ArrayList<CourseOffering> offeringList;

	/**
	 * A constructor for the course. Assigns the name and number
	 * @param courseName the name of the course
	 * @param courseNum the number of the course
	 */
	public Course(String courseName, int courseNum) {
		this.setCourseName(courseName);
		this.setCourseNum(courseNum);
		// Both of the following are only association
		preReq = new ArrayList<Course>();
		offeringList = new ArrayList<CourseOffering>();
	}

	/**
	 * Adds an offering to the offering list
	 * @param offering the offering to add
	 */
	public void addOffering(CourseOffering offering) {
		if (offering != null && offering.getTheCourse() == null) {
			offering.setTheCourse(this);
			if (!offering.getTheCourse().getCourseName().equals(courseName)
					|| offering.getTheCourse().getCourseNum() != courseNum) {
				System.err.println("Error! This section belongs to another course!");
				return;
			}
			
			offeringList.add(offering);
		}
	}

	/**
	 * Gets the name of the course
	 * @return the name of the course
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * Sets the name of the course
	 * @param courseName the name to set the course to.
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/**
	 * Gets the course number
	 * @return the course number
	 */
	public int getCourseNum() {
		return courseNum;
	}

	/**
	 * Sets the course number
	 * @param courseNum the number to set the course number to.
	 */
	public void setCourseNum(int courseNum) {
		this.courseNum = courseNum;
	}

	/**
	 * Adds a prerequisite to the pre-req. list.
	 * @param preReq the prerequisite course to add.
	 */
	public void addPreReq(Course preReq){
		this.preReq.add(preReq);
	}

	/**
	 * Gets the number of offerings for the course.
	 * @return the number of offerings for the course.
	 */
	public int getNumOfferings(){
		return offeringList.size();
	}

	/**
	 * Returns the string format of the course, for printing
	 * @return the string format of the course information.
	 */
	@Override
	public String toString () {
		String st = "\n";
		st += getCourseName() + " " + getCourseNum ();
		st += "\nAll course sections:\n";
		for (CourseOffering c : offeringList)
			st += c;
		st += "\n-------\n";
		return st;
	}

	/**
	 * Gets a specific course offering at a given index.
	 * @param i the index to get the offering from
	 * @return the course offering.
	 */
	public CourseOffering getCourseOfferingAt(int i) {
		// TODO Auto-generated method stub
		if (i < 0 || i >= offeringList.size() )
			return null;
		else
			return offeringList.get(i);
	}

}
