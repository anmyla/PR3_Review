package t_MySamples.TextInputOutput;

import java.io.*;

public class TextInput {
    public static void main(String[] args) throws IOException {
        System.out.println("Starting.......");
        readDataFromAString(); //method to read text input from a STRING
        System.out.println("Enter something and I will echo it until you enter STOP: ");
        readInputTillStopIsEntered(); //Method to read text Input from CONSOLE
        readDataFromFileIS(); //Method to read text input from FILE
    }


    //using InputStreamReader, this method will read System.in (user input)
    // until the user enter "STOP"
    public static void readInputTillStopIsEntered() throws IOException { //this method can throw an I0Exception
        // Ready to receive user Input
        //Creating an instance of InputStreamReader to convert the bytes into characters
        InputStreamReader inputStreamReader = new InputStreamReader(System.in); // the source of the data to be read is System.in(console)
        // Creates a BufferedReader over the InputStreamReader.
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        // It is read line by line.
        String line;
        while (!(line = bufferedReader.readLine()).equals("STOP")) {
            System.out.println(line);
        }

        //BufferedReader must be closed to release system resources.It's a good practice to close resources
        // explicitly to prevent resource leaks and to ensure efficient resource utilization.
        bufferedReader.close();
        // Information indicating that the program is finished.
        System.out.println("Closed");
    }

    public static void readDataFromFileIS() throws IOException {//read data from a file using InputStream
        //retrieves and opens the file to be read
        File file = new File("test.txt");
        //InputStream provides a way to read binary data from the given file above
        InputStream stream = new FileInputStream(file);
        //InputStreamReader converts the bytes into characters
        Reader reader = new java.io.InputStreamReader(stream);
        int data = reader.read();
        while (data != -1) {
            System.out.print((char) data); //int data will be casted to char
            data = reader.read();
        }
    }
    public static void readDataFromAString()  { //read data from a file using StringReader
        String srg = "Hello Java"; //the string we want to read and then print to the console

        // we create an instance of the StringReader to process character data from a string
        java.io.StringReader stringReader = new java.io.StringReader(srg);

        int c = 0;
        while (true) {
            try {
                // Read a character from the StringReader.
                // If the character read is not equal to -1 (end of stream),
                // continue to the next iteration of the loop.
                if (!((c = stringReader.read()) != -1)) break;
            } catch (IOException e) {
                // If an IOException occurs, throw a RuntimeException.
                throw new RuntimeException(e);

            }
            // Print the character that was read.
            System.out.print(" "+ (char) c);
        }
    }
}

