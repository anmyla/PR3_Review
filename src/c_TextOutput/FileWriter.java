package c_TextOutput;

import java.io.IOException;

public class FileWriter {
    public static void main(String args[]) {
        String data = "This is the data in the output file"; //to be written to the file that will be created

        try {
            // Creates a FileWriter
            java.io.FileWriter fileWriter = new java.io.FileWriter("fileWriter.txt");
            fileWriter.write(data);
            // Writes the string to the file
            fileWriter.flush();
            // Closes the writer
            fileWriter.close();
            System.out.println("File created.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
