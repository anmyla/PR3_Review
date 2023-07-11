package i_Network.Network3_ConnectClientToServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ConnectToAddress {

    public static void main(String[] args) throws IOException {
        // Print a message indicating that the program is waiting for incoming connections
        System.out.println("Waiting for incoming connections - Connect using telnet localhost 9090...");

        // Establish a connection to the specified address and port
        Socket socket = new Socket("time-a.timefreq.bldrdoc.gov", 13);

        // Create a BufferedReader to read from the socket's input stream
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String response;
        // Read each line of response from the server until the end of stream is reached
        while ((response = bufferedReader.readLine()) != null) {
            System.out.println(response);
        }

        // Close the BufferedReader and the socket
        bufferedReader.close();
        socket.close();

        // Print a message indicating the successful completion of the task
        System.out.println("\nTask successfully carried out....");
    }

    public static void mainNoComment() throws IOException {
        System.out.println("Waiting for incoming connections - Connect using telnet localhost 9090...");

        Socket socket = new Socket("time-a.timefreq.bldrdoc.gov", 13); // Establishing connection to the specified address and port.

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String response;
        while ((response = bufferedReader.readLine()) != null) {
            System.out.println(response);
        }

        bufferedReader.close();
        socket.close();
        System.out.println("\nTask successfully carried out....");
    }
}
