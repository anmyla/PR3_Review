package i_Network.Network1_ReadURL_WriteToFile;

import java.io.*;
import java.net.URL;

public class ReadURLWriteFile {
    public static void main(String[] args) {

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

            //File fileName = new File(pathName+fileName)
            FileWriter fileWriter = new FileWriter("content.html"); //in the parameter, we can put the name of the file created above.
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String oneLine;
            while ((oneLine = br.readLine()) != null) {
                System.out.println(oneLine);
                bufferedWriter.write(oneLine);
                bufferedWriter.newLine();
            }

            bufferedWriter.flush();
            bufferedWriter.close();
            br.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\nDisplaying on the console and creating an HTML file are successfully carried out...");

    }
}

