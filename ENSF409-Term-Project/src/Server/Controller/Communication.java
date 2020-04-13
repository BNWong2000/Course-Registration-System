package Server.Controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * A class to Communicate with the client.
 * @author Branden Wong - 30040675
 * @author Savipal Jessel - 30039257
 * @version 1.0
 */
public class Communication {

    /**
     * the client's socket
     */
    private Socket aSocket;

    /**
     * the object input stream from the client
     */
    private ObjectInputStream socketIn;

    /**
     * the object output stream to send to the client
     */
    private ObjectOutputStream socketOut;

    /**
     * the socket for the server.
     */
    private ServerSocket serverSocket;

    /**
     * the command parser, which manages commands from the client.
     */
    private CommandParser parser;

    /**
     * A constructor for the communication class.
     * @param port the port to connect to.
     * @param parser the command parser to use.
     */
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

    /**
     * gets the command parser
     * @return the command parser.
     */
    public CommandParser getParser(){
        return parser;
    }

    /**
     * A function used to communicate withe the client.
     * sends and receives objects from the client. 
     */
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
                 socketOut.writeObject(parser.doCommand(commandNum, objects));


            }
            catch(ClassNotFoundException e){
                e.printStackTrace();
            }catch(IOException e){
                e.printStackTrace();
            }

        }

}


}
