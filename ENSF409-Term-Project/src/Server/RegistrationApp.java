package Server;

import Server.Controller.CommandParser;
import Server.Controller.Communication;
import Util.Course;
import Util.Student;

public class RegistrationApp {
	public static void main (String [] args) {
		//RegistrationApp myRegistrationApp = new RegistrationApp();
		Communication communication = new Communication(8099,new CommandParser());
		
		communication.getParser().getDatabase().addStudent( new Student("A", 1));
		communication.getParser().getDatabase().addStudent( new Student ("B", 2));
		communication.getParser().getDatabase().addStudent( new Student ("C", 3));
		communication.getParser().getDatabase().addStudent( new Student ("D", 4));
		communication.getParser().getDatabase().addStudent( new Student ("E", 5));
		communication.getParser().getDatabase().addStudent( new Student ("F", 6));
		communication.getParser().getDatabase().addStudent( new Student ("G", 7));
		communication.getParser().getDatabase().addStudent( new Student ("H", 8));
		communication.getParser().getDatabase().addStudent( new Student ("I", 9));
		communication.getParser().getDatabase().addStudent( new Student ("J", 10));
		communication.getParser().getDatabase().addStudent( new Student ("K", 11));

		communication.getParser().getDatabase().addCourse(new Course ("ENGG", 233)); //0
		communication.getParser().getDatabase().addCourse(new Course ("PHYS", 259)); //1
		communication.getParser().getDatabase().addCourse(new Course ("ENCM", 335)); //2
		communication.getParser().getDatabase().addCourse(new Course ("ENEL", 353)); //3
		communication.getParser().getDatabase().addCourse(new Course ("ENCM", 369)); //4
		communication.getParser().getDatabase().addCourse(new Course ("ENSF", 409)); //5
		communication.getParser().getDatabase().addCourse(new Course ("ENCM", 511)); //6

		communication.getParser().getDatabase().getCourseList().get(2).addPreReq(communication.getParser().getDatabase().getCourseList().get(0));
		communication.getParser().getDatabase().getCourseList().get(4).addPreReq(communication.getParser().getDatabase().getCourseList().get(2));
		communication.getParser().getDatabase().getCourseList().get(4).addPreReq(communication.getParser().getDatabase().getCourseList().get(3));
		communication.getParser().getDatabase().getCourseList().get(5).addPreReq(communication.getParser().getDatabase().getCourseList().get(2));
		communication.getParser().getDatabase().getCourseList().get(6).addPreReq(communication.getParser().getDatabase().getCourseList().get(4));

		communication.getParser().getCat().createCourseOffering(communication.getParser().getDatabase().getCourseList().get(0), 1, 100);
		communication.getParser().getCat().createCourseOffering(communication.getParser().getDatabase().getCourseList().get(0), 2, 100);
		communication.getParser().getCat().createCourseOffering(communication.getParser().getDatabase().getCourseList().get(1), 1, 100);
		communication.getParser().getCat().createCourseOffering(communication.getParser().getDatabase().getCourseList().get(1), 2, 100);
		communication.getParser().getCat().createCourseOffering(communication.getParser().getDatabase().getCourseList().get(2), 1, 100);
		communication.getParser().getCat().createCourseOffering(communication.getParser().getDatabase().getCourseList().get(3), 1, 100);
		communication.getParser().getCat().createCourseOffering(communication.getParser().getDatabase().getCourseList().get(4), 1, 100);
		communication.getParser().getCat().createCourseOffering(communication.getParser().getDatabase().getCourseList().get(5), 1, 100);
		communication.getParser().getCat().createCourseOffering(communication.getParser().getDatabase().getCourseList().get(6), 1, 100);
		//myRegistrationApp.menu();
		communication.communicate();
		
	}


}
