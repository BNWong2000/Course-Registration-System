package Util;

import java.io.Serializable;

/**
 * A class to store information about course registration.
 * @author Branden Wong - 30040675
 * @author Savipal Jessel - 30039257
 * @version 2.0
 */
public class Registration implements Serializable {

	/**
	 * The serial ID of the class.
	 */
	private static final long serialVersionUID=4L;

	/**
	 * The student who is registering.
	 */
	private Student theStudent;

	/**
	 * the offering they are registering for.
	 */
	private CourseOffering theOffering;

	/**
	 * the student's grade
	 */
	private char grade;

	/**
	 * Registers the student to the course offering.
	 * @param st the student registering
	 * @param of the offering for the course
	 */
	public void completeRegistration (Student st, CourseOffering of) {
		theStudent = st;
		theOffering = of;
		addRegistration();
	}

	/**
	 * checks if the selected course is a course
	 * @param courseName the name of the course
	 * @param courseNum the number of the course
	 * @return true if the course is a course.
	 */
	public boolean isCourse(String courseName, int courseNum){
		return theOffering.isCourse(courseName, courseNum);
	}

	/**
	 * Adds the registration to both the student and the course
	 */
	private void addRegistration(){
		theStudent.addRegistration(this);
		theOffering.addRegistration(this);
		theStudent.addOffering(theOffering);
		theOffering.addStudent(theStudent);
	}

	/**
	 * gets the student
	 * @return the student
	 */
	public Student getTheStudent() {
		return theStudent;
	}

	/**
	 * sets the student
	 * @param theStudent the student to set to.
	 */
	public void setTheStudent(Student theStudent) {
		this.theStudent = theStudent;
	}

	/**
	 * Gets the course offering
	 * @return the course offering.
	 */
	public CourseOffering getTheOffering() {
		return theOffering;
	}

	/**
	 * gets the grade for the course
	 * @return the grade the student got.
	 */
	public char getGrade() {
		return grade;
	}

	/**
	 * Gets the information about the registration.
	 * @return the information about the registration in string form
	 */
	@Override
	public String toString () {
		String st = "\n";
		st += "The Course: " + getTheOffering().getCourseName() + "\n";
		st += "The Offering: " + getTheOffering () + "\n";
		st += "Grade: " + getGrade();
		st += "\n-----------\n";
		return st;
		
	}

	/**
	 * Removes the registration from the student.
	 */
	public void removeRegistration() {
		getTheOffering().removeStudent(theStudent);
	}
}
