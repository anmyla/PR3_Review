package i_Network.Network3_ConnectClientToServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ConnectToAddress {
    public static void main(String[] args) throws IOException {
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
