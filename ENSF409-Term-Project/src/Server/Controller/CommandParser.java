package Server.Controller;

import Server.Model.CourseCatalogue;
import Server.Model.DBManager;
import Util.Course;
import Util.CourseOffering;
import Util.Registration;
import Util.Student;

import java.util.ArrayList;

public class CommandParser {
    //private int numArguments;

    private CourseCatalogue cat;
    private DBManager database;

    public CommandParser(){
        database = new DBManager();
        cat = new CourseCatalogue (database);
    }

    public DBManager getDatabase(){
        return database;
    }

    public CourseCatalogue getCat(){
        return cat;
    }

    /**
     *
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
                return printStudentCourses(Integer.parseInt((String)info.get(0)));
            case "5":
                return addCourseToStudent((Student) info.get(0), (Course)info.get(1), (int)info.get(2));
            default:
                //invalid input
                return null;
        }
        //return null;

    }

    private String printStudentCourses(int id) {

        if (database.getStudent(id) == null)
            return null;
        return (database.getStudent(id)  + database.getStudent(id).registrationListToString());
    }

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
} //
