package Client.Controller;

import Client.Model.Course;
import Client.Model.Student;

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
            //System.out.println("a");
            socketOut = new ObjectOutputStream((aSocket.getOutputStream()));
            //System.out.println("b");
            socketIn = new ObjectInputStream(aSocket.getInputStream());
            //System.out.println("c");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object communicate(Object object, String label){

        Object incomingObject = null;

        try{
            System.out.println("before");
            socketOut.writeObject(label);
            System.out.println("after");
            socketOut.writeObject(object);
            socketOut.flush();
            incomingObject = socketIn.readObject();

        } catch (IOException e) {
            // do something else
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return incomingObject;
    }

    public Object communicate(Student student, Course course, String label){

        Object incomingObject = null;

        try{
            socketOut.writeObject(label);
            socketOut.writeObject(student);
            socketOut.writeObject(course);
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
