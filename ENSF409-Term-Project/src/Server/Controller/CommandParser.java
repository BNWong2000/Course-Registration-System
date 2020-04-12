package Server.Controller;

public class CommandParser {
    private int numArguments;

    public int parseCommand(String commandNum){
        switch(commandNum){
            case "1":
                numArguments = 1;
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
                return -1;
        }
        return Integer.parseInt(commandNum);
    }
}
