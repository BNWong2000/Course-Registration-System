package Client.Controller;

import Util.Course;
import Util.Student;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

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

    public Object communicate(ArrayList<Object> objects, ArrayList<Object> data, String label){
        Object incomingObject = null;

        try{
            socketOut.writeObject(label);
            for (Object o: objects)
                socketOut.writeObject(o);
            for (Object o: data)
                socketOut.writeObject(o);

            socketOut.flush();
            incomingObject = socketIn.readObject();
        }

        catch (IOException e) {
            // do something else
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return incomingObject;
    }


    public String communicate(String label){
        Object incomingObject = null;
        try{

            socketOut.writeObject(label);
            socketOut.flush();
            incomingObject = socketIn.readObject();
        }

        catch(IOException e){
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        return (String) incomingObject;

    }
    public Object communicate(Object object, String label){


        Object incomingObject = null;

        try{

                socketOut.writeObject(label);

                socketOut.writeObject(object);

                socketOut.flush();

                incomingObject = socketIn.readObject();


        } catch (IOException e) {
            // do something else
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch(NullPointerException ignored){

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

    public Object communicate(Student student, Course course, Integer sectionNum, String label){

        Object incomingObject = null;

        try{
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
