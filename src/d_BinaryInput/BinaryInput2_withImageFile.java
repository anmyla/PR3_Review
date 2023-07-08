package d_BinaryInput;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class BinaryInput2_withImageFile {
    public static void main(String[] args) throws IOException  {
        readBinary();
    }

    public static void readBinary() throws IOException {
        File file = new File("favicon.ico");
        FileInputStream inputFile = new FileInputStream(file);
        BufferedInputStream inputStream = new BufferedInputStream(inputFile);

        int byteRead;
        int counter = 0;
        while ((byteRead = inputStream.read()) != -1) {
            // char[] ch = Character.toChars(byteRead);
            // System.out.println(ch);
            // Byte wird in char umgewandelt und ausgegeben.
            System.out.print("Char: " + counter + " : ");
            System.out.print((int) ((char) byteRead));
//            System.out.print("'" + ((char) byteRead) + "'");
            System.out.println();
            counter++;
        }

        // close() gibt die Datei wieder frei.
        inputStream.close();
        System.out.println("\nTOTAL:  " + counter);
    }
}
