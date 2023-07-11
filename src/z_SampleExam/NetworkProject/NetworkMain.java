package z_SampleExam.BinaryFile;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//can use terminal to test this.
//open a terminal window and enter this command line: nc localhost 8787
//8787 is the port you want to open
//then run this java program and watch the console.

public class NetworkMain {
        public static void main(String[] args) {
            System.out.println("Hello, here's the Network Project");

            try {
                ServerSocket serverSocket = new ServerSocket(8787); // waits for connection
                Socket clientSocket = serverSocket.accept();
                System.out.println("Hello, Client!");
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                System.out.println("Hello, Client!");
                String input = in.readLine();
                if (input != null) {
                    if (input.equals("h")) { //help!
                        out.println("Das ist die Hilfe");
                    } else if (input.equals("q")) { //bye!
                        System.out.println("Auf Wiedersehen");
                        System.out.println("Ende des Netzwerk-Projekts");
                        serverSocket.close();
                        System.exit(0);
                    }
                }
                // Ressourcen freigebe
                clientSocket.close();
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }