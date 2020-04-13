package Client.Controller;

import Util.Course;
import Util.Student;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Manages the communications of the client with the server.
 *
 * @author Branden Wong - 30040675
 * @author Savipal Jessel - 30039257
 *
 * @version 1.0
 */
public class Communication {

    /**
     * Socket used for interfacing between the Client and Server
     */
    private Socket aSocket;

    /**
     * Object input stream for getting objects from the Server
     */
    private ObjectInputStream socketIn;

    /**
     * Object output stream for sending objects to the Server
     */
    private ObjectOutputStream socketOut;

    /**
     * Constructs a Client Object that sets-up the connection and I/O streams with the Server
     *
     * @param serverName name of the Server
     * @param portNumber port that the client will be communicating over
     */
    public Communication(String serverName, int portNumber) {
        try {
            aSocket = new Socket(serverName, portNumber);
            socketOut = new ObjectOutputStream((aSocket.getOutputStream()));
            socketIn = new ObjectInputStream(aSocket.getInputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sends a String command to the server and receives a string with the results of the command.
     *
     * @param label the command label
     * @return the results of the command
     */
    public String communicate(String label) {
        Object incomingObject = null;
        try {

            socketOut.writeObject(label);
            socketOut.flush();
            incomingObject = socketIn.readObject();
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (String) incomingObject;

    }

    /**
     * Sends a String command and object to the server and receives an object with the results of the command.
     * <p>
     * Note this will send either a student or course object.
     *
     * @param object the object to be sent to the server
     * @param label  the command label
     * @return the results of the command
     */
    public Object communicate(Object object, String label) {


        Object incomingObject = null;

        try {

            socketOut.writeObject(label);

            socketOut.writeObject(object);

            socketOut.flush();

            incomingObject = socketIn.readObject();


        } catch (IOException e) {
            // do something else
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NullPointerException ignored) {

        }

        return incomingObject;
    }

    /**
     * Sends a String command, student object, and course object to the server and receives an object with the results of the command.
     *
     * @param student the student object
     * @param course  the course object
     * @param label   the command label
     * @return the results of the command
     */
    public Object communicate(Student student, Course course, String label) {

        Object incomingObject = null;

        try {
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

    /**
     * Sends a String command, student object, course object, and section number to the server and receives an object with the results of the command.
     *
     * @param student    the student object
     * @param course     the course object
     * @param sectionNum the section number corresponding to the course
     * @param label      the command label
     * @return the results of the command
     */
    public Object communicate(Student student, Course course, Integer sectionNum, String label) {

        Object incomingObject = null;

        try {
            socketOut.writeObject(label);
            socketOut.writeObject(student);
            socketOut.writeObject(course);
            socketOut.writeObject(sectionNum);
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
