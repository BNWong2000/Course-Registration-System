package Server;

import Server.Controller.CommandParser;
import Server.Controller.Communication;
import Server.Controller.DBController;
import Server.Controller.Server;
import Util.Course;
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
		
		ArrayList<Student> students = new ArrayList<>();
		ArrayList<Course> courses = new ArrayList<>();
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


		//parser.getDbController().getStudentDB().populateStudentDatabase(students);
		parser.getDbController().getStudentDB().setStudents(students);
		//parser.getDbController().getCourseDB().populateCourseDatabase(courses);
		parser.getDbController().getCourseDB().setCourses(courses);

		parser.getDbController().getCourseDB().getCourses().get(2).addPreReq(parser.getDbController().getCourseDB().getCourses().get(0));
		parser.getDbController().getCourseDB().getCourses().get(4).addPreReq(parser.getDbController().getCourseDB().getCourses().get(2));
		parser.getDbController().getCourseDB().getCourses().get(4).addPreReq(parser.getDbController().getCourseDB().getCourses().get(3));
		parser.getDbController().getCourseDB().getCourses().get(5).addPreReq(parser.getDbController().getCourseDB().getCourses().get(2));
		parser.getDbController().getCourseDB().getCourses().get(6).addPreReq(parser.getDbController().getCourseDB().getCourses().get(4));

		parser.getCat().createCourseOffering(parser.getDbController().getCourseDB().getCourses().get(0), 1, 100);
		parser.getCat().createCourseOffering(parser.getDbController().getCourseDB().getCourses().get(0), 2, 100);
		parser.getCat().createCourseOffering(parser.getDbController().getCourseDB().getCourses().get(1), 1, 100);
		parser.getCat().createCourseOffering(parser.getDbController().getCourseDB().getCourses().get(1), 2, 100);
		parser.getCat().createCourseOffering(parser.getDbController().getCourseDB().getCourses().get(2), 1, 100);
		parser.getCat().createCourseOffering(parser.getDbController().getCourseDB().getCourses().get(3), 1, 100);
		parser.getCat().createCourseOffering(parser.getDbController().getCourseDB().getCourses().get(4), 1, 100);
		parser.getCat().createCourseOffering(parser.getDbController().getCourseDB().getCourses().get(5), 1, 100);
		parser.getCat().createCourseOffering(parser.getDbController().getCourseDB().getCourses().get(6), 1, 100);
		//myRegistrationApp.menu();
		//communication.communicate();

		server.startServer(parser);
		
		
	}


}
