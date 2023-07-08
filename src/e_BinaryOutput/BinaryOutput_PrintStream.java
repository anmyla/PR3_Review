package e_BinaryOutput;

import java.io.IOException;
import java.io.PrintStream;

public class BinaryOutput_PrintStream {

    public static void main(String[] args) throws IOException {
        String data = "das ist ein Test";
        PrintStream output = new PrintStream("test.txt");
        output.print(data);
        output.flush();
        output.close();
    }
}
