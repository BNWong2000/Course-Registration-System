package Util;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class to store information about course offerings
 * @author Branden Wong - 30040675
 * @author Savipal Jessel - 30039257
 * @version 2.0
 */
public class CourseOffering implements Serializable {
	/**
	 * The serial number for the class.
	 */
	private static final long serialVersionUID=3L;

	/**
	 * the section number
	 */
	private int secNum;

	/**
	 * the maximum number of people who can join this section
	 */
	private int secCap;

	/**
	 * the course that this offering is for.
	 */
	private Course theCourse;

	/**
	 * The list of students in this offering
	 */
	private ArrayList<Student> studentList;

	/**
	 * The list of registrations for this offering
	 */
	private ArrayList <Registration> offeringRegList;

	/**
	 * A constructor for the course offering class.
	 * @param secNum the section number
	 * @param secCap the max. number of students allowed.
	 */
	public CourseOffering(int secNum, int secCap) {
		this.setSecNum(secNum);
		this.setSecCap(secCap);
		offeringRegList = new ArrayList <Registration>();
		studentList = new ArrayList<Student>();
	}

	/**
	 * Gets the section number.
	 * @return the section number.
	 */
	public int getSecNum() {
		return secNum;
	}

	/**
	 * Sets the section number.
	 * @param secNum The section number to set.
	 */
	public void setSecNum(int secNum) {
		this.secNum = secNum;
	}

	/**
	 * Gets the max number of students in this offering.
	 * @return the section cap.
	 */
	public int getSecCap() {
		return secCap;
	}

	/**
	 * Sets the max number of students in this offering.
	 * @param secCap the max number of students to set.
	 */
	public void setSecCap(int secCap) {
		this.secCap = secCap;
	}

	/**
	 * Gets the course.
	 * @return the course.
	 */
	public Course getTheCourse() {
		return theCourse;
	}

	/**
	 * Sets the course.
	 * @param theCourse the course to set.
	 */
	public void setTheCourse(Course theCourse) {
		this.theCourse = theCourse;
	}

	/**
	 * Removes a student from this offering
	 * @param s the student to remove.
	 */
	public void removeStudent(Student s){
		for(int i = 0; i < studentList.size(); ++i){
			if(studentList.get(i) == s){
				studentList.remove(i);
				return;
			}
		}
	}

	/**
	 * Adds a student to this offering
	 * @param s the student to add.
	 */
	public void addStudent(Student s){
		if(studentList.size() < secCap) {
			studentList.add(s);
		}
	}

	/**
	 * Checks if the section is full.
	 * @return true if the section is full.
	 */
	public boolean isFull(){
		return (secCap == offeringRegList.size());
	}

	/**
	 * Gets the information about the course offering.
	 * @return the string form of the information about the offering.
	 */
	@Override
	public String toString () {
		String st = "\n";
		//st += getTheCourse().getCourseName() + " " + getTheCourse().getCourseNum() + "\n";
		st += "Section Num: " + getSecNum() + ", section cap: "+ getSecCap() +"\n";
		//We also want to print the names of all students in the section
		return st;
	}

	/**
	 * Adds a registration to the reg list.
	 * @param registration the registration to add.
	 */
	public void addRegistration(Registration registration) {
		// TODO Auto-generated method stub
		offeringRegList.add(registration);
		
	}

	/**
	 * checks if the specified course exists.
	 * @param courseName the name of the course
	 * @param courseNum the number of the course
	 * @return true if the course exists.
	 */
	public boolean isCourse(String courseName, int courseNum) {
		return theCourse.getCourseName().equals(courseName) && (theCourse.getCourseNum()==courseNum);
	}

	/**
	 * gets the name of the course
	 * @return the name of the course.
	 */
	public String getCourseName() {
		return theCourse.getCourseName() + " " + theCourse.getCourseNum();
	}
}
