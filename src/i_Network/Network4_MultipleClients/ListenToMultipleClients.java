package i_Network.Network4_MultipleClients;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

/*This code represents a server that listens for multiple client connections
on port 9090. It accepts incoming client connections and creates a new thread
for each client to handle the communication task. The server socket has a timeout
of 30 seconds, and once the timeout occurs, the server stops accepting new
connections. The code also waits for all client threads to finish execution
before printing "ENDE" to indicate the end of the server process.*/


public class ListenToMultipleClients {
    public static void main(String[] args) {
        // Create a list to hold the threads for each client.
        List<Thread> clients = new ArrayList<>();

        System.out.println("Starte Server ...");

        ServerSocket serverSocket = null;
        try {
            // Create a server socket on port 9090.
            serverSocket = new ServerSocket(9090);
            // Set a timeout of 30 seconds for accepting client connections.
            serverSocket.setSoTimeout(30000); // 30 seconds
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                // Accept a client connection and create a new socket for communication.
                Socket socket = serverSocket.accept();
                // Create a new thread for the client communication task.
                Thread thread = new Thread(new CommunicationTask(socket));
                // Start the thread.
                thread.start();
                // Add the thread to the list of client threads.
                clients.add(thread);
            } catch (SocketTimeoutException e) {
                // Print a message indicating that the server has timed out.
                System.out.println("Server TIMEOUT");
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Wait for all client threads to finish execution.
        for (Thread t : clients) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("ENDE");
    }
}
