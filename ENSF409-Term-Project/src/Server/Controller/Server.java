package Server.Controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * A class used to run the server and manage multiple clients connecting to the server.
 */
public class Server {

    /**
     * the threadpool that manages clients using the server
     */
    private ExecutorService pool;

    /**
     * the socket for the server.
     */
    private ServerSocket serverSocket;

    /**
     * Consctructor for the Server. Creates the ThreadPool and initializes the server.
     * @param port the port to connect the server to.
     */
    public Server(int port){
        try {
            pool = Executors.newCachedThreadPool();
            serverSocket = new ServerSocket(port);
            System.out.println("The server is now running...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * A function which starts the server and accepts clients as they connect
     * @param parser the command parser to manage the commands of the client.
     */
    public void startServer(CommandParser parser){
        try{
            while(true){
                Communication communication = new Communication(serverSocket.accept(), parser);
                System.out.println("Client Accepted. ");
                pool.execute(communication);
            }
        }catch (IOException e){
            System.out.print(e.getMessage());
            pool.shutdown();
        }
    }
}
