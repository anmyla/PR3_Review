package e_BinaryOutput;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class BinaryOutput2 {
    public static void main(String[] args) throws IOException {

        binaryOutput2();
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
}
