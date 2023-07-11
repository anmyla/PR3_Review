package i_Network.Network4_MultipleClients;


import java.io.*;
import java.net.Socket;
import java.util.Calendar;
import java.util.GregorianCalendar;

/*This code represents a task that can be executed by a thread.
It reads commands from a client, performs different actions based
on the commands, and sends corresponding responses back to the client.*/
public class CommunicationTask implements Runnable {
    // Declare a private instance variable 'socket' of type Socket.
    private Socket socket;

    // Constructor that takes a Socket object and assigns it to the 'socket' variable.
    public CommunicationTask(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Set the name of the current thread to "Client Port" followed by the port number of the client's socket.
        Thread.currentThread().setName("Client Port " + socket.getPort());

        // Print a log message indicating that the current thread has started.
        System.out.println(Thread.currentThread().getName() + " wurde gestartet.");

        try {
            // Create a BufferedWriter to write server responses to the client.
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            // Write "HELLO" to the client.
            bufferedWriter.write("HELLO");
            // Write a new line character.
            bufferedWriter.newLine();
            // Flush the buffer to send the message immediately.
            bufferedWriter.flush();

            // Create a BufferedReader to read input from the client.
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String command;

            // Read lines from the client until the connection is closed.
            while ((command = bufferedReader.readLine()) != null) {
                // Print a log message indicating the current command being executed by the thread.
                System.out.println(Thread.currentThread().getName() + " führt folgendes Kommando aus -> " + command);

                // Check the command received from the client and respond accordingly.
                if ("TIME".equals(command)) {
                    // Get the current time using the Calendar class.
                    Calendar cal = GregorianCalendar.getInstance();
                    // Write the current time to the client.
                    bufferedWriter.write(cal.get(Calendar.HOUR_OF_DAY) + " : " + cal.get(Calendar.MINUTE) + " : " + cal.get(Calendar.SECOND));
                    // Write a new line character.
                    bufferedWriter.newLine();
                    // Flush the buffer to send the message immediately.
                    bufferedWriter.flush();
                } else if ("PORT".equals(command)) {
                    // Write the local port of the server socket to the client.
                    bufferedWriter.write("PORT: " + socket.getLocalPort()); // -> 9090
                    // Write a new line character.
                    bufferedWriter.newLine();
                    // Flush the buffer to send the message immediately.
                    bufferedWriter.flush();
                } else if ("END".equals(command)) {
                    // Write "BYE" to the client.
                    bufferedWriter.write("BYE");
                    // Write a new line character.
                    bufferedWriter.newLine();
                    // Flush the buffer to send the message immediately.
                    bufferedWriter.flush();
                    // Exit the loop and end the thread.
                    break;
                } else {
                    // Write "unknown command" to the client for unrecognized commands.
                    bufferedWriter.write("unknown command");
                    // Write a new line character.
                    bufferedWriter.newLine();
                    // Flush the buffer to send the message immediately.
                    bufferedWriter.flush();
                }
            }

            // Close the BufferedReader and BufferedWriter.
            bufferedReader.close();
            bufferedWriter.close();

            // Print a log message indicating that the current thread has ended.
            System.out.println(Thread.currentThread().getName() + " wurde beendet.");
        } catch (IOException e) {
            // Print the stack trace if an IOException occurs.
            e.printStackTrace();
        }
    }
}

}
