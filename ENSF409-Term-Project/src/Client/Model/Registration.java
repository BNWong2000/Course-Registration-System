package Client.Model;

import Client.Model.CourseOffering;
import Client.Model.Student;

public class Registration {
	private Student theStudent;
	private CourseOffering theOffering;
	private char grade;

	public void completeRegistration (Student st, CourseOffering of) {
		theStudent = st;
		theOffering = of;
		addRegistration ();
	}

	public boolean isCourse(String courseName, int courseNum){
		return theOffering.isCourse(courseName, courseNum);
	}

	private void addRegistration () {
		theStudent.addRegistration(this);
		theOffering.addRegistration(this);
		theStudent.addOffering(theOffering);
		theOffering.addStudent(theStudent);
	}


	public Student getTheStudent() {
		return theStudent;
	}
	public void setTheStudent(Student theStudent) {
		this.theStudent = theStudent;
	}
	public CourseOffering getTheOffering() {
		return theOffering;
	}
	public void setTheOffering(CourseOffering theOffering) {
		this.theOffering = theOffering;
	}
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}
	
	@Override
	public String toString () {
		String st = "\n";
		st += "The Offering: " + getTheOffering () + "\n";
		st += "Grade: " + getGrade();
		st += "\n-----------\n";
		return st;
		
	}


	public void removeRegistration() {
		getTheOffering().removeStudent(theStudent);
	}
}
