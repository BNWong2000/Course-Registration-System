package Util;


import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class to store information about students.
 * @author Branden Wong - 30040675
 * @author Savipal Jessel - 30039257
 * @version 2.0
 */
public class Student implements Serializable {
	/**
	 * the serial ID of the class
	 */
	private static final long serialVersionUID=2L;

	/**
	 * the name of the student
	 */
	private String studentName;

	/**
	 * the student ID for the student.
	 */
	private int studentId;

	/**
	 * The offerings that the student is enrolled in
	 */
	private ArrayList<CourseOffering> offeringList;

	/**
	 * All of the course registrations that the student had.
	 */
	private ArrayList<Registration> studentRegList;

	/**
	 * A constructor for the student
	 * @param studentName the student's name
	 * @param studentId the student's ID
	 */
	public Student (String studentName, int studentId) {
		this.setStudentName(studentName);
		this.setStudentId(studentId);
		studentRegList = new ArrayList<Registration>();
		offeringList = new ArrayList<CourseOffering>();
	}

	/**
	 * gets the student's name.
	 * @return the name of the student
	 */
	public String getStudentName() {
		return studentName;
	}

	/**
	 * Sets the student's name
	 * @param studentName the name to set.
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	/**
	 * Gets the student's ID
	 * @return the students ID
	 */
	public int getStudentId() {
		return studentId;
	}

	/**
	 * Sets the student's ID
	 * @param studentId the ID to set the student to.
	 */
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	/**
	 * Adds the student to a course offering.
	 * @param offering the offering to add the student to.
	 */
	public void addOffering(CourseOffering offering){
		if(offeringList.size() < 6){
			offeringList.add(offering);
		}
		else{
			System.out.println("Student is already enrolled in 6 courses. Cannot enroll in any more this semester.");
		}
	}

	/**
	 * Gets information about the student.
	 * @return the information about the student in a string form.
	 */
	@Override
	public String toString () {
		String st = "Student Name: " + getStudentName() + "\n" +
				"Student Id: " + getStudentId() + "\n\n";
		return st;
	}

	/**
	 * Prints the registration list in a string.
	 * @return the registration list in string form.
	 */
	public String registrationListToString(){
		String st = "";
		for(int i = 0; i < studentRegList.size(); ++i){
			st += studentRegList.get(i).toString();
			st += "\n";
		}
		return st;
	}

	/**
	 * Adds a registration to the student
	 * @param registration the registration to add.
	 */
	public void addRegistration(Registration registration) {
		// TODO Auto-generated method stub
		studentRegList.add(registration);

	}

	/**
	 * checks if the student is in the specified course
	 * @param courseName the name of the course
	 * @param courseNum the course number
	 * @return true if the student is enrolled in this course
	 */
	public boolean isInCourse(String courseName, int courseNum){
		for(int i = 0; i < offeringList.size(); ++i){
			if(offeringList.get(i).isCourse(courseName, courseNum)){
				return true;
			}
		}
		return false;
	}

	/**
	 * Removes the student from the course
	 * @param courseName the name of the course
	 * @param courseNum the course number
	 */
	public void removeFrom(String courseName, int courseNum) {
		for(int i = 0; i < offeringList.size(); ++i){
			if(offeringList.get(i).isCourse(courseName, courseNum)){
				offeringList.remove(i);
				break;
			}
		}
		for(int j = 0; j < studentRegList.size(); ++j){
			if(studentRegList.get(j).isCourse(courseName, courseNum)){
				studentRegList.get(j).removeRegistration();
				studentRegList.remove(j);
			}
		}
	}
}
