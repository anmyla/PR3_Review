package i_Network.Network3_ConnectClientToServer;

import java.io.*;
import java.net.Socket;

public class ClientToServer {
    public static void main(String[] args) {
        // Specify the command to be sent to the server
        String command = "TIME";

        // Print a message indicating connection initiation
        System.out.println("Connecting to Server");

        try {
            // Create a socket and establish a connection to the server
            Socket socket = new Socket("time-a.timefreq.bldrdoc.gov", 13);

            // Create a BufferedReader to read from the server
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Print a message indicating reading from the server
            System.out.println("Reading from Server");

            // Print the first answer received from the server
            System.out.println("Server first answer: " + bufferedReader.readLine());

            // Create a BufferedWriter to write to the server
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            // Print a message indicating sending the command to the server
            System.out.println("Send command: " + command + " to Server");

            // Write the command to the server
            bufferedWriter.write(command);

            // Write a new line character to the server (important for some protocols)
            bufferedWriter.newLine();

            // Flush the writer to ensure the command is sent
            bufferedWriter.flush();

            // Print the command executed by the server
            System.out.println("Executed Command by Server: " + bufferedReader.readLine());

            // Print a message indicating the end of the connection
            System.out.println("End of connection");

        } catch (IOException e) {
            // Print the stack trace if an IOException occurs
            e.printStackTrace();
        }
    }


    public static void mainNoComment() {
        String command = "TIME";
        System.out.println("Connecting to Server");

        try {
            // Socket socket = new Socket("localhost", 9090); //connection to putty
            Socket socket = new Socket("time-a.timefreq.bldrdoc.gov", 13);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("Reading from Server");
            System.out.println("Server first answer: " + bufferedReader.readLine());
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            System.out.println("Send command: " + command + " to Server");
            bufferedWriter.write(command);
            bufferedWriter.newLine(); // important!
            bufferedWriter.flush();
            System.out.println("Executed Command by Server: " + bufferedReader.readLine());
            System.out.println("End of connection");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}