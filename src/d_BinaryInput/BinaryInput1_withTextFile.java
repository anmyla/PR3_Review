package d_BinaryInput;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class BinaryInput1_withTextFile {
    public static void main(String[] args) throws IOException  {
        readBinary();

    }

    public static void readBinary() throws IOException {
        File file = new File("sample.txt");
        FileInputStream inputFile = new FileInputStream(file);
        BufferedInputStream inputStream = new BufferedInputStream(inputFile);

        int byteRead;
        while ((byteRead = inputStream.read()) != -1) {
            // char[] ch = Character.toChars(byteRead);
            // System.out.println(ch);
            // Byte wird in char umgewandelt und ausgegeben.
            System.out.println((char) byteRead);
        }

        // close() gibt die Datei wieder frei.
        inputStream.close();

    }
}
