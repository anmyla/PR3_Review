package z_SampleExam.BinaryFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class URLMain {
    public static void main(String[] args) throws IOException {
        binaryOutput();
    }
    public static void binaryOutput() throws IOException {
        File file = new File("hallo.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);

        int binary = 0x2B;

        for (int i = 0; i <= 20; i++) {
            fileOutputStream.write(binary);
        }
        fileOutputStream.flush();
        fileOutputStream.close();
        System.out.println("Job done!");
    }
}