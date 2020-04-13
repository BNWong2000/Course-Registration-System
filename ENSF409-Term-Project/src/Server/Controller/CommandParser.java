package Server.Controller;

import Server.Model.Course;
import Server.Model.Student;

import java.util.ArrayList;

public class CommandParser {
    //private int numArguments;

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
}
