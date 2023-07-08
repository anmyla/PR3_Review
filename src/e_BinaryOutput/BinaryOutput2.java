package e_BinaryOutput;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


/*

Java FileOutputStream is an output stream used for writing data to a file.

If you have to write primitive values into a file,
use FileOutputStream class. You can write byte-oriented as
well as character-oriented data through FileOutputStream class.
But, for character-oriented data, it is preferred to use FileWriter
than FileOutputStream.

 */
public class BinaryOutput2 {
    public static void main(String[] args) throws IOException {

        binaryOutput2();
        classSolution();
    }

    public static void binaryOutput2() throws IOException {
        System.out.println("Enter something: ");
        File file = new File("b_output1.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        char c = (char) System.in.read();



        while (c != 'x' && c != 'X') {
            fileOutputStream.write(c);
            System.out.println("print on console: " + (int) c);
            c = (char) System.in.read();
            if (c == 'x' || c == 'X') {
                System.out.println("X END X");
            }
        }

        fileOutputStream.flush();
        fileOutputStream.close();
    }


    public static void classSolution() throws IOException {
        File file = new File("sample.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);

        char c;
        while ((c = (char) System.in.read()) != 'x') {
            fileOutputStream.write(c);
            System.out.println(c);
        }
        fileOutputStream.flush();
        fileOutputStream.close();
        System.out.println("Closed");
    }
}
