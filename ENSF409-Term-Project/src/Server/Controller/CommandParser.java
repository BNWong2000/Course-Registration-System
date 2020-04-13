package Server.Controller;

import Server.Model.CourseCatalogue;
import Server.Model.DBManager;
import Util.Course;
import Util.CourseOffering;
import Util.Registration;
import Util.Student;

import java.util.ArrayList;

/**
 * A class to parse commands from the client
 * @author Branden Wong - 30040675
 * @author Savipal Jessel - 30039257
 * @version 1.0
 */
public class CommandParser {

    /**
     * the course catalogue to read from
     */
    private CourseCatalogue cat;

    /**
     * the database to load information from
     */
    private DBManager database;

    /**
     * a constructor for this class.
     */
    public CommandParser(){
        database = new DBManager();
        cat = new CourseCatalogue (database);
    }

    /**
     * gets the database for this class
     * @return the database
     */
    public DBManager getDatabase(){
        return database;
    }

    /**
     * gets the course catalogue
     * @return the course catalogue
     */
    public CourseCatalogue getCat(){
        return cat;
    }

    /**
     * Parses the command number, and returns the number of objects that command needs.
     * @param commandNum
     * @return the number of objects to receive from the client
     */
    public int parseCommand(String commandNum){
        switch(commandNum){
            case "1":
                return 1;
                //break;
            case "2":
                return 0;
            case "3":
                return 2;
            case "4":
                return 1;
            case "5":
                return 3;
            default:
                //invalid input
                return 0;
        }
        //return 0;
    }

    /**
     * does the command, based on the command number.
     * @param commandNum the command number recieved from the client
     * @param info All the info needed to complete the command
     * @return the needed objects to send back to the client (dependant on the command)
     */
    public Object doCommand(String commandNum, ArrayList<Object> info){
        switch(commandNum){
            case "1":
                return searchCourseCatalogue((Course)info.get(0));
                //break;
            case "2":
                return cat.toString();
            case "3":
                return removeCourseFromStudent((Student)info.get(0), (Course)info.get(1));
            case "4":
                try{
                    return printStudentCourses(Integer.parseInt((String)info.get(0)));
                }catch(NumberFormatException e){
                    //System.err.print("invalid input");
                    return null;
                }
            case "5":
                return addCourseToStudent((Student) info.get(0), (Course)info.get(1), (int)info.get(2));
            default:
                //invalid input
                return null;
        }
        //return null;

    }

    /**
     * Prints the student's courses from their ID number.
     * @param id the ID number of the student
     * @return a string with the courses of the student
     */
    private String printStudentCourses(int id) {

        if (database.getStudent(id) == null)
            return null;
        return (database.getStudent(id)  + database.getStudent(id).registrationListToString());
    }

    /**
     * Searches the course catalogue for a course
     * @param course the course to search for
     * @return the course, if found.
     */
    private Course searchCourseCatalogue(Course course) {
        String name = course.getCourseName();
        int num = course.getCourseNum();
        System.out.println(name + " " + num);
        if(cat.searchCat(name, num) != null){
            System.out.println(cat.searchCat(name, num).toString());
            return cat.searchCat(name, num);
        }
        return null;
    }

    /**
     * Removes a student from a course
     * @param student the student
     * @param course the course to remove them from
     * @return the response to the client, determining success or failure/error
     */
    private String removeCourseFromStudent(Student student, Course course) {
        String courseName = course.getCourseName();
        int courseNum = course.getCourseNum();
        if(database.getStudent(student.getStudentId()) == null || database.getStudent(student.getStudentName()) == null || database.getStudent(student.getStudentName()).getStudentId() != student.getStudentId()){
            return "Student is not in our system!";
        }else{
            student = database.getStudent(student.getStudentId());
        }
        Course theCourse = cat.searchCat(courseName, courseNum);
        if(theCourse!= null){
            int id = student.getStudentId();
            if(database.getStudent(id) != null){
                if(student.isInCourse(courseName, courseNum)){
                    database.getStudent(id).removeFrom(courseName, courseNum);
                    return "Removed student from " + courseName + " " + courseNum;
                }else{
                    return "Student is not in this course. ";
                }
            }else{
                return "Could not perform this action!. ";
            }
        }
        return "An Error Occured. Unable to perform this action";
    }

    /**
     * Enrolls a student in a course
     * @param student the student to enroll
     * @param course the course to enroll the student into.
     * @param sectionNum the section number to enroll the student into.
     * @return the response to the client about the success or failure of this action.
     */
    private String addCourseToStudent(Student student, Course course, int sectionNum) {
        String courseName = course.getCourseName();
        int courseNum = course.getCourseNum();
        if(database.getStudent(student.getStudentId()) == null || database.getStudent(student.getStudentName()) == null || database.getStudent(student.getStudentName()).getStudentId() != student.getStudentId()){
            return "Student is not in our system!";
        }else{
            student = database.getStudent(student.getStudentId());
        }
        if(student.isInCourse(courseName, courseNum)){
            return "Student is already in this course.";
        }
        Course theCourse = cat.searchCat(courseName, courseNum);
        if(theCourse != null){
            int id = student.getStudentId();
            if(database.getStudent(id)!= null){
                Registration temp = new Registration();
                if(sectionNum > theCourse.getNumOfferings()){
                    return "Could not perform this action.";
                }
                if(theCourse.getCourseOfferingAt(sectionNum-1).isFull()){
                    theCourse.addOffering(new CourseOffering(sectionNum, 200));
                    temp.completeRegistration(database.getStudent(id), theCourse.getCourseOfferingAt(sectionNum));
                    return ("This Section is Full!\n Added student to " + courseName + " " + courseNum + " Section " + (sectionNum+1) + "instead");
                }else {
                    temp.completeRegistration(database.getStudent(id), theCourse.getCourseOfferingAt(sectionNum - 1));
                    return ("Added student to " + courseName + " " + courseNum + " Section " + sectionNum);
                }
            }
        }else{
            return ("Could not perform this action!. ");
        }
        return "An unexpected error occured. ";
    }
}
