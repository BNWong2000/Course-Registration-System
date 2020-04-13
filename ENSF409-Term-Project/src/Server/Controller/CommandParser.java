package Server.Controller;

import Server.Model.CourseCatalogue;
import Server.Model.DBManager;
import Util.Course;
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
                break;
            case "5":
                break;
            default:
                //invalid input
                return 0;
        }
        return 0;
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
                break;
            case "5":
                break;
            default:
                //invalid input
                return null;
        }
        return null;

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
}
