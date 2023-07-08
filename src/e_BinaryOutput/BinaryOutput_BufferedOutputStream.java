package e_BinaryOutput;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class BinaryOutput_BufferedOutputStream {

    public static void main(String[] args) throws IOException {
        File file = new File("test.neu");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

        bufferedOutputStream.write("Hello World".getBytes(StandardCharsets.UTF_8));
        bufferedOutputStream.write(System.lineSeparator().getBytes(StandardCharsets.UTF_8));
        bufferedOutputStream.write("New - line".getBytes(StandardCharsets.UTF_8));
        bufferedOutputStream.flush();
        bufferedOutputStream.close();

    }
}
