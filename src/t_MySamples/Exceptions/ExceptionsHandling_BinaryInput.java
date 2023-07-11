package t_MySamples.Exceptions;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExceptionsHandling_BinaryInput {
        public static void main(String[] args) {
            //Creates a File object representing the file named "test.txt".
            File file = new File("test.txt");
            //- Prints the absolute path to the file.
            System.out.println("Path to file: " + file.getAbsolutePath());
            // FileInputStream establishes a connection to the file. File is opened.
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                // For performance optimization, BufferedInputStream is used.
                BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
                // read() returns one byte at a time from the file. When the end is reached, the method returns -1 as the result.
                // The while loop reads character by character from the file.
                int byteRead; //Declares an integer variable to hold the byte read from the file.
                int i = 0; //Initializes a counter variable.
                while ((byteRead = bufferedInputStream.read()) != -1) { //Enters a while loop to read the file byte by byte until the end is reached.
                    //Output the character read from the file by converting
                    //the byte to a char and printing its integer value and character representation.
                    System.out.print("Character " + i + ": ");
                    System.out.print((int) ((char) byteRead));
                    System.out.println("\t'" + (char) byteRead + "'");
                    i++;
                }
                // Closes the BufferedInputStream to release system resources.
                bufferedInputStream.close();
            } catch (IOException e) { //- Catches any IOException that occurs during the file reading process.
                //Prints an error message indicating that an IOException occurred and includes the exception's message.
                System.out.println("Error, there was an IOException: " + e.getMessage());
            }
        }
    }
