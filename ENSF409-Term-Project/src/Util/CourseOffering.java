package Util;

import java.io.Serializable;
import java.util.ArrayList;

public class CourseOffering implements Serializable {
	private static final long serialVersionUID=3L;
	private int secNum;
	private int secCap;
	private Course theCourse;
	private ArrayList<Student> studentList;
	private ArrayList <Registration> offeringRegList;

	public CourseOffering(int secNum, int secCap) {
		this.setSecNum(secNum);
		this.setSecCap(secCap);
		offeringRegList = new ArrayList <Registration>();
		studentList = new ArrayList<Student>();
	}
	public int getSecNum() {
		return secNum;
	}
	public void setSecNum(int secNum) {
		this.secNum = secNum;
	}
	public int getSecCap() {
		return secCap;
	}
	public void setSecCap(int secCap) {
		this.secCap = secCap;
	}
	public Course getTheCourse() {
		return theCourse;
	}
	public void setTheCourse(Course theCourse) {
		this.theCourse = theCourse;
	}
	public void removeStudent(Student s){
		for(int i = 0; i < studentList.size(); ++i){
			if(studentList.get(i) == s){
				studentList.remove(i);
				return;
			}
		}
	}

	public void addStudent(Student s){
		if(studentList.size() < secCap) {
			studentList.add(s);
		}
	}

	public boolean isFull(){
		return (secCap == offeringRegList.size());
	}
	@Override
	public String toString () {
		String st = "\n";
		//st += getTheCourse().getCourseName() + " " + getTheCourse().getCourseNum() + "\n";
		st += "Section Num: " + getSecNum() + ", section cap: "+ getSecCap() +"\n";
		//We also want to print the names of all students in the section
		return st;
	}
	public void addRegistration(Registration registration) {
		// TODO Auto-generated method stub
		offeringRegList.add(registration);
		
	}




	public boolean isCourse(String courseName, int courseNum) {
		return theCourse.getCourseName().equals(courseName) && (theCourse.getCourseNum()==courseNum);
	}

	public String getCourseName() {
		return theCourse.getCourseName() + " " + theCourse.getCourseNum();
	}
}
