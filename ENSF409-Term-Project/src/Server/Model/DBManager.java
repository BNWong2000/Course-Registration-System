package Server.Model;

import Util.Course;
import Util.Student;

import java.util.ArrayList;

//This class is simulating a database for our
//program
public class DBManager {

	private ArrayList <Course> courseList;
	private ArrayList <Student> studentList;

	public DBManager (ArrayList<Course> courseList, ArrayList<Student> studentList) {
		setCourseList(courseList);
		setStudentList(studentList);
	}
	public DBManager () {
		courseList = new ArrayList<Course>();
		studentList = new ArrayList<Student>();
	}

	public ArrayList<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(ArrayList<Course> courseList) {
		this.courseList = courseList;
	}

	public ArrayList<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}

	public void addStudent(Student s){
		studentList.add(s);
	}

	public void addCourse(Course c){
		courseList.add(c);
	}

	public Course getCourse(String name, int num){
		for(int i = 0; i < courseList.size(); ++i){
			if(courseList.get(i).getCourseName().equals(name) && courseList.get(i).getCourseNum() == num){
				return courseList.get(i);
			}
		}
		return null;
	}

	public Student getStudent(int id){
		for(int i = 0; i < studentList.size(); ++i){
			if(studentList.get(i).getStudentId() == id){
				return studentList.get(i);
			}
		}
		return null;
	}

	public ArrayList readFromDataBase() {
		// TODO Auto-generated method stub
		return courseList;
	}

}
