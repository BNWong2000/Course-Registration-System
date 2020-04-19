package Server;

import Server.Controller.CommandParser;
import Server.Controller.Server;
import Util.Course;
import Util.CourseOffering;
import Util.Student;

import java.util.ArrayList;

/**
 * The main application on the server side.
 * @author Branden Wong - 30040675
 * @author Savipal Jessel - 30039257
 * @version 1.0
 */
public class RegistrationApp {
	public static void main (String [] args) {
		//RegistrationApp myRegistrationApp = new RegistrationApp();
		CommandParser parser = new CommandParser();
		Server server = new Server(8099);
/*
		ArrayList<Student> students = new ArrayList<>();
		ArrayList<Course> courses = new ArrayList<>();
		ArrayList<CourseOffering> offerings = new ArrayList<>();

		students.add( new Student("A", 1));
		students.add( new Student ("B", 2));
		students.add( new Student ("C", 3));
		students.add( new Student ("D", 4));
		students.add( new Student ("E", 5));
		students.add( new Student ("F", 6));
		students.add( new Student ("G", 7));
		students.add( new Student ("H", 8));
		students.add( new Student ("I", 9));
		students.add( new Student ("J", 10));
		students.add( new Student ("K", 11));

		courses.add(new Course ("ENGG", 233)); //0
		courses.add(new Course ("PHYS", 259)); //1
		courses.add(new Course ("ENCM", 335)); //2
		courses.add(new Course ("ENEL", 353)); //3
		courses.add(new Course ("ENCM", 369)); //4
		courses.add(new Course ("ENSF", 409)); //5
		courses.add(new Course ("ENCM", 511)); //6

		offerings.add(new CourseOffering( 1, 100));
		offerings.add(new CourseOffering( 1, 100));
		offerings.add(new CourseOffering( 1, 100));
		offerings.add(new CourseOffering( 1, 100));
		offerings.add(new CourseOffering( 1, 100));
		offerings.add(new CourseOffering( 1, 100));
		offerings.add(new CourseOffering( 1, 100));
		offerings.add(new CourseOffering( 1, 100));
		offerings.add(new CourseOffering( 1, 100));
		offerings.add(new CourseOffering( 2, 100));
		offerings.add(new CourseOffering( 2, 100));
		offerings.add(new CourseOffering( 2, 100));
		offerings.add(new CourseOffering( 2, 100));
		offerings.add(new CourseOffering( 2, 100));
		offerings.add(new CourseOffering( 2, 100));
		offerings.add(new CourseOffering( 2, 100));
		offerings.add(new CourseOffering( 2, 100));
		offerings.add(new CourseOffering( 2, 100));

		// If you want to populate the database for the first time or if you've
		// deleted your tables, uncomment the following lines
		parser.getDatabase().getStudentDB().populateStudentDatabase(students);
		parser.getDatabase().getCourseDB().populateCourseDatabase(courses);
		parser.getDatabase().getOfferingDB().populateOfferingDatabase(offerings);*/

		parser.getDatabase().loadFromDataBase();
		parser.getCat().readCourseList();
		parser.getCat().createCourseOfferings();

		parser.getDatabase().getCourseList().get(2).addPreReq(parser.getDatabase().getCourseList().get(0));
		parser.getDatabase().getCourseList().get(4).addPreReq(parser.getDatabase().getCourseList().get(2));
		parser.getDatabase().getCourseList().get(4).addPreReq(parser.getDatabase().getCourseList().get(3));
		parser.getDatabase().getCourseList().get(5).addPreReq(parser.getDatabase().getCourseList().get(2));
		parser.getDatabase().getCourseList().get(6).addPreReq(parser.getDatabase().getCourseList().get(4));



		//myRegistrationApp.menu();
		//communication.communicate();

		server.startServer(parser);
		
		
	}


}
