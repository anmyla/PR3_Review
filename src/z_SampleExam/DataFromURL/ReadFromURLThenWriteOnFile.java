package z_SampleExam.BinaryFile;

import java.io.*;
import java.net.URL;

public class ReadFromURLThenWriteOnFile {
    public static void main(String[] args) {
        try {
            System.out.println("Read file from : https://de.wikipedia.org/wiki/Objektorientierte_Programmierung");
            String user_url = "https://de.wikipedia.org/wiki/Objektorientierte_Programmierung";
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
                bufferedWriter.write(System.lineSeparator()); //Windows line separator
                bufferedWriter.newLine();
            }

            bufferedWriter.flush();
            bufferedWriter.close();
            br.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\nReading the data from the URL and writing the data on the file are successfully carried out...");
    }
}

