package b_TextInput;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReader_CharByChar {
    public static void main(String[] args) throws IOException {
        // opens the file test.txt
        File file = new File("sample.txt");
        // returns a text-oriented stream of the file
        FileReader fileReader = new FileReader(file);
        // creates a BufferedReader over the FileReader
        // This allows for more convenient access to the file.
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        // Each character is read one by one.
        // When the end of the file is reached, -1 is returned.

        int c;
        while ((c = bufferedReader.read()) != -1) {
            // The int value needs to be casted to char in order to obtain characters. (Otherwise, only numbers)
            char character = (char) c;
            System.out.println("int: " + c + " -> char: " + character);
        }
        // closes the bufferedReader
        bufferedReader.close();
    }
}



