package Server.Controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.Executors;

public class Communication {

    private Socket aSocket;

    private ObjectInputStream socketIn;

    private ObjectOutputStream socketOut;

    private ServerSocket serverSocket;

    private CommandParser parser;

    public Communication(int port, CommandParser parser){
        try {
            serverSocket = new ServerSocket(port);
            aSocket = serverSocket.accept();
            System.out.println("The server is now running...");
            socketIn = new ObjectInputStream(aSocket.getInputStream());
            socketOut = new ObjectOutputStream((aSocket.getOutputStream()));
            this.parser = parser;

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public CommandParser getParser(){
        return parser;
    }
    public void communicate() {
        boolean quit = false;
        int numArgs = 0;
        String commandNum = "";
        while(!quit) {
            try {
                commandNum = (String) socketIn.readObject();
                numArgs = parser.parseCommand(commandNum);

                ArrayList<Object> objects = new ArrayList<>();
                for (int i = 0; i < numArgs; i++)
                    objects.add(socketIn.readObject());
                parser.doCommand(commandNum, objects);

            }
            catch(ClassNotFoundException e){
                e.printStackTrace();
            }catch(IOException e){
                e.printStackTrace();
            }

        }

}


}
