package Server;

import Server.Controller.CommandParser;
import Server.Controller.Communication;
import Server.Controller.Server;
import Util.Course;
import Util.Student;

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
		
		parser.getDatabase().addStudent( new Student("A", 1));
		parser.getDatabase().addStudent( new Student ("B", 2));
		parser.getDatabase().addStudent( new Student ("C", 3));
		parser.getDatabase().addStudent( new Student ("D", 4));
		parser.getDatabase().addStudent( new Student ("E", 5));
		parser.getDatabase().addStudent( new Student ("F", 6));
		parser.getDatabase().addStudent( new Student ("G", 7));
		parser.getDatabase().addStudent( new Student ("H", 8));
		parser.getDatabase().addStudent( new Student ("I", 9));
		parser.getDatabase().addStudent( new Student ("J", 10));
		parser.getDatabase().addStudent( new Student ("K", 11));

		parser.getDatabase().addCourse(new Course ("ENGG", 233)); //0
		parser.getDatabase().addCourse(new Course ("PHYS", 259)); //1
		parser.getDatabase().addCourse(new Course ("ENCM", 335)); //2
		parser.getDatabase().addCourse(new Course ("ENEL", 353)); //3
		parser.getDatabase().addCourse(new Course ("ENCM", 369)); //4
		parser.getDatabase().addCourse(new Course ("ENSF", 409)); //5
		parser.getDatabase().addCourse(new Course ("ENCM", 511)); //6

		parser.getDatabase().getCourseList().get(2).addPreReq(parser.getDatabase().getCourseList().get(0));
		parser.getDatabase().getCourseList().get(4).addPreReq(parser.getDatabase().getCourseList().get(2));
		parser.getDatabase().getCourseList().get(4).addPreReq(parser.getDatabase().getCourseList().get(3));
		parser.getDatabase().getCourseList().get(5).addPreReq(parser.getDatabase().getCourseList().get(2));
		parser.getDatabase().getCourseList().get(6).addPreReq(parser.getDatabase().getCourseList().get(4));

		parser.getCat().createCourseOffering(parser.getDatabase().getCourseList().get(0), 1, 100);
		parser.getCat().createCourseOffering(parser.getDatabase().getCourseList().get(0), 2, 100);
		parser.getCat().createCourseOffering(parser.getDatabase().getCourseList().get(1), 1, 100);
		parser.getCat().createCourseOffering(parser.getDatabase().getCourseList().get(1), 2, 100);
		parser.getCat().createCourseOffering(parser.getDatabase().getCourseList().get(2), 1, 100);
		parser.getCat().createCourseOffering(parser.getDatabase().getCourseList().get(3), 1, 100);
		parser.getCat().createCourseOffering(parser.getDatabase().getCourseList().get(4), 1, 100);
		parser.getCat().createCourseOffering(parser.getDatabase().getCourseList().get(5), 1, 100);
		parser.getCat().createCourseOffering(parser.getDatabase().getCourseList().get(6), 1, 100);
		//myRegistrationApp.menu();
		//communication.communicate();

		server.startServer(parser);
		
		
	}


}
