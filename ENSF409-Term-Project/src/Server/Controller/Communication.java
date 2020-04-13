package Server.Controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;

public class Communication {

    private Socket aSocket;

    private ObjectInputStream socketIn;

    private ObjectOutputStream socketOut;

    private ServerSocket serverSocket;

    private CommandParser parser;

    public Communication(int port){
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("The server is now running...");
            socketIn = new ObjectInputStream(aSocket.getInputStream());
            socketOut = new ObjectOutputStream((aSocket.getOutputStream()));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private Object communicate(){
        boolean quit = false;
<<<<<<< HEAD
        int numArgs = 0;
        while(!quit){
        try {
            if (socketIn.readObject() != null)
                numArgs = parser.parseCommand((String)socketIn.readObject());
            for (int i = 0; i < numArgs; i++)

        }
=======
        while(!quit){
            try {
                if (socketIn.readObject() != null)
                    parser.parseCommand((String)socketIn.readObject());
>>>>>>> 63797180219721f7229f3926ab0e67b653268aae

            }

            catch(IOException e){
                e.printStackTrace();
            }

            catch(ClassNotFoundException e){
                e.printStackTrace();
            }
        }
    }
}


}
