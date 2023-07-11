package t_MySamples.Network;

import java.io.*;
import java.net.URL;

public class ReadFromURLWriteToFile {
    public static void main(String[] args) {

    }
    public static void readFromURL() {
        String oneLine;

        try {
            System.out.println("Main starting up......");
            System.out.println("Enter a URL:");

            // Create a BufferedReader to read user input from the console
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            // Uncomment the next line to read URL from user input
            // String user_url = userInput.readLine();

            // Alternatively, use a predefined URL for testing
            String user_url = "https://ipof.me";

            System.out.println("The following URL is received: '" + user_url + "'");

            // Read the content from the URL

            // Create a URL object based on the user-provided URL
            URL myURL = new URL(user_url);

            // Create an InputStreamReader by opening a connection to the URL and obtaining its input stream
            InputStreamReader isr = new InputStreamReader(myURL.openStream());

            // Create a BufferedReader to read the content from the InputStreamReader
            BufferedReader br = new BufferedReader(isr);

            // Read and print each line from the URL
            while ((oneLine = br.readLine()) != null) {
                System.out.println(oneLine);
            }

            // Close the BufferedReader and release system resources
            br.close();
        } catch (IOException e) {
            // If an IOException occurs, wrap it in a RuntimeException and throw it
            throw new RuntimeException(e);
        }
    }

    public static void  writeToFile() {
            try {
                System.out.println("Main starting up......");
                System.out.println("Enter a URL:");

                // Create a BufferedReader to read user input from the console
                BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

                // Uncomment the next line to read URL from user input
                // String user_url = userInput.readLine();

                // Alternatively, use a predefined URL for testing
                String user_url = "https://ipof.me";

                System.out.println("The following URL is received: '" + user_url + "'");

                // Read the content from the URL

                // Create a URL object based on the user-provided URL
                URL myURL = new URL(user_url);

                // Create an InputStreamReader by opening a connection to the URL and obtaining its input stream
                InputStreamReader isr = new InputStreamReader(myURL.openStream());

                // Create a BufferedReader to read the content from the InputStreamReader
                BufferedReader br = new BufferedReader(isr);

                // Create a FileWriter to write the content to an HTML file
                FileWriter fileWriter = new FileWriter("content.html"); //in the parameter, we can put the name of the file created above.

                // Create a BufferedWriter to write the content to the FileWriter
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                String oneLine;
                while ((oneLine = br.readLine()) != null) {
                    System.out.println(oneLine);
                    bufferedWriter.write(oneLine);
                    bufferedWriter.newLine();
                }

                // Flush and close the BufferedWriter and BufferedReader
                bufferedWriter.flush();
                bufferedWriter.close();
                br.close();

            } catch (IOException e) {
                // If an IOException occurs, wrap it in a RuntimeException and throw it
                throw new RuntimeException(e);
            }

            System.out.println("\nDisplaying on the console and creating an HTML file are successfully carried out...");
        }
}
