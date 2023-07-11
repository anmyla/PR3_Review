package b_TextInput;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReader {

        public static void main(String[] args) throws IOException {

        // opens the file sample.txt
        File file = new File("umlaut.txt");
        // returns a text-oriented stream of the file
        FileReader fileReader = new FileReader(file);
        // creates a BufferedReader over the FileReader
        // This allows for more convenient/efficient access to the file.
        java.io.BufferedReader bufferedReader1 = new java.io.BufferedReader(fileReader);

        // OR
        java.io.BufferedReader br2 = new java.io.BufferedReader(new FileReader(new File("umlaut.txt")));
        java.io.BufferedReader br3 = new java.io.BufferedReader(new FileReader("umlaut.txt"));
        // Each line is read one by one. When the end of the file is reached, null is returned.
        String line;
        while ((line = bufferedReader1.readLine()) != null) {
            System.out.println(line);
        }
        // closes the bufferedReader
        bufferedReader1.close();
    }

}
