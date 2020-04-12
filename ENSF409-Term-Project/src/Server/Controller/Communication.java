package Server.Controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Communication {

    private Socket aSocket;

    private ObjectInputStream socketIn;

    private ObjectOutputStream socketOut;

    private ServerSocket serverSocket;

    private CommandParser parser;

    public Communication(){

    }



}
