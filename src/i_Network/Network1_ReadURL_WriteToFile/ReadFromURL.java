package i_Network.Network1_ReadURL_WriteToFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class ReadFromURL {
    public static void main(String[] args) {
        String oneLine;

        try {
            System.out.println("Main starting up......");
            System.out.println("Enter a URL:");
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            //String user_url = userInput.readLine();

            String user_url = "https://ipof.me";

            System.out.println("The following URL is received: " + " '" + user_url + "' ");
            //read URL
            URL myURL = new URL(user_url);
            InputStreamReader isr = new InputStreamReader(myURL.openStream());
            BufferedReader br = new BufferedReader(isr);


            while ((oneLine = br.readLine()) != null) {
                System.out.println(oneLine);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
