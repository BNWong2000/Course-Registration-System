package Server;

import Server.Model.*;

import java.util.Scanner;

public class RegistrationApp {
	private Scanner scanner;
	private CourseCatalogue cat;
	private DBManager database;
	public RegistrationApp(){
		scanner = new Scanner(System.in);
		database = new DBManager();
		//fillDatabase();
		cat = new CourseCatalogue (database);
	}

	public DBManager getDatabase() {
		return database;
	}

	private void printMenu(){
		System.out.println("Please choose from one of the options:\n" +
				"1 - Search Course Catalogue\n" +
				"2 - Add Course to Student Courses\n" +
				"3 - Remove Course from Student Courses\n" +
				"4 - View all courses in the catalogue\n" +
				"5 - View all courses taken by the student\n" +
				"6 - quit\n" +
				"\n" +
				"please enter your selection.");
	}

	public void menu() {
		while(true){
			printMenu();
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch(choice){
				case 1:
					searchCourseCatalogue();
					break;
				case 2:
					addCourseToStudent();
					break;
				case 3:
					removeCourseFromStudent();
					break;
				case 4:
					printCatalogue();
					break;
				case 5:
					printStudentCourses();
					break;
				case 6:
					System.out.println("\nGood Bye!");
					return;
				default:
					System.out.println("Invalid Selection. Please try again.");
					break;
			}
		}
	}

	private void printCatalogue() {
		System.out.println(cat.toString());
	}

	private void removeCourseFromStudent() {
		String courseName = getCourseName();
		int courseNum = getCourseNum();
		Course theCourse = cat.searchCat(courseName, courseNum);
		if(theCourse!= null){
			int id = getStudentId();
			if(database.getStudent(id) != null){
				database.getStudent(id).removeFrom(courseName, courseNum);
				System.out.println("Removed student from " + courseName + " " + courseNum );
			}else{
				System.out.println("Could not perform this action!. ");
			}
		}
	}

	private void printStudentCourses() {
		int id = getStudentId();
		System.out.println(database.getStudent(id));
		System.out.println(database.getStudent(id).registrationListToString());
	}

	private void addCourseToStudent() {
		String courseName = getCourseName();
		int courseNum = getCourseNum();
		Course theCourse = cat.searchCat(courseName, courseNum);
		if(theCourse != null){
			int id = getStudentId();
			if(database.getStudent(id)!= null){
				Registration temp = new Registration();
				int sectionNum = getCourseSection();
				if(sectionNum > theCourse.getNumOfferings()){
					System.out.println("Could not perform this action.");
					return;
				}
				if(theCourse.getCourseOfferingAt(sectionNum-1).isFull()){
					theCourse.addOffering(new CourseOffering(sectionNum, 200));
					temp.completeRegistration(database.getStudent(id), theCourse.getCourseOfferingAt(sectionNum));
					System.out.println("This Section is Full!\n Added student to " + courseName + " " + courseNum + " Section " + (sectionNum+1) + "instead");
				}else {
					temp.completeRegistration(database.getStudent(id), theCourse.getCourseOfferingAt(sectionNum - 1));
					System.out.println("Added student to " + courseName + " " + courseNum + " Section " + sectionNum);
				}
			}
		}else{
			System.out.println("Could not perform this action!. ");
		}
	}

	private int getCourseSection() {
		System.out.println("Please enter the section number you would like to enroll in");
		return scanner.nextInt();
	}

	private int getStudentId() {
		System.out.println("Please enter the student ID");
		return scanner.nextInt();
	}



	private void searchCourseCatalogue() {
		String name = getCourseName();
		int num = getCourseNum();
		if(cat.searchCat(name, num) != null){
			System.out.println(cat.searchCat(name, num).toString());
		}
	}

	private String getCourseName() {
		System.out.println("Please enter the name of the course you want to search");
		return scanner.nextLine();
	}

	private int getCourseNum() {
		System.out.println("Please enter the course number");
		return scanner.nextInt();
	}

	public static void main (String [] args) {
		RegistrationApp myRegistrationApp = new RegistrationApp();
		myRegistrationApp.database.addStudent( new Student ("A", 1));
		myRegistrationApp.database.addStudent( new Student ("B", 2));
		myRegistrationApp.database.addStudent( new Student ("C", 3));
		myRegistrationApp.database.addStudent( new Student ("D", 4));
		myRegistrationApp.database.addStudent( new Student ("E", 5));
		myRegistrationApp.database.addStudent( new Student ("F", 6));
		myRegistrationApp.database.addStudent( new Student ("G", 7));
		myRegistrationApp.database.addStudent( new Student ("H", 8));
		myRegistrationApp.database.addStudent( new Student ("I", 9));
		myRegistrationApp.database.addStudent( new Student ("J", 10));
		myRegistrationApp.database.addStudent( new Student ("K", 11));

		myRegistrationApp.database.addCourse(new Course ("ENGG", 233)); //0
		myRegistrationApp.database.addCourse(new Course ("PHYS", 259)); //1
		myRegistrationApp.database.addCourse(new Course ("ENCM", 335)); //2
		myRegistrationApp.database.addCourse(new Course ("ENEL", 353)); //3
		myRegistrationApp.database.addCourse(new Course ("ENCM", 369)); //4
		myRegistrationApp.database.addCourse(new Course ("ENSF", 409)); //5
		myRegistrationApp.database.addCourse(new Course ("ENCM", 511)); //6

		myRegistrationApp.database.getCourseList().get(2).addPreReq(myRegistrationApp.database.getCourseList().get(0));
		myRegistrationApp.database.getCourseList().get(4).addPreReq(myRegistrationApp.database.getCourseList().get(2));
		myRegistrationApp.database.getCourseList().get(4).addPreReq(myRegistrationApp.database.getCourseList().get(3));
		myRegistrationApp.database.getCourseList().get(5).addPreReq(myRegistrationApp.database.getCourseList().get(2));
		myRegistrationApp.database.getCourseList().get(6).addPreReq(myRegistrationApp.database.getCourseList().get(4));

		myRegistrationApp.cat.createCourseOffering(myRegistrationApp.database.getCourseList().get(0), 1, 100);
		myRegistrationApp.cat.createCourseOffering(myRegistrationApp.database.getCourseList().get(0), 2, 100);
		myRegistrationApp.cat.createCourseOffering(myRegistrationApp.database.getCourseList().get(1), 1, 100);
		myRegistrationApp.cat.createCourseOffering(myRegistrationApp.database.getCourseList().get(1), 2, 100);
		myRegistrationApp.cat.createCourseOffering(myRegistrationApp.database.getCourseList().get(2), 1, 100);
		myRegistrationApp.cat.createCourseOffering(myRegistrationApp.database.getCourseList().get(3), 1, 100);
		myRegistrationApp.cat.createCourseOffering(myRegistrationApp.database.getCourseList().get(4), 1, 100);
		myRegistrationApp.cat.createCourseOffering(myRegistrationApp.database.getCourseList().get(5), 1, 100);
		myRegistrationApp.cat.createCourseOffering(myRegistrationApp.database.getCourseList().get(6), 1, 100);
		myRegistrationApp.menu();

		
	}


}
