package Client.Controller;



import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Communication {

    private Socket aSocket;

    private ObjectInputStream socketIn;

    private ObjectOutputStream socketOut;


    public Communication(String serverName, int portNumber) {
        try {
            aSocket = new Socket(serverName, portNumber);
            socketIn = new ObjectInputStream(aSocket.getInputStream());
            socketOut = new ObjectOutputStream((aSocket.getOutputStream()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object communicate(Object object, String label){

        Object incomingObject = null;

        try{
            socketOut.writeObject(object);
            socketOut.writeObject(label);
            socketOut.flush();
            incomingObject = socketIn.readObject();

        } catch (IOException e) {
            // do something else
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return incomingObject;
    }
}
