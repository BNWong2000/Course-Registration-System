package Server.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {
	private static final long serialVersionUID=2L;
	private String studentName;
	private int studentId;
	private ArrayList<CourseOffering> offeringList;
	private ArrayList<Registration> studentRegList;
	
	public Student (String studentName, int studentId) {
		this.setStudentName(studentName);
		this.setStudentId(studentId);
		studentRegList = new ArrayList<Registration>();
		offeringList = new ArrayList<CourseOffering>();
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public void addOffering(CourseOffering offering){
		if(offeringList.size() < 6){
			offeringList.add(offering);
		}
		else{
			System.out.println("Student is already enrolled in 6 courses. Cannot enroll in any more this semester.");
		}
	}
	@Override
	public String toString () {
		String st = "Student Name: " + getStudentName() + "\n" +
				"Student Id: " + getStudentId() + "\n\n";
		return st;
	}

	public String registrationListToString(){
		String st = "";
		for(int i = 0; i < studentRegList.size(); ++i){
			st += studentRegList.get(i).toString();
			st += "\n";
		}
		return st;
	}
	public void addRegistration(Registration registration) {
		// TODO Auto-generated method stub

		studentRegList.add(registration);

	}

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
