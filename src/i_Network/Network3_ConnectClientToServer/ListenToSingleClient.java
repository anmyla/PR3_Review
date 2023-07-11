package i_Network.Network3_ConnectClientToServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ListenToSingleClient {
    // start via CommandLine (cmd): telnet localhost 9090
        public static void main(String[] args) throws IOException {
            // Print a message indicating that the program is waiting for incoming connections
            System.out.println("Warte auf eingehende Verbindungen - Verbinde mit telnet localhost 9090");

            // Create a ServerSocket that listens on port 9090
            ServerSocket serverSocket = new ServerSocket(9090);

            // Listen for a connection to be made to the ServerSocket and accept it
            Socket socket = serverSocket.accept();

            // Create a BufferedWriter to write to the socket's output stream
            BufferedWriter bufferedWriter =
                    new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            // Write "HELLO" to the socket
            bufferedWriter.write("HELLO");
            bufferedWriter.newLine();
            bufferedWriter.flush();

            // Create a BufferedReader to read from the socket's input stream
            BufferedReader bufferedReader
                    = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String command;
            // Read each line of command from the client until the end of stream is reached
            while ((command = bufferedReader.readLine()) != null) {
                System.out.println(command);

                // Process the received command
                if ("TIME".equals(command.toUpperCase())) {
                    // Get the current time from the calendar and write it to the socket
                    Calendar cal = GregorianCalendar.getInstance();
                    bufferedWriter.write(cal.get(Calendar.HOUR_OF_DAY) + " : " + cal.get(Calendar.MINUTE) + " : " + cal.get(Calendar.SECOND));
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                } else if ("PORT".equals(command.toUpperCase())) {
                    // Write the local port of the socket to the socket
                    bufferedWriter.write("PORT: " + socket.getLocalPort()); // -> 9090
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                } else if ("END".equals(command.toUpperCase())) {
                    // Write "BYE" to the socket and break out of the loop
                    bufferedWriter.write("BYE");
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                    break;
                } else if ("SING".equals(command.toUpperCase())) {
                    // Write a song lyric to the socket
                    bufferedWriter.write("Rah, rah, rah, ah ah! Roma, roma ah. ah! Ga, ga, oh la la!!!!");
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                } else {
                    // Write "unknown command" to the socket
                    bufferedWriter.write("unknown command");
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                }
            }

            // Close the BufferedReader, BufferedWriter, and the socket
            bufferedReader.close();
            bufferedWriter.close();

            // Print a message indicating the end of the program
            System.out.println("Beendet.");
        }

    public static void mainNoComment() throws IOException {
        System.out.println("Warte auf eingehende Verbindungen - Verbinde mit telnet localhost 9090");
        // We are working on localhost !!! = Hostname
        // We have configured Port 9090 for our ServerSocket Port
        // Test the Server Implementation with Putty Application or Telnet Command (see Tutorial within Moodle)
        ServerSocket serverSocket = new ServerSocket(9090);
        Socket socket = serverSocket.accept(); // Listens for a connection to be made to this socket and accepts it. The method blocks until a connection is made.

        BufferedWriter bufferedWriter =
                new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write("HELLO");
        bufferedWriter.newLine();
        bufferedWriter.flush();

        BufferedReader bufferedReader
                = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String command;
        while ((command = bufferedReader.readLine()) != null) {
            System.out.println(command);

            if ("TIME".equals(command.toUpperCase())) {
                Calendar cal = GregorianCalendar.getInstance();
                bufferedWriter.write(cal.get(Calendar.HOUR_OF_DAY) + " : " + cal.get(Calendar.MINUTE) + " : " + cal.get(Calendar.SECOND));
                bufferedWriter.newLine();
                bufferedWriter.flush();
            } else if ("PORT".equals(command.toUpperCase())) {
                bufferedWriter.write("PORT: " + socket.getLocalPort()); // -> 9090
                bufferedWriter.newLine();
                bufferedWriter.flush();
            } else if ("END".equals(command.toUpperCase())) {
                bufferedWriter.write("BYE");
                bufferedWriter.newLine();
                bufferedWriter.flush();
                break;
            } else if ("SING".equals(command.toUpperCase())) {
                bufferedWriter.write("Rah, rah, rah, ah ah! Roma, roma ah. ah! Ga, ga, oh la la!!!!");
                bufferedWriter.newLine();
                bufferedWriter.flush();
            } else {
                bufferedWriter.write("unknown command");
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        }

        bufferedReader.close();
        bufferedWriter.close();
        System.out.println("Beendet.");
    }
}