package Server.Controller;

import Server.Model.CourseCatalogue;
import Server.Model.DBManager;
import Util.Course;

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
                break;
            case "3":
                break;
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

    public void doCommand(String commandNum, ArrayList<Object> info){
        switch(commandNum){
            case "1":
                searchCourseCatalogue((Course)info.get(0));
                break;
            case "2":
                break;
            case "3":
                break;
            case "4":
                break;
            case "5":
                break;
            default:
                //invalid input
                return;
        }

    }

    private void searchCourseCatalogue(Course course) {
        String name = course.getCourseName();
        int num = course.getCourseNum();
        System.out.println(name + " " + num);
        if(cat.searchCat(name, num) != null){
            System.out.println(cat.searchCat(name, num).toString());
        }
    }
}
