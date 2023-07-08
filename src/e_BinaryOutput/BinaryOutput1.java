package e_BinaryOutput;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class BinaryOutput1 {
    public static void main(String[] args) throws IOException {
        binaryOutput();
    }
    public static void binaryOutput() throws IOException {
        File file = new File("b_output1.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);

        String outputText = "It works! :)";

        for (char c: outputText.toCharArray()) {
            System.out.println("Write char " + (int) c + " in the file.");
            fileOutputStream.write(c);
        }

        fileOutputStream.flush();
        fileOutputStream.close();
        System.out.println("Job done!");
    }
}
