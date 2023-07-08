package i_Network.Network3_ConnectClientToServer;

import java.io.*;
import java.net.Socket;

public class ClientToServer {

    public static void main(String[] args) {
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