package g_Exceptions.Finally;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public final class SimpleFinally {

    public static void main(String... args) throws IOException {
        simpleFinally("sample.txt");
    }

    private static void simpleFinally(String fileName) throws IOException {
        //If this line throws an exception, then neither the try block
        //nor the finally block will execute.
        //That's a good thing, since reader would be null.
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        try {
            //Any exception in the try block will cause the finally block to execute
            String line = null;
            while ((line = reader.readLine()) != null) {
                //process the line...
            }
        } finally {
            //The reader object will never be null here.
            //This finally is only entered after the try block is
            //entered. But, it's NOT POSSIBLE to enter the try block
            //with a null reader object.
            reader.close();
        }
    }
}